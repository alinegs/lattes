/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projetolattes.extracaoHTML.HtmlManipulator;

/**
 * Classe que apresenta diversos métodos como abrirUrl, removerHtmlTags, strToDate, dateToStr e formatarData
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Utilidades {

    private static Logger log = Logger.getLogger(Utilidades.class.getName());

    /**
     * Abre uma url e retorna a String com o conteúdo
     * @param url - url a ser aberta
     * @return conteúdo da página HTML
     * @throws Exception
     */
    public static String abrirUrl(String pagina) throws Exception{
        try {
           URL url = new URL(pagina);
           URLConnection connection = url.openConnection();
           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           String inputLine;
           StringBuffer sb = new StringBuffer();
           while ((inputLine = in.readLine()) != null)
               sb.append(inputLine.replaceAll("'", ""));
           in.close();
           return HtmlManipulator.replaceHtmlEntities(sb.toString());
        } catch (MalformedURLException ex) {
            log.warning(Main.recursos.getString("utilidades.erro.url"));
            throw new Exception(Main.recursos.getString("utilidades.erro.url"));
        } catch (IOException ex) {
           ex.printStackTrace();
           log.warning(Main.recursos.getString("utilidades.erro.pagina"));
           throw new Exception(Main.recursos.getString("utilidades.erro.pagina"));
        }
    }

    /**
     * Remove todas as tags html de um texto
     * @param html
     * @return
     */
    public static String removerHtmlTags(String html){
        return html.replaceAll("<[^>]*>", "");
    }

   /**
     * Recebe uma data na forma de String e transforma para Date
     * @param strData
     * @return objeto Date da data passada por parâmetro
     */
    public static Date strToDate(String strData) {
        Date d;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            d = formatter.parse(strData);
            return d;
        } catch (Exception e) {
            log.warning(Main.recursos.getString("utilidades.erro.data"));
            JOptionPane.showMessageDialog(null, Main.recursos.getString("utilidades.erro.data"),      Main.recursos.getString("txt.erro2.principal"), JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }

    /**
     * Recebe uma data na forma de String e transforma para Date
     * @param strData
     * @return objeto Date da data passada por parâmetro
     */
    public static String dateToStr(Date data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }

    /**
     * Pega a data utilizando um servidor web para tal
     * Caso o formato esteja vazio, retorna a data no formato brasileiro separado com hífen
     * O formato pode set passado como ingles ou portugues
     * Em portugues:<br />
     * hora => hh<br />
     * minuto => mm<br />
     * segundo => ss<br />
     * ano => yyyy<br />
     * mes => MM<br />
     * dia => dd<br />
     * @param forma indica o formato da data.
     * @return  data no formato mysql vinda da internet
     */
    public static String formatarData(String forma, long data){
        forma = (forma.equalsIgnoreCase("")) ? "dd-MM-yyyy hh:mm:ss" : forma;
        forma = forma.replaceAll("hora", "hh")
                .replaceAll("minuto", "mm")
                .replaceAll("segundo", "ss")
                .replaceAll("ano", "yyyy")
                .replaceAll("mes", "MM")
                .replaceAll("dia", "dd");
        //SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        SimpleDateFormat formato = new SimpleDateFormat(forma);
        return formato.format(data);
    }


}
