/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import java.sql.ResultSet;
import java.util.ArrayList;
import projetolattes.beans.CurriculoLattes;

/**
 * Classe resposável por cuidar de todas as consultas relacionadas a relatórios e casos especiais
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Consultas {

    /**
     * Retorna um conjunto de dados para popular a tabela de relatório por professor
     * @return
     * @throws Exception
     */
    public static String[][] relatorioPorProfessor() throws Exception{
        String sql = "SELECT "
             + " prof.nome AS nome_professor,"
             + " (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 0 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_graduacao,"
             + "  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 1 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_especializacao,"
             + "  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 2 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_mestrado,"
             + "  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 3 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_doutorado,"
             + "  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 0 AND p.idCurriculoLattes = cl.idCurriculoLattes) AS trabalhos,"
             + "  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 2 AND p.idCurriculoLattes = cl.idCurriculoLattes) AS artigos,"
             + "  (SELECT COUNT(p.idProducao) FROM producao p WHERE (p.idTipoProducao = 3 OR p.idTipoProducao = 1) AND p.idCurriculoLattes = cl.idCurriculoLattes) AS livros_capitulos,"
             + "  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 0 AND b.idCurriculoLattes = cl.idCurriculoLattes) AS banca_examinadora,"
             + "  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 1 AND b.idCurriculoLattes = cl.idCurriculoLattes) AS banca_julgadora"

           + "  FROM "
             + "  professor prof,"
             + "  curriculolattes cl"

           + "  WHERE"
             + "  cl.professor_matricula = prof.matricula";

        Transacao.consultar(sql);
        ResultSet rs = Transacao.getRs();
        ArrayList<String[]> linhas = new ArrayList<String[]>();

        while(rs.next()){
            linhas.add(new String[]{
                rs.getString("nome_professor"),
                rs.getString("trabalhos"),
                rs.getString("livros_capitulos"),
                rs.getString("artigos"),
                rs.getString("orientacao_graduacao"),
                rs.getString("orientacao_especializacao"),
                rs.getString("orientacao_mestrado"),
                rs.getString("orientacao_doutorado"),
                rs.getString("banca_julgadora"),
                rs.getString("banca_examinadora"),
                // Calcula o total
                Integer.toString(Integer.parseInt(rs.getString("trabalhos")) +
                        Integer.parseInt(rs.getString("livros_capitulos")) +
                        Integer.parseInt(rs.getString("artigos")) +
                        Integer.parseInt(rs.getString("orientacao_graduacao")) +
                        Integer.parseInt(rs.getString("orientacao_especializacao")) +
                        Integer.parseInt(rs.getString("orientacao_mestrado")) +
                        Integer.parseInt(rs.getString("orientacao_doutorado")) +
                        Integer.parseInt(rs.getString("banca_julgadora")) +
                        Integer.parseInt(rs.getString("banca_examinadora")))
            });
        }

        // Transforma o arraylist para um vetor bidimensional
        String[][] saida = new String[linhas.size()][];
        for(int i = 0; i < saida.length; i++)
            saida[i] = linhas.get(i);

        return saida;
    }

    /**
     * Retorna um conjunto de dados para popular a tabela de relatório geral
     * @return
     * @throws Exception
     */
    public static String[] relatorioGeral() throws Exception{
        String sql = "SELECT"
                     + " (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 0) AS orientacao_graduacao,"
                     + " (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 1) AS orientacao_especializacao,"
                     + " (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 2) AS orientacao_mestrado,"
                     + " (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 3) AS orientacao_doutorado,"
                     + " (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 0) AS trabalhos,"
                     + " (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 2) AS artigos,"
                     + " (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 3 OR p.idTipoProducao = 1) AS livros_capitulos,"
                     + " (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 0) AS banca_examinadora,"
                     + " (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 1) AS banca_julgadora";

        Transacao.consultar(sql);
        ResultSet rs = Transacao.getRs();

        if(rs.next()){
            return new String[]{
                rs.getString("orientacao_graduacao"),
                rs.getString("orientacao_especializacao"),
                rs.getString("orientacao_mestrado"),
                rs.getString("orientacao_doutorado"),
                rs.getString("trabalhos"),
                rs.getString("artigos"),
                rs.getString("livros_capitulos"),
                rs.getString("banca_examinadora"),
                rs.getString("banca_julgadora")
            };
        }

        return null;
    }

    /**
     * Retorna uma lista contendo somente os curriculos
     * Essa lista é usada para fazer o monitoramento de curriculos
     * @return
     * @throws Exception
     */
    public static CurriculoLattes[] listaCurriculos() throws Exception{
        // Tenho que trazer
        String sql = "SELECT * FROM curriculolattes";
        Transacao.abrir();
        Transacao.consultar(sql);
        ResultSet rs = Transacao.getRs();
        ArrayList<CurriculoLattes> curriculos = new ArrayList<CurriculoLattes>();
        while(rs.next()){
            CurriculoLattes c = new CurriculoLattes();
            c.setLink(rs.getString("link"));
            c.setDataAtualizacao(rs.getDate("dataAtualizacao"));
            c.setIdCurriculoLattes(rs.getInt("idcurriculolattes"));
            c.getProfessor().setMatricula(rs.getString("professor_matricula"));
            curriculos.add(c);
        }

        // Transforma arraylist em vetor
        int size = curriculos.size();
        CurriculoLattes[] saida = new CurriculoLattes[size];
        for(int i = 0; i < size; i++)
            saida[i] = curriculos.get(i);

        return saida;
    }

    /**
     * Retorna o curriculo lattes de um professor
     * @param matriculaProfessor
     * @return
     */
    public static CurriculoLattes curriculoLattesProfessor(String matriculaProfessor) throws Exception{
        String sql = "SELECT idCurriculoLattes FROM curriculolattes WHERE professor_matricula = '" + matriculaProfessor + "' ";
        Transacao.consultar(sql);

        // Se não encontrar nada, lança uma exceção
        if(!Transacao.getRs().first())
            throw new Exception("Não foi encontrado Curriculo Lattes do professor de matricula " + matriculaProfessor + "!");

        // Se chegar até aqui, significa que existe um curriculo cadastrado, então o retorna
        return new CurriculoLattesBD(new CurriculoLattes()).consultar(Transacao.getRs().getInt("idCurriculoLattes"));
    }
}
