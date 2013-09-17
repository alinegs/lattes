/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.util;

import java.util.ResourceBundle;
import java.util.logging.Logger;
import projetolattes.telas.TelaPrincipal;

/**
 *
 * @author Thatiany
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static ResourceBundle recursos = ResourceBundle.getBundle("Properties.Messages");

    public static ResourceBundle bancoDados;

    public static void main(String[] args){

        bancoDados = ResourceBundle.getBundle("Properties.banco");

        log.info(recursos.getString("log.main.inicio"));
        log.info(recursos.getString("log.main.idiomaInicio"));

        //Tela principal;
        new TelaPrincipal().setVisible(true);
    }

    public static void mudarIdioma(String idioma){

      // Verifica se o idioma selecionado é o inglês
      if(idioma.equalsIgnoreCase("Ingles")){
            recursos = ResourceBundle.getBundle("Properties.Messages_en_US");
            log.info(Main.recursos.getString("log.login.idioma2"));
            log.info(recursos.getString("log.main.inicio"));
        new TelaPrincipal().setVisible(true);
      }
      // Verifica se o idioma selecionado é o protuguês
      else if(idioma.equalsIgnoreCase("Portugues")){
        recursos = ResourceBundle.getBundle("Properties.Messages");
        log.info(Main.recursos.getString("log.login.idioma"));
        log.info(recursos.getString("log.main.inicio"));
        new TelaPrincipal().setVisible(true);
      }
       // Verifica se o idioma selecionado é o espanhol
      else if(idioma.equalsIgnoreCase("Espanhol")){
        recursos = ResourceBundle.getBundle("Properties.Messages_es_ES");
        log.info(Main.recursos.getString("log.login.idioma"));
        log.info(recursos.getString("log.main.inicio"));
        new TelaPrincipal().setVisible(true);
      }
    }

}
