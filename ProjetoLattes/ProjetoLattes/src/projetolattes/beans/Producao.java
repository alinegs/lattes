/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe Producao - Representa as Produções do professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Producao {

    /**
     * idProducao - Representa o id da produção
     */
    private int idProducao;

    /**
     * descricao - Representa a descricao da producao.
     */
    private String descricao;

    /**
     * tipoProducao - Representa o tipo da producao.
     */
    private TipoProducao tipoProducao = new TipoProducao();

    /**
     * data - Representa a data da producao.
     */
    private int ano;

    /**
     * Representa o ID daquela produção no lattes
     */
    private int idLattes;

    /**
     * Construtor padrão
     */
    public Producao() {
        
    }

    /**
     * Construtor iniciando uma produção com os parametros escolhidos
     * @param descricao - A descrição da produção
     * @param tipoProducao - O tipo da Produção
     * @param ano - O ano da produção
     * @param idLattes - O ID da produção no lattes
     */
    public Producao(String descricao, TipoProducao tipoProducao, int ano, int idLattes) {
        this.descricao = descricao;
        this.tipoProducao = tipoProducao;
        this.ano = ano;
        this.idLattes = idLattes;
    }

    /**
     * Recupera o id da produção
     * @return id da produção
     */
    public int getIdProducao() {
        return idProducao;
    }

    /**
     * Altera o id da produção
     * @param idProducao
     */
    public void setIdProducao(int idProducao) {
        this.idProducao = idProducao;
    }

    /**
     * Recupera o id Lattes daquela produçao
     * @return
     */
    public int getIdLattes() {
        return idLattes;
    }

    /**
     * Altera o id lattes daquela produção
     * @param idLattes
     */
    public void setIdLattes(int idLattes) {
        this.idLattes = idLattes;
    }

    /**
     * Recupera a descrição da Produção.
     * @return A descrição da Produção.
     */
    public String getDescricao() {
        return descricao;
    }


    /**
     * Altera a descrição da Produção.
     * @param descricao A nova descrição da Produção.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Recupera o tipo da Produção.
     * @return O tipo da Produção.
     */
    public TipoProducao getTipoProducao() {
        return tipoProducao;
    }


    /**
     * Altera o tipo da Produção.
     * @param tipoProducao O novo tipo da Produção.
     */
    public void setTipoProducao(TipoProducao tipoProducao) {
        this.tipoProducao = tipoProducao;
    }

    /**
     * Recupera a data da Produção.
     * @return A data da Produção.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Altera a data da Produção.
     * @param data A nova data da Produção.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Produção: " + descricao +
               "\nTipo: " + tipoProducao +
               "\nAno: " + ano +
               "\nidLates: " + idLattes + "\n";
    }
}
