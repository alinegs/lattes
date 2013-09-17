/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe TipoBanca - Representa os tipos das Bancas que o professor participou
 * @author Thatiany Lima e Aline Gonçalves
 */
public class TipoBanca {

    /**
     * idTipoBanca - Representa o id do tipo da banca.
     */
    private int idTipoBanca;

    /**
     * nome - Representa o nome do tipo da banca.
     */
    private String nome;

    /**
     * Construtor iniciando com os dados
     * @param idTipoBanca - O ID do tipo da Banca
     * @param nome - O nome do tipo do banca (julgadora, examinadora)
     */
    public TipoBanca(int idTipoBanca, String nome) {
        this.idTipoBanca = idTipoBanca;
        this.nome = nome;
    }

    /**
     * Construtor padrão
     */
    public TipoBanca() {
    }

    /**
     * Recupera o ID do tipo da Banca.
     * @return O ID do tipo da Banca.
     */
    public int getIdTipoBanca() {
        return idTipoBanca;
    }

    /**
     * Altera o ID do tipo da Banca.
     * @param idTipoBanca O novo ID do tipo da Banca.
     */
    public void setIdTipoBanca(int idTipoBanca) {
        this.idTipoBanca = idTipoBanca;
    }

    /**
     * Recupera o nome do tipo da Banca.
     * @return O nome do tipo da Banca.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do tipo da Banca.
     * @param nome O novo nome do tipo da Banca.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Tipo banca: " + nome;
    }
}
