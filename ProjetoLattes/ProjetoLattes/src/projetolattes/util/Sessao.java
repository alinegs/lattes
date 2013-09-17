/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.util;

import java.util.ArrayList;
import java.util.logging.Logger;
import projetolattes.bd.Transacao;
import projetolattes.beans.Usuario;

/**
 * Classe responsável por realizar a sessão do usuário
 * @author Thatiany Lima e Aline Gonçalves
 */
public final class Sessao {

    private static Logger log = Logger.getLogger(Sessao.class.getName());

    /**
     * Array para guardar valores na sessão
     */
    private static ArrayList<ItemSessao> itens_sessao = new ArrayList<ItemSessao>();

    /**
     * Tenta setar e verificar a existencia de um usuario
     * @param u é o usuario que tentará fazer o login
     * @throws Exception
     */
    public static void setUsuario(Usuario u) throws Exception{
        // Faz a consulta do usuario 
        Transacao.consultar("SELECT * FROM usuario WHERE matricula = '"+ u.getMatricula() + "' AND senha = '"+ u.getSenha() +"' ");
        if(Transacao.getRs().first()){
            setAttr("usuario", u);
        }
        else
            throw new Exception(Main.recursos.getString("excecao.sessao.usuario"));
    }

    /**
     * Recupera o usuário.
     * @return O Usuario.
     */
    public static Usuario getUsuario(){
        return (Usuario) getAttr("usuario");
    }

    /**
     * Inclui ou altera um valor na sessão
     * @param obj
     * @param val
     */
    public static void setAttr(String obj, Object val){
        if(getAttr(obj) == null)
            itens_sessao.add(new ItemSessao(obj, val));
        else{
            int size = itens_sessao.size();
            for(int i = 0; i < size; i++){
                if(itens_sessao.get(i).attr.equalsIgnoreCase(obj))
                    if(val == null){
                        itens_sessao.remove(i);
                    }
                    else
                        itens_sessao.set(i, new ItemSessao(obj, val));
            }
        }
    }

    /**
     * Retorna um valor guardado na sessão
     * @param obj
     * @return
     */
    public static Object getAttr(String obj){
        int size = itens_sessao.size();
        for(int i = 0; i < size; i++)
            if( itens_sessao.get(i).attr.equalsIgnoreCase(obj) )
                return itens_sessao.get(i).valor;
        return null;
    }

}

/**
 * Inner class para controlar os valores guardados na sessão
 * @author Thatiany Lima e Aline Gonçalves
 */
class ItemSessao{
    public String attr;
    public Object valor;

    public ItemSessao(String a, Object v){
        attr = a;
        valor = v;
    }
}
