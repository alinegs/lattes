/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe TipoOrientacao - Representa os tipos das Orientacões do professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class TipoOrientacao {

    /**
     * idTipoOrientacao - Representa o id do tipo da orientacao.
     */
    private int idTipoOrientaco;

    /**
     * nome - Representa o nome do tipo da orientacao.
     */
    private String nome;

    /**
     * Construtor padrão
     */
    public TipoOrientacao() {
    }

    /**
     * Inicia o objeto com dados próprios
     * @param idTipoOrientaco - O ID do tipo da orientação
     * @param nome - O nome do Tipo da Orientação
     */
    public TipoOrientacao(int idTipoOrientaco, String nome) {
        this.idTipoOrientaco = idTipoOrientaco;
        this.nome = nome;
    }

    /**
     * Recupera o ID do tipo da Orientação.
     * @return O ID do tipo da Orientação.
     */
    public int getIdTipoOrientaco() {
        return idTipoOrientaco;
    }

    /**
     * Altera o ID do tipo da Orientação.
     * @param idTipoOrientacao O novo ID do tipo da Orientação.
     */
    public void setIdTipoOrientaco(int idTipoOrientaco) {
        this.idTipoOrientaco = idTipoOrientaco;
    }

    /**
     * Recupera o nome do tipo da Orientação.
     * @return O nome do tipo da Orientação.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do tipo da Orientação.
     * @param nome O novo nome do tipo da Orientação.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Tipo orientação: " + nome;
    }
}
