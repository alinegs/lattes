/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.util;

import java.util.logging.Logger;
import projetolattes.bd.Consultas;
import projetolattes.beans.CurriculoLattes;

/**
 * Classe responsável pelo monitoramento das atualizações do currículo lattes
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Monitoramento extends Thread{

    private static Logger log = Logger.getLogger(Monitoramento.class.getName());

    /**
     * Intervalo padrão semanal de monitoramento
     * 7 dias, cada dia tem 24 horas, cada hora 60 minutos e cada minuto 60 segundos
     */
    private static int intervalo = 7 // numero de dias
                                * 24 // numero de horas
                                * 60 // numero de minutos
                                * 60;// numero de segundos
    /**
     * Recupera o Intervalo de monitoramento.
     * @return O Intervalo de monitoramento.
     */
    public static int getIntervalo(){
        return intervalo;
    }

    /**
     * Altera o Intervalo de monitoramento
     * @param segundos O tempo do intervalo de monitoramento em segundos.
     * @exception IllegalArgumentException Caso o valor de segundos seja inválido
     */
    public static void setIntervalo(int segundos) throws Exception{
        if(segundos >= 0 && segundos <= 604800 ){
            log.info(Main.recursos.getString("log.monitoramento.alterado") + segundos + Main.recursos.getString("log.monitoramento.alterado2"));
           intervalo = segundos;
        }
        else{
            log.warning(Main.recursos.getString("log.monitoramento.erro"));
          throw new Exception(Main.recursos.getString("excecao.monitoramento.erro"));
        }
    }

    /**
     * Fica infinitamente lançando threads individuais à procura de atualizações nos curriculos dos professores.
     * O intervalo vem do banco e caso não existir, será o padrão semanal
     * 7 * 24 * 60 * 60 segundos
     */
    @Override
    public void run(){
        log.info(Main.recursos.getString("log.monitoramento.inicio"));
        //System.out.println("iniciando o monitoramento");
        int antigo = 0;
        while(true){
            antigo = intervalo;
            try {
                // Espera até o próximo intervalo de monitoramento
                // thread dorme o numero de milisegundos que ta no intervalo
                sleep(intervalo * 1000); // * 1000 pois é em milisegundos

                // Se a thread for acordada e seu intervalo for alterado, significa que
                // alguem mudou o intervalo...então deve-se esperar novamente pelo intervalo
                if(antigo != intervalo)
                    continue;

                // Se o antigo for igual ao intervalo, está na hora de um novo monitoramento
                // Consulta todos os curriculos e dispara uma thread para verificar a atualização de cada um
                CurriculoLattes[] cs = Consultas.listaCurriculos();

                // Dispara uma thread pra cada curriculolattes e depois volta para o estado de espera
                // Faz um for, e lança uma verificação pra cada curriculo
                for(CurriculoLattes c : cs)
                    new VerificarAtualizacao(c).start();
                

            } catch (Exception ex) {
                log.info(Main.recursos.getString("log.monitoramento.erro2") + ex.getMessage());
                //System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

}
