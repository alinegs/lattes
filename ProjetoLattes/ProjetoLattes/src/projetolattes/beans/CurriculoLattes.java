/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

import java.util.Date;
import projetolattes.util.Main;

/**
 * Classe CurriculoLattes - Representa o curriculoLattes do Professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class CurriculoLattes {


    /**
     * idCurriculoLattes - Representa o ID do Curriculo Lattes.
     */
    private int idCurriculoLattes = -1;

    /**
     * link - Representa o link do Curriculo Lattes do Professor.
     */
    private String link;

    /**
     * dataAtualizacao - Representa a data de atualizacao do curriculo lattes do professor.
     */
    private Date dataAtualizacao;

    /**
     * professor - Representa a professor do professor.
     */
    private Professor professor = new Professor();

    /**
     * producoes - Representa o ID das producoes do professor.
     */
    private Producao[] producoes;

    /**
     * bancas - Representa o ID das bancas que o professor participou.
     */
    private Banca[] bancas;

    /**
     * orientacoes - Representa o ID das orientações que o professor realizou.
     */
    private Orientacao[] orientacoes;

    /**
     * Construtor padrão
     */
    public CurriculoLattes(){

    }

    /**
     * Construtor iniciando o curriculoLattes com os dados
     * @param link - link do curriculo
     * @param dataAtualização - data de atualização do curriculo
     * @param produções - produções do professor
     * @param bancas - bancas que o professor participou
     * @param orientações - orientações realizadas pelo professor
     */
    public CurriculoLattes(String link, Date dataAtualizacao, Producao[] producoes, Banca[] bancas, Orientacao[] orientacoes) {
        this.link = link;
        this.dataAtualizacao = dataAtualizacao;
        this.producoes = producoes;
        this.bancas = bancas;
        this.orientacoes = orientacoes;
    }



    /**
     * Recupera o ID do curriculo lattes do Professor.
     * @return O ID do curriculo lattes do Professor.
     */
    public int getIdCurriculoLattes() {
        return idCurriculoLattes;
    }

    /**
     * Altera o ID do curriculo lattes do Professor.
     * @param idCurriculoLattes O novo ID do curriculo lattes do Professor.
     */
    public void setIdCurriculoLattes(int idCurriculoLattes) {
        this.idCurriculoLattes = idCurriculoLattes;
    }

    /**
     * Recupera a data de atualizacao do curriculo lattes do Professor.
     * @return A data de atualizacao do curriculo lattes do Professor.
     */
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

     /**
     * Altera a data de atualizacao do curriculo lattes do Professor.
     * @param dataAtualizao A nova data de atualizacao do curriculo lattes do Professor.
     */
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    /**
     * Recupera o ID da bancas que o Professor participou.
     * @return O ID da bancas que o Professor participou.
     */
    public Banca[] getBancas() {
        return bancas;
    }

    /**
     * Altera o ID da bancas que o Professor participou.
     * @param bancas O novo ID da bancas que o Professor participou.
     */
    public void setBancas(Banca[] bancas) {
        this.bancas = bancas;
    }

    /**
     * Recupera o ID das orientacoes que o Professor realizou.
     * @return O ID das orientacoes que o Professor realizou.
     */
    public Orientacao[] getOrientacoes() {
        return orientacoes;
    }

    /**
     * Altera o ID das orientacoes que o Professor realizou.
     * @param orientacoes O novo ID das orientacoes que o Professor realizou.
     */
    public void setOrientacoes(Orientacao[] orientacoes) {
        this.orientacoes = orientacoes;
    }

    /**
     * Recupera o ID das producoes do Professor.
     * @return O ID das producoes do Professor.
     */
    public Producao[] getProducoes() {
        return producoes;
    }

    /**
     * Altera o ID das producoes do Professor.
     * @param producoes O novo ID das producoes do Professor.
     */
    public void setProducoes(Producao[]producoes) {
        this.producoes = producoes;
    }

    /**
     * Recupera o link do curriculo lattes do Professor.
     * @return O link do curriculo lattes do Professor.
     */
    public String getLink() {
        return link;
    }

    /**
     * Altera o link do curriculo lattes do Professor.
     * @param link O novo link do curriculo lattes do Professor.
     * @exception IllegalArgumentException caso o link seja nulo ou vazio.
     */
    public void setLink(String link) throws Exception {
      if(link != null && !link.equals("")){
        this.link = link;
      }
      else{
          throw new Exception(Main.recursos.getString("beans.erro.link"));
      }
    }

    /**
     * Recupera a professor do Professor.
     * @return A professor do Professor.
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Altera a professor do Professor.
     * @param professor A nova a professor do Professor.
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString(){
        return "Curriculo: " + getLink();
    }
}
