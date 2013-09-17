/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.Usuario;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação ao usuário
 * @author Thatiany Lima e Aline Gonçalves
 */
public class UsuarioBD implements DAO {

    /**
     * u - Representa o beans que será manipulado
     */
    private Usuario u;

    /**
     * Inicia o objeto apenas de for passado um bean usuario
     * @param u
     */
    public UsuarioBD(Usuario u){
        this.u = u;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        if(u == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "INSERT INTO usuario (idUsuario, matricula, senha, nome) " +
                "VALUES ("+ u.getIdUsuario() +", '"+ u.getMatricula() +"'," +
                "'"+u.getSenha() +"', "+ u.getNome() +")";
        Transacao.executar(sql);
    }

    /**
     * Salva o beans do banco
     * @throws Exception
     */
    public void deletar() throws Exception {
        if(u == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "DELETE FROM usuario WHERE idUsuario = " + u.getIdUsuario();

        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param idUsuario
     * @return o beans usuario
     * @throws Exception
     */
    public Usuario consultar(int idUsuario) throws Exception {
        if(u == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM usuario WHERE idUsuario = " + idUsuario;

        Transacao.consultar(sql);

        u.setIdUsuario(idUsuario);
        u.setMatricula(Transacao.getRs().getString("matricula"));
        u.setSenha(Transacao.getRs().getString("senha"));
        u.setNome(Transacao.getRs().getString("nome"));
        
        return u;
    }

}
