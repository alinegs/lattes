/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.SubTipoBanca;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação aos subTipos de banca
 * @author Thatiany Lima e Aline Gonçalves
 */
public class SubTipoBancaBD implements DAO{

    /**
     *stb - Representa o beans que será manipulado
     */
    private SubTipoBanca stb;

    /**
     * Inicia o objeto apenas de for passado um bean subTipoBanca
     * @param stb
     */
    public SubTipoBancaBD(SubTipoBanca stb) {
        this.stb = stb;
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @throws Exception
     */
    public Object consultar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deleta o beans no banco
     * @throws Exception
     */
    public void deletar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        if(stb == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        // Restrição provisória para aumentar a performance do programa
        if(stb.getIdSubTipoBanca() != -1)
            return;

        // Primeiro verifica se existe o subtipo de banca
        Transacao.consultar("SELECT idSubTipoBanca FROM subTipoBanca WHERE nome LIKE '"+ stb.getNome() +"'");
        if(Transacao.getRs().first())
            stb.setIdSubTipoBanca(Transacao.getRs().getInt("idSubTipoBanca"));

        String sql = "";

        if(stb.getIdSubTipoBanca() == -1)
            sql = "INSERT INTO subTipoBanca VALUES(null, '"+ stb.getNome() +"')";
        else
            sql = "UPDATE subTipoBanca SET nome = '"+ stb.getNome() +"' WHERE idSubTipoBanca = " + stb.getIdSubTipoBanca();

        
        Transacao.executar(sql);
        
        // Se foi uma inserção, deve trazer o id do subtipo para o objeto
        if(stb.getIdSubTipoBanca() == -1){
            Transacao.consultar("SELECT LAST_INSERT_ID() AS ultimo_id");
            if(Transacao.getRs().first())
                stb.setIdSubTipoBanca(Transacao.getRs().getInt("ultimo_id"));
        }
    }

}
