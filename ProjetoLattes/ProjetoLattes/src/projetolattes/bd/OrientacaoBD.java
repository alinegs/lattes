/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.Orientacao;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação as orientações
 * @author Thatiany Lima e Aline Gonçalves
 */
public class OrientacaoBD implements DAO {

    /**
     * o - Representa o beans que será manipulado
     */
    private Orientacao o;

    /**
     * idCurriculoLattes - Armazena o id do curriculo lattes do bean orientacao
     */
    private int idCurriculoLattes;

    /**
     * Inicia o objeto apenas de for passado um id e um bean orientacao
     * @param o
     * @param idCurriculoLattes
     */
    public OrientacaoBD(Orientacao o, int idCurriculoLattes){
        this.o = o;
        this.idCurriculoLattes = idCurriculoLattes;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        // Verifica se o bean existe
        if(o == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "INSERT INTO orientacao (idOrientacao, idTipoOrientacao, ano, descricao, status, idCurriculoLattes, idLattes) " +
                "VALUES (null, '"+o.getTipoOrientacao().getIdTipoOrientaco() +"', "+ o.getAno() +",  " +
                "'"+ o.getDescricao() +"', "+ o.getStatus() +", "+ idCurriculoLattes + " , "+ o.getIdLattes() +")";


        Transacao.executar(sql);
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void deletar() throws Exception {
        // Verifica se o bean existe
        if(o == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "DELETE FROM orientacao WHERE idOrientacao = " + o.getIdOrientacao();

        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @return o beans orientacao
     * @throws Exception
     */
    public Orientacao consultar(int id) throws Exception {
        // Verifica se o bean existe
        if(o == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM orientacao WHERE idOrientacao = " + id;

        Transacao.consultar(sql);

        o.setAno(Transacao.getRs().getInt("ano"));
        o.setDescricao(Transacao.getRs().getString("descricao"));
        o.getTipoOrientacao().setIdTipoOrientaco(Transacao.getRs().getInt("idTipoBanca"));
        o.setStatus(Transacao.getRs().getInt("tatus"));
        o.setIdLattes(Transacao.getRs().getInt("idLattes"));
        o.setIdOrientacao(id);

        return o;
    }

}
