/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.extracaoHTML;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import projetolattes.util.Utilidades;
import projetolattes.beans.CurriculoLattes;
import projetolattes.beans.Producao;
import projetolattes.beans.TipoProducao;
import projetolattes.beans.Banca;
import projetolattes.beans.Orientacao;
import projetolattes.beans.SubTipoBanca;
import projetolattes.beans.TipoBanca;
import projetolattes.beans.TipoOrientacao;
import projetolattes.util.Main;

/**
 * Classe responsável por extarir o lattes
 * @author Thatiany Lima e Aline Gonçalves
 */
public class ExtracaoLattes {

    private static Logger log = Logger.getLogger(ExtracaoLattes.class.getName());

    /**
     * Define os regex padrões de producao
     */
    private static String[] padroesProducao = {
        RegexConfig.REGEX_PRODUCAO_TRABALHO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_PRODUCAO_CAPITULOS + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_PRODUCAO_ARTIGO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_PRODUCAO_LIVRO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
    };

    /**
     * Define os tipos de produção
     */
    private static TipoProducao[] tiposProducao = {
        new TipoProducao(0, "Trabalhos"),
        new TipoProducao(1, "Capítulos"),
        new TipoProducao(2, "Artigos"),
        new TipoProducao(3, "Livros"),
    };

    /**
     * Define os regex padrões da banca
     */
    private static String[] padroesBanca = {
        RegexConfig.REGEX_BANCA_EXAMINADORA_INICIO + ".*?" + RegexConfig.REGEX_BANCA_EXAMINADORA_FIM,
        RegexConfig.REGEX_BANCA_JULGADORA_INICIO + ".*?" + RegexConfig.REGEX_BANCA_JULGADORA_FIM
    };

    /**
     * Define os tipos de Banca
     */
    private static TipoBanca[] tiposBanca = {
        new TipoBanca(0, "Examinadora"),
        new TipoBanca(1, "Julgadora")
    };

    /**
     * Define os regex padrões para orientação
     */
    private static String[] padroesOrientacao = {
        RegexConfig.REGEX_ORIENTACAO_GRADUACAO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_ORIENTACAO_ESPECIALIZACAO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_ORIENTACAO_MESTRADO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO,
        RegexConfig.REGEX_ORIENTACAO_DOUTORADO + ".*?" + RegexConfig.REGEX_LATTES_FIM_TEXTO
    };

    /**
     * Define os tipos de orientação
     */
    private static TipoOrientacao[] tiposOrientacao = {
        new TipoOrientacao(0, "Graduação"),
        new TipoOrientacao(1, "Especialização"),
        new TipoOrientacao(2, "Mestrado"),
        new TipoOrientacao(3, "Doutorado"),
    };

    private static String[] padroesStatusOrientacao = {
        RegexConfig.REGEX_ORIENTACAO_ANDAMENTO_INICIO + ".*?" + RegexConfig.REGEX_ORIENTACAO_ANDAMENTO_FIM,
        RegexConfig.REGEX_ORIENTACAO_CONCLUIDA_INICIO + ".*?" + RegexConfig.REGEX_ORIENTACAO_CONCLUIDA_FIM
    };

    /**
     * Define os possíveis status da orientação
     */
    private static String[] statusOrientacao = {
        "Em andamento",
        "Concluída"
    };

    /**
     * Recebe um link do cv Lattes e retorna o objeto lattes
     * @param link
     * @return
     */
    public static CurriculoLattes extrair(String link) throws Exception{

        // Extrai o HTML e retira as entidades HTML de acentos
        String html = Utilidades.abrirUrl(link);

        // Cria o objeto a ser retornado e o preenche ao decorrer do método
        CurriculoLattes cl = new CurriculoLattes();

        // Seta os dados do curriculo lattes
        cl.setLink(link);
        cl.setProducoes(extrairProducoes(html));
        cl.setBancas(extrairBancas(html));
        cl.setOrientacoes(extrairOrientacoes(html));
        cl.setDataAtualizacao(extrairDataUltimaAtualizacao(html));

        return cl;
    }

    /**
     * Extrai todas as produções a partir do html passado como parametro
     * @param html
     * @return vetorr de produções
     */
    public static Producao[] extrairProducoes(String html){
        // ArrayList com as produções encontradas
        ArrayList<Producao> achados = new ArrayList<Producao>();

        // Auxiliares para tratamento de string
        String tempHTML = "";
        String tempAno = "";
        String tempId = "";
        String tempTxt = "";

        // ***************** LOOP PARA CADA TIPO DE PRODUÇÃO ***************************
        for(int i = 0; i < padroesProducao.length; i++){
             // Separa os textos das producoes
            Matcher mProducao = Pattern.compile(padroesProducao[i]).matcher(html);

            // Se tiver achado o tipo da produção, começa a extração dos textos
            if(!mProducao.find())
                log.info(Main.recursos.getString("txt.producao.lattes") + "" + tiposProducao[i].getNome());
            else {

                // Compila o regex de texto produção
                Matcher mTexto = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO + ".*?"
                        + RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(mProducao.group());

                // ******************* LOOP PARA ENCONTRAR OS TEXTOS DE CADA PRODUÇÃO *************88
                while (mTexto.find()){
                    // Coloca o resultado em um html temporario
                    tempHTML = mTexto.group();

                    // Retira o id do texto
                    Matcher mID = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO).matcher(tempHTML);
                    if(mID.find())
                        tempId = Utilidades.removerHtmlTags(mID.group().trim());

                    // Retira o ano do texto
                    Matcher mANO = Pattern.compile(RegexConfig.REGEX_LATTES_ANO).matcher(tempHTML);
                    if(mANO.find())
                        tempAno = Utilidades.removerHtmlTags(mANO.group().trim());

                    // Retira o texto
                    Matcher mTXT = Pattern.compile(RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(tempHTML);
                    if(mTXT.find())
                        tempTxt = Utilidades.removerHtmlTags(mTXT.group().trim());

                    // Retira . e , do ano e do id
                    tempAno = tempAno.replaceAll("[:,\\.\\s]", "");
                    tempId = tempId.replaceAll("[\\.\\s]", "");

                    // Retira os espaços a mais entre as strings
                    tempTxt = tempTxt.replaceAll(RegexConfig.REGEX_TRIM_INTERNO, " ");

                    try{
                        achados.add(new Producao(tempTxt, tiposProducao[i], Integer.parseInt(tempAno), Integer.parseInt(tempId)));
                    }
                    catch(Exception e){
                        log.warning(Main.recursos.getString("txt.erro.lattes") + "" + e.getMessage());
                        System.out.println(Main.recursos.getString("txt.erro.lattes") + "" + e.getMessage());
                    }
                }
            }
        }

        // Converte para vetor de Producoes
        Producao[] prods = new Producao[achados.size()];
        for(int j = 0; j < prods.length; j++)
            prods[j] = achados.get(j);
        
        return prods;
    }

    /**
     * Extrai todas as produções a partir do html passado como parametro
     * @param html
     * @return
     */
    public static Banca[] extrairBancas(String html){
        // ArrayList com as produções encontradas
        ArrayList<Banca> achados = new ArrayList<Banca>();

        // Auxiliares para tratamento de string
        String tempHTML = "";
        String tempAno = "";
        String tempId = "";
        String tempTxt = "";
        String tempSubTipo = "";
        int idSubtipo = 0;

        //********************** LOOP PARA CAPTURAR OS TIPOS DE BANCA **************
        for(int i = 0; i < padroesBanca.length; i++){
            // Antes de mais nada, verifica se o tipo de banca existe
            Matcher mBanca = Pattern.compile(padroesBanca[i]).matcher(html);
            if(!mBanca.find())
                log.info(Main.recursos.getString("txt.banca.lattes") + "" + tiposBanca[i].getNome());
            else {
                //**************** LOOP PARA CAPTURAR OS SUBTIPOS DE BANCA **************
                Matcher mTipo = Pattern.compile(RegexConfig.REGEX_BANCA_SUBTIPO + ".*?"
                        + RegexConfig.REGEX_LATTES_FIM_TEXTO).matcher(mBanca.group());
                while(mTipo.find()){
                    // Extrai o subtipo
                    Matcher mSubTipo = Pattern.compile(RegexConfig.REGEX_BANCA_SUBTIPO).matcher(mTipo.group());
                    if(mSubTipo.find())
                        tempSubTipo = Utilidades.removerHtmlTags(mSubTipo.group());

                    SubTipoBanca subTipoBanca = new SubTipoBanca(-1, tempSubTipo.replaceAll(RegexConfig.REGEX_TRIM_INTERNO, " "));

                    // **************** LOOP PARA CAPTURAR OS TEXTOS DA BANCA ************8
                    Matcher mTexto = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO + ".*?"
                        + RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(mTipo.group());
                    while(mTexto.find()){

                        // Coloca o resultado em um html temporario
                        tempHTML = mTexto.group();

                        // Retira o id do texto
                        Matcher mID = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO).matcher(tempHTML);
                        if(mID.find())
                            tempId = Utilidades.removerHtmlTags(mID.group().trim());

                        // Retira o ano do texto
                        Matcher mANO = Pattern.compile(RegexConfig.REGEX_LATTES_ANO).matcher(tempHTML);
                        if(mANO.find())
                            tempAno = Utilidades.removerHtmlTags(mANO.group().trim());

                        // Retira o texto
                        Matcher mTXT = Pattern.compile(RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(tempHTML);
                        if(mTXT.find())
                            tempTxt = Utilidades.removerHtmlTags(mTXT.group().trim());

                        // Retira . e , do ano e do id
                        tempAno = tempAno.replaceAll("[:,\\.\\s]", "");
                        tempId = tempId.replaceAll("[,\\.\\s]", "");

                        // Retira os espaços a mais entre as strings
                        tempTxt = tempTxt.replaceAll(RegexConfig.REGEX_TRIM_INTERNO, " ");

                        try{
                            achados.add(new Banca(tempTxt, Integer.parseInt(tempAno), tiposBanca[i], subTipoBanca, Integer.parseInt(tempId)));
                        }
                        catch(Exception e){
                            log.info(Main.recursos.getString("txt.erro2.lattes") + "" + e.getMessage());
                            System.out.print(Main.recursos.getString("txt.erro2.lattes") + "" + e.getMessage());
                        }
                    }
                }
            }
        }

        // Converte para vetor de Bancas
        Banca[] bancas = new Banca[achados.size()];
        for(int j = 0; j < bancas.length; j++)
            bancas[j] = achados.get(j);

        return bancas;
    }

    /**
     * Extrai todas as orientações do html passado como parametro
     * @param html
     * @return
     */
    public static Orientacao[] extrairOrientacoes(String html){
        // ArrayList com as produções encontradas
        ArrayList<Orientacao> achados = new ArrayList<Orientacao>();

        // Auxiliares para tratamento de string
        String tempHTML = "";
        String tempAno = "";
        String tempId = "";
        String tempTxt = "";

        //******************* LOOP PARA CAPTURAR CADA STATUS DE ORIENTAÇÃO ****************
        for(int i = 0; i < padroesStatusOrientacao.length; i++){
            Matcher mStatus = Pattern.compile(padroesStatusOrientacao[i]).matcher(html);
            if(!mStatus.find())
                log.info(Main.recursos.getString("txt.status.orient") + "" + statusOrientacao[i]);
            else {
                // ************* LOOP PARA CAPTURAR CADA TIPO DE ORIENTAÇÃO **************
                for(int j = 0; j < padroesOrientacao.length; j++){
                    Matcher mTipo = Pattern.compile(padroesOrientacao[j]).matcher(mStatus.group());
                    if(!mTipo.find())
                        log.info(Main.recursos.getString("txt.tipo.orient") + "" + tiposOrientacao[j] + "" + Main.recursos.getString("txt.tipo.orient") + "" + (i == 0 ? "Em andamento" : "Concluída"));
                    else {
                        
                        // **************** LOOP PARA CAPTURAR OS TEXTOS DA ORIENTAÇÃO ************
                        Matcher mTexto = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO + ".*?"
                            + RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(mTipo.group());
                        while(mTexto.find()){

                            // Coloca o resultado em um html temporario
                            tempHTML = mTexto.group();

                            // Retira o id do texto
                            Matcher mID = Pattern.compile(RegexConfig.REGEX_LATTES_ID_TEXTO).matcher(tempHTML);
                            if(mID.find())
                                tempId = Utilidades.removerHtmlTags(mID.group().trim());

                            // Retira o ano do texto
                            Matcher mANO = Pattern.compile(RegexConfig.REGEX_LATTES_ANO).matcher(tempHTML);
                            if(mANO.find())
                                tempAno = Utilidades.removerHtmlTags(mANO.group().trim());

                            // Retira o texto
                            Matcher mTXT = Pattern.compile(RegexConfig.REGEX_LATTES_INICIO_TEXTO).matcher(tempHTML);
                            if(mTXT.find())
                                tempTxt = Utilidades.removerHtmlTags(mTXT.group().trim());

                            // Retira . e , do ano e do id
                            tempAno = tempAno.replaceAll("[:,\\.\\s]", "");
                            tempId = tempId.replaceAll("[,\\.\\s]", "");

                            // Retira os espaços a mais entre as strings
                            tempTxt = tempTxt.replaceAll(RegexConfig.REGEX_TRIM_INTERNO, " ");

                            try{
                                achados.add(new Orientacao(tempTxt, Integer.parseInt(tempAno), tiposOrientacao[j], i, Integer.parseInt(tempId)));
                            }
                            catch(Exception e){
                                log.info(Main.recursos.getString("txt.erro2.lattes") + "" + e.getMessage());
                                System.out.println(Main.recursos.getString("txt.erro2.lattes") + "" + e.getMessage());
                            }
                        }
                    }
                }
            }
        }

        // Converte para vetor de Orientações
        Orientacao[] orientacoes = new Orientacao[achados.size()];
        for(int j = 0; j < orientacoes.length; j++)
            orientacoes[j] = achados.get(j);

        return orientacoes;
    }

    /**
     * Extrai a data da ultima atualização do curriculo lattes
     * @param html
     * @return
     */
    public static Date extrairDataUltimaAtualizacao(String html){
        // Extrai diretamente
        Matcher mData = Pattern.compile(RegexConfig.REGEX_LATTES_DATA_ATUALIZACAO).matcher(html);
        if(!mData.find())
            log.info(Main.recursos.getString("txt.data"));
        else {
            String data = mData.group().replaceAll("[^/\\d]", "");
            mData = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{2,4}").matcher(mData.group());
            mData.find();
            return Utilidades.strToDate(mData.group()); 
        }
        return null;
    }

}
