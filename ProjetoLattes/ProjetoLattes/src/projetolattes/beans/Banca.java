/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe Banca - Representa as Bancas do professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Banca {

    /**
     * idBanca - Representa o identificador da banca
     */
    private int idBanca;

    /**
     * descricao - Representa a descricao da banca.
     */
    private String descricao;

    /**
     * ano - Representa a ano da banca.
     */
    private int ano;

    /**
     * tipoBanca - Representa o tipo da banca (Examinadora ou Julgadora).
     */
    private TipoBanca tipoBanca = new TipoBanca();

    /**
     * subTipoBanca - guarda os subtipos determinados pelo lattes.
     */
    private SubTipoBanca subTipoBanca = new SubTipoBanca();

    /**
     * Representa o id daquela banca no lattes
     */
    private int idLattes;

    /**
     * Construtor padrão
     */
    public Banca() {
       
    }

    /**
     * Construtor iniciando a banca com os dados
     * @param descricao - descrição da banca
     * @param ano - ano da banca
     * @param tipoBanca - tipo da banca
     * @param subTipoBanca - tipo da banca examinadora
     * @param idLattes - id do lattes no curriculo lattes
     */
    public Banca(String descricao, int ano, TipoBanca tipoBanca, SubTipoBanca subTipoBanca, int idLattes) {
        this.descricao = descricao;
        this.ano = ano;
        this.tipoBanca = tipoBanca;
        this.subTipoBanca = subTipoBanca;
        this.idLattes = idLattes;
    }

    /**
     * Recupera o id da banca
     * @return o id da banca
     */
    public int getIdBanca() {
        return idBanca;
    }

    /**
     * Altera o id da Banca
     * @param idBanca - id da banca
     */
    public void setIdBanca(int idBanca) {
        this.idBanca = idBanca;
    }

    /**
     * Recupera a ano da Banca.
     * @return A ano da Banca.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Altera a ano da Banca.
     * @param ano A nova ano da Banca.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Recupera a descrição da Banca.
     * @return A descrição da Banca.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição da Banca.
     * @param descricao A nova descrição da Banca.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Recupera o tipo da Banca.
     * @return O tipo da Banca.
     */
    public TipoBanca getTipoBanca() {
        return tipoBanca;
    }

    /**
     * Altera o tipo da Banca.
     * @param tipoProducao O novo tipo da Banca.
     */
    public void setTipoBanca(TipoBanca tipoBanca) {
        this.tipoBanca = tipoBanca;
    }

    /**
     * Recupera o subtipo da banca
     * @return subtipo da banca
     */
    public SubTipoBanca getSubTipoBanca() {
        return subTipoBanca;
    }

    /**
     * Altera o subtipo da banca
     * @param subTipoBanca
     */
    public void setSubTipoBanca(SubTipoBanca subTipoBanca) {
        this.subTipoBanca = subTipoBanca;
    }

    /**
     * Recupera o id da banca do lattes
     * @return id lattes da banca
     */
    public int getIdLattes() {
        return idLattes;
    }

    /**
     * Altera o id lattes da banca
     * @param idLattes
     */
    public void setIdLattes(int idLattes) {
        this.idLattes = idLattes;
    }

    @Override
    public String toString() {
        return "Banca: " + descricao +
               "\nTipo: " + tipoBanca +
               "\nSubTipo: " + subTipoBanca +
               "\nAno: " + ano +
               "\nidLates: " + idLattes + "\n";
    }
}
