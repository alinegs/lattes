/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.beans;

import projetolattes.util.Main;

/**
 *
 * @author Thatiany
 */
public class Usuario {

    /**
     * idUsuario - Representa o ID do usuário.
     */
    private int idUsuario;

    /**
     * maricula - Representa a matricula do usuário, a qual é usada como login.
     */
    private String matricula;

    /**
     * senha - Representa a senha do usuário, a qual é usada para realizar login.
     */
    private String senha;

    /**
     * senha - Representa a nome do usuário.
     */
    private String nome;

    /**
     * Construtor padrão
     */
    public Usuario() {
    }

    /**
     * Construtor iniciando com os dados
     * @param idUsuario - O ID do usuário
     * @param matricula - A matrícula do usuário (loggin)
     * @param senha - A senha do usuário
     * @param nome  - O nome do usuário
     */
    public Usuario(int idUsuario, String matricula, String senha, String nome) {
        this.idUsuario = idUsuario;
        this.matricula = matricula;
        this.senha = senha;
        this.nome = nome;
    }

    /**
     * Recupera o ID do Usuario.
     * @return O ID do Usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Altera o ID do Usuario.
     * @param idUsuario O novo ID do Usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Recupera a matricula do Usuario.
     * @return A matricula do Usuario.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Altera a matricula do Usuario.
     * @param matricula A nova matricula do Usuario.
     * @exception IllegalArgumentException caso a matricula seja nula, vazia, contenha mais que 6 dígitos ou contenha outros caracteres que não sejam números.
     */
    public void setMatricula(String matricula) throws IllegalArgumentException {
        if(matricula != null && !matricula.equals("") && matricula.length() == 9 && matricula.matches("[0-9]+")){
        this.matricula = matricula;
      }
      else{
          throw new IllegalArgumentException(Main.recursos.getString("beans.professor.matricula"));
      }
    }

    /**
     * Recupera o nome do Usuario.
     * @return O nome do Usuario.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Usuario.
     * @param nome O novo nome do Usuario.
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
     * Recupera a senha do Usuario.
     * @return A senha do Usuario.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Altera a senha do Usuario.
     * @param senha A nova senha do Usuario.
     * @exception caso  a senha seja nula, vazia, contenha caracteres especiais ou tenha mais que 10 dígitos.
	 */
    public void setSenha(String senha) throws IllegalArgumentException{
        if(senha != null && !senha.equals("") && senha.length() <= 10 && senha.matches("[a-zA-záãéíóõú\\s0-9]+")){
        this.senha = senha;
      }
      else{
          throw new IllegalArgumentException(Main.recursos.getString("beans.usuario.senha"));
      }
    }
    
}
