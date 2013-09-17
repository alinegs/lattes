/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe SubTipoBanca - Representa o subtipo da Banca que o professor participou
 * @author Thatiany Lima e Aline Gonçalves
 */
public class SubTipoBanca {

    /**
     * idSubTipoBanca - Representa o id do subtipo da banca.
     */
    private int idSubTipoBanca = -1;

    /**
     * nome - Representa o nome do tipo da banca.
     */
    private String nome;

    /**
     * Construtor iniciando com os dados
     * @param idSubTipoBanca - ID do subTipo da Banca
     * @param nome - O nome do SubTipo da Banca
     */
    public SubTipoBanca(int idSubTipoBanca, String nome) {
        this.idSubTipoBanca = idSubTipoBanca;
        this.nome = nome;
    }

    /**
     * Construtor padrão
     */
    public SubTipoBanca() {
    }

    /**
     * Recupera o ID do subtipo da Banca.
     * @return O ID do subtipo da Banca.
     */
    public int getIdSubTipoBanca() {
        return idSubTipoBanca;
    }

    /**
     * Altera o ID do subtipo da Banca.
     * @param idSubTipoBanca O novo ID do subtipo da Banca.
     */
    public void setIdSubTipoBanca(int idSubTipoBanca) {
        this.idSubTipoBanca = idSubTipoBanca;
    }

    /**
     * Recupera o nome do subtipo da Banca.
     * @return O nome do subtipo da Banca.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do subtipo da Banca.
     * @param nome O novo nome do subtipo da Banca.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Subtipo banca: " + nome;
    }
}
