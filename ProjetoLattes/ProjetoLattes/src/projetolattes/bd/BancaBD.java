/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.Banca;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação as bancas
 * @author Thatiany Lima e Aline Golçaves
 */
public class BancaBD implements DAO {

    /**
     * b - Representa o beans que será manipulado
     */
    private Banca b;

    /**
     * idCurriculoLattes - Armazena o id do curriculo lattes do bean banca
     */
    private int idCurriculoLattes;

    /**
     * Inicia o objeto apenas se for passado um id e um bean banca
     * @param b - o beans
     * @param idCurriculoLattes - o id do curriculo lattes do beans
     */
    public BancaBD(Banca b, int idCurriculoLattes){
        this.b = b;
        this.idCurriculoLattes = idCurriculoLattes;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        // Verifica se o bean existe
        if(b == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        // Primeiro salva o subtipo de banca
        new SubTipoBancaBD(b.getSubTipoBanca()).salvar();

        String sql = "INSERT INTO banca (idBanca, idTipoBanca, idSubTipoBanca, descricao, ano, idCurriculoLattes, idLattes) " +
                "VALUES (null, "+ b.getTipoBanca().getIdTipoBanca() +", "+ b.getSubTipoBanca().getIdSubTipoBanca() +",  " +
                "'"+ b.getDescricao() +"', "+ b.getAno() +", "+ idCurriculoLattes + " , "+ b.getIdLattes() +")";


        Transacao.executar(sql);
    }

    /**
     * Deleta o beans do banco
     * @throws Exception
     */
    public void deletar() throws Exception {
         // Verifica se o bean existe
        if(b == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "DELETE FROM banca WHERE idBanca = " + b.getIdBanca();

        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @return o beans banca
     * @throws Exception
     */
    public Banca consultar(int id) throws Exception {
        // Verifica se o bean existe
        if(b == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM banca WHERE idBanca = " + id;

        Transacao.consultar(sql);

        b.setAno(Transacao.getRs().getInt("ano"));
        b.setDescricao(Transacao.getRs().getString("descricao"));
        b.getTipoBanca().setIdTipoBanca(Transacao.getRs().getInt("idTipoBanca"));
        b.getSubTipoBanca().setIdSubTipoBanca(Transacao.getRs().getInt("idSubTipoBanca"));
        b.setIdLattes(Transacao.getRs().getInt("idLattes"));
        b.setIdBanca(id);

        return b;
    }

}
