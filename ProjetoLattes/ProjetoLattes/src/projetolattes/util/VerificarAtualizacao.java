/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.util;

import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projetolattes.bd.CurriculoLattesBD;
import projetolattes.beans.CurriculoLattes;
import projetolattes.beans.Professor;
import projetolattes.extracaoHTML.ExtracaoLattes;

/**
 * Recebe um curriculo lattes e verica se é preciso atualizar
 * @author Thatiany Lima e Aline Gonçalves
 */
public class VerificarAtualizacao extends Thread{

    private static Logger log = Logger.getLogger(VerificarAtualizacao.class.getName());

    /**
     * c - Representa um curriculo lattes.
     */
    private CurriculoLattes c;

    /**
     * Construtor iniciando com os dados
     * @param c - O curriculo lattes a ser verificado
     */
    public VerificarAtualizacao(CurriculoLattes c){
        this.c = c;
    }

     /*
     * Verifica e Atualiza o currículo se necessário
     */
    @Override
    public void run(){
        try{
            log.info(Main.recursos.getString("log.atualizacao.inicio"));
            //System.out.println("iniciando a verificação no lattes");
            
            // Primeiro, verifica se a data de atualização na página é a mesma da última gravada em banco
            Date atualizacaoSite = ExtracaoLattes.extrairDataUltimaAtualizacao(Utilidades.abrirUrl(c.getLink()));
            Date atualizacaoBanco = c.getDataAtualizacao();

            // Se a data for diferente, significa que houve atualização
            // então deleta-se o curriculo lattes anterior e salva o novo
            log.info(Main.recursos.getString("log.data.site")  + "" + atualizacaoSite);
            log.info(Main.recursos.getString("log.data.banco") + "" + atualizacaoBanco);
            // System.out.println("Atualização no site: " + atualizacaoSite);
            // System.out.println("Atualização no banco: " + atualizacaoBanco);


            // Verifica se a data de atualização presente no banco é inferior a data presente no site
            if(atualizacaoBanco.before(atualizacaoSite)){
                log.info(Main.recursos.getString("log.atualizacao.curriculo")  + "" + c.getLink());
                //System.out.println("Iniciando atualização do curriculo lattes: " + c.getLink());

                // Só faz a atualização caso houver tido alteração no lattes
                String tempLink = c.getLink();
                Professor tempProfessor = c.getProfessor();

                //deleta o currículo
                new CurriculoLattesBD(c).deletar();

                // Agora atualiza extrai o curriculo lattes de novo e cadastra
                c = ExtracaoLattes.extrair(tempLink);
                c.setProfessor(tempProfessor);

                // Salva o curriculo
                new CurriculoLattesBD(c).salvar();
                return;
            }

            log.info(Main.recursos.getString("log.sem.atualizacao")  + "" + c.getLink());
            //System.out.println("Não houve alteração no curriculo lattes: " + c.getLink());


        }
        catch(Exception e){
            log.warning(Main.recursos.getString("log.erro.busca") + "" + e.getMessage());
            //System.out.println("Erro ao buscar o curriculo: " + e.getMessage());
            //e.printStackTrace();
        }
    }

}
