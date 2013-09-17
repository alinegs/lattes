/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

/**
 * Classe TipoProducao - Representa os tipos de Produções do professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class TipoProducao {

    /**
     * idTipoProducao - Representa o id do tipo da producao.
     */
    private int idTipoProducao;

    /**
     * nome - Representa o nome do tipo da producao.
     */
    private String nome;

    /**
     * Inicia o tipo da produção
     * @param idTipoProducao - O ID do tipo da orientação
     * @param nome - O nome do tipo da produção
     */
    public TipoProducao(int idTipoProducao, String nome) {
        this.idTipoProducao = idTipoProducao;
        this.nome = nome;
    }

    /**
     * Construtor padrão
     */
    public TipoProducao() {
    }
    
    /**
     * Recupera o ID do tipo da Produção.
     * @return O ID do tipo da Produção.
     */
    public int getIdTipoProducao() {
        return idTipoProducao;
    }

    /**
     * Altera o ID do tipo da Produção.
     * @param idTipoProducao O novo ID do tipo da Produção.
     */
    public void setIdTipoProducao(int idTipoProducao) {
        this.idTipoProducao = idTipoProducao;
    }

     /**
     * Recupera o nome do tipo da Produção.
     * @return O nome do tipo da Produção.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do tipo da Produção.
     * @param nome O novo nome do tipo da Produção.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Tipo produção: " + nome;
    }
}
