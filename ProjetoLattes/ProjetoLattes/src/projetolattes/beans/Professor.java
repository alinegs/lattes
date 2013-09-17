/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

import projetolattes.util.Main;

/**
 * Classe Professor - Representa o Professor
 * @author Thatiany Lima e Aline Gonçalves
 */
public class Professor {

    /**
     * matricula - Representa a matricula do professor.
     */
    private String matricula;

    /**
     * nome - Representa o nome do professor.
     */
    private String nome;

    /**
     * sexo - Representa o sexo do professor.
     */
    private String sexo;

    /**
     * Construtor padrão
     */
    public Professor() {
    }

    /**
     * Construtor iniciando com os dados
     * @param matricula - A matricula do professor
     * @param nome - O nome do Professor
     * @param sexo - O sexo do Professor
     */
    public Professor(String matricula, String nome, String sexo) {
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
    }

    
    /**
     * Recupera a matricula do Professor.
     * @return A matricula do Professor.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Altera a matricula do Professor.
     * @param matricula A nova matricula do Professor.
     * @exception IllegalArgumentException caso a matricula seja nula, vazia, contenha mais que 6 dígitos ou contenha outros caracteres que não sejam números.
     */
    public void setMatricula(String matricula) throws IllegalArgumentException{
        if(matricula != null && !matricula.equals("") && matricula.length() == 6 && matricula.matches("[0-9]+")){
        this.matricula = matricula;
      }
      else{
          throw new IllegalArgumentException(Main.recursos.getString("beans.professor.matricula"));
      }
    }

    /**
     * Recupera o nome do Professor.
     * @return O nome do Professor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Professor.
     * @param nome O novo nome do Professor.
     * @exception IllegalArgumentException caso o nome seja nulo, vazio ou contenha caracteres especiais.
     */
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome != null && !nome.equals("") && nome.matches("[a-zA-záãéíóõú\\s]+")){
            //Aceitar o nome se o mesmo for diferente de null, não for vazio e não conter caracteres especiais
            this.nome = nome;
      }
      else{
          //Lançar uma exceção caso o nome seja null ou vazio
          throw new IllegalArgumentException(Main.recursos.getString("beans.professor.nome"));
      }
    }

    /**
     * Recupera o sexo do Professor.
     * @return O sexo do Professor.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Altera o sexo do Professor.
     * @param sexo O novo sexo do Professor.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
