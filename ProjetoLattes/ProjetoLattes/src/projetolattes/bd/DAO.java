/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

/**
 * Classe que apresenta os métodos genéricos das classes que manipulam o banco de dados
 * @author Thatiany Lima e Aline Gonçalves
 */
public interface DAO {

    /**
     * Método genérico que salva o objeto atual no banco
     * @throws Exception
     */
    public void salvar() throws Exception;

    /**
     * Método genérico que obriga a deleção
     * @throws Exception
     */
    public void deletar() throws Exception;

    /**
     * Recupera um registro do objeto no banco
     * @param id
     * @throws Exception
     */
    public Object consultar(int id) throws Exception;

}
