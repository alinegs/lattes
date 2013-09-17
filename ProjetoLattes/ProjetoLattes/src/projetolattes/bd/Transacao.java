/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import projetolattes.util.Main;

/**
 * Classe que representa as transações no banco
 * @author Thatiany Lima e Aline Gonçalves
 */
final public class Transacao {
    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String usuario = Main.bancoDados.getString("usuario");
    private static String senha = Main.bancoDados.getString("senha");
    private static String url = Main.bancoDados.getString("url");

    /**
     * abre a conecção com o banco de dados
     * @throws Exception
     */
    public static void abrir() throws Exception{
        if(con == null){
            Class.forName( driver );
            con = DriverManager.getConnection( url, usuario, senha );
        }
    }

    /**
     * Consulta a sql
     * @param sql - A sql a ser consultada
     * @throws Exception
     */
    public static void consultar(String sql) throws Exception{
        stm = con.createStatement();
        stm.execute(sql);
        rs = stm.getResultSet();
    }

    /**
     * Executa a sql
     * @param sql - A sql a ser executada
     * @throws Exception
     */
    public static void executar(String sql) throws Exception{
        stm = con.createStatement();
        stm.execute(sql);
    }

    /**
     * Classe responsável por confirmar as transações(insert e update)
     */
    public static void commit() throws Exception{
        executar("COMMIT;");
        con = null;
    }

    /**
     * Classe responsável por refazer as trasações(insert e update)
     */
    public static void rollback(){
        try {
            executar("ROLLBACK;");
            con = null;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Classe que retorna o resultado
     * @return rs -  O resultado
     */
    public static ResultSet getRs() {
        return rs;
    }

    /**
     * Classe que retorna a conecção corrente
     * @return con - A conecção corrente
     */
    public static Connection getCon(){
        return con;
    }
}
