/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe Orientacao - Representa as Orientacoes do professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Orientacao {

    /**
     * idOrientacao - Representa o id da orientação
     */
    private int idOrientacao;
    /**
     * descricao - Representa a descricao da orientação.
     */
    private String descricao;

    /**
     * ano - Representa a ano da orientacao.
     */
    private int ano;

    /**
     * tipoOrientacao - Representa o tipo da orientacao.
     */
    private TipoOrientacao tipoOrientacao = new TipoOrientacao();

    /**
     * status - Representa o status da orientacao (concluída ou em andamento).
     */
    private int status;

    /**
     * Representa o id da orientação na página do lattes
     */
    private int idLattes;

    /**
     * Construtor iniciando o objeto com os dados próprios
     * @param descricao - descrição da orientação
     * @param ano - ano da orientação
     * @param tipoOrientacao - tipo da orientação (graduação, especialização, mestrado e doutorado)
     * @param status - concluida ou em andamento
     * @param idLattes - id da orientação no curriculo lattes
     */
    public Orientacao(String descricao, int ano, TipoOrientacao tipoOrientacao, int status, int idLattes) {
        this.descricao = descricao;
        this.ano = ano;
        this.tipoOrientacao = tipoOrientacao;
        this.status = status;
        this.idLattes = idLattes;
    }

    /**
     * Construtor padrão
     */
    public Orientacao() {
    }

    /**
     * Recupera a ano da Orientacao.
     * @return A ano da Orientacao.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Altera a ano da Orientacao.
     * @param ano A nova ano da Orientacao.
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Recupera a descricao da Orientacao.
     * @return A descricao da Orientacao.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a decricao da Orientacao.
     * @param descricao A nova descricao da Orientacao.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Recupera o status da Orientacao.
     * @return O status da Orientacao.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Altera o status da Orientacao.
     * @param status O novo status da Orientacao.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Recupera o tipo da Orientacao.
     * @return O tipo da Orientacao.
     */
    public TipoOrientacao getTipoOrientacao() {
        return tipoOrientacao;
    }

    /**
     * Altera o tipo da Orientacao.
     * @param tipo O novo tipo da Orientacao.
     */
    public void setTipoOrientacao(TipoOrientacao tipoOrientacao) {
        this.tipoOrientacao = tipoOrientacao;
    }

    /**
     * Recupera o id do lattes da orientação
     * @return
     */
    public int getIdLattes() {
        return idLattes;
    }

    /**
     * Altera o id do lattes da orientação
     * @param idLattes
     */
    public void setIdLattes(int idLattes) {
        this.idLattes = idLattes;
    }

    /**
     * Recupera o id da orientação
     * @return id da orientação
     */
    public int getIdOrientacao() {
        return idOrientacao;
    }

    /**
     * Altera o id da orientação
     * @param idOrientacao
     */
    public void setIdOrientacao(int idOrientacao) {
        this.idOrientacao = idOrientacao;
    }

    @Override
    public String toString(){
        return "Orientação: " + descricao +
               "\nTipo: " + tipoOrientacao +
               "\nAno: " + ano +
               "\nStatus: " + (status == 0 ? "Em andamento" : "Concluída") +
               "\nidLates: " + idLattes + "\n";
    }

}
