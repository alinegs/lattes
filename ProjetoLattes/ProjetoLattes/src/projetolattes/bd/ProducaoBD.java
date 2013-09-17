/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.Producao;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação as produções
 * @author Thatiany Lima e Aline Gonçalves
 */
public class ProducaoBD implements DAO{

    /**
     * p - Representa o beans que será manipulado
     */
    private Producao p;

    /**
     * idCurriculoLattes - Armazena o id do curriculo lattes do bean produção
     */
    private int idCurriculoLattes;

    /**
     * Inicia o objeto apenas de for passado um id e um bean produção
     * @param p
     * @param idCurriculoLattes
     */
    public ProducaoBD(Producao p, int idCurriculoLattes){
        this.p = p;
        this.idCurriculoLattes = idCurriculoLattes;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "INSERT INTO producao (idProducao, idTipoProducao, descricao, ano, idCurriculoLattes, idLattes) " +
                "VALUES (null, "+ p.getTipoProducao().getIdTipoProducao() +"," +
                "'"+ p.getDescricao() +"', "+ p.getAno() +", "+ idCurriculoLattes + " , "+ p.getIdLattes() +")";


        Transacao.executar(sql);
    }

    /**
     * Deleta o beans do banco
     * @throws Exception
     */
    public void deletar() throws Exception {
         // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "DELETE FROM producao WHERE idProducao = " + p.getIdProducao();
        
        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @returns o beans producao
     * @throws Exception
     */
    public Producao consultar(int id) throws Exception{
        // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM producao WHERE idProducao = " + id;

        Transacao.consultar(sql);

        p.setAno(Transacao.getRs().getInt("ano"));
        p.setDescricao(Transacao.getRs().getString("descricai"));
        p.getTipoProducao().setIdTipoProducao(Transacao.getRs().getInt("idTipoProducao"));
        p.setIdLattes(Transacao.getRs().getInt("idLattes"));
        p.setIdProducao(id);

        return p;
    }

}
