/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import projetolattes.beans.Professor;
import projetolattes.util.Main;

/**
 * Classe que manipula o banco de dados em relação aos professores
 * @author Thatiany Lima e Aline Gonçalves
 */
public class ProfessorBD implements DAO{

    /**
     * p - Representa o beans que será manipulado
     */
    private Professor p;

    /**
     * Inicia o objeto apenas de for passado um bean professor
     * @param p
     */
    public ProfessorBD(Professor p) {
        this.p = p;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
        // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "INSERT INTO professor (matricula, nome, sexo) " +
                "VALUES ('"+ p.getMatricula() +"', '"+ p.getNome() +"'," +
                "'"+ p.getSexo() +"')";


        Transacao.executar(sql);
    }

    /**
     * Deleta o beans no banco
     * @throws Exception
     */
    public void deletar() throws Exception {
        // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "DELETE FROM professor WHERE matricula = " + p.getMatricula();

        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @return o beans professor
     * @throws Exception
     */
    public Professor consultar(int id) throws Exception {
        // Verifica se o bean existe
        if(p == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM professor WHERE matricula = '" + id + "' ";

        Transacao.consultar(sql);

        if(!Transacao.getRs().first())
            throw new Exception("Não foi encontrado professor para a matricula " + id);

        // Se tiver achado, continua aqui

        p.setMatricula(Transacao.getRs().getString("matricula"));
        p.setNome(Transacao.getRs().getString("nome"));
        p.setSexo(Transacao.getRs().getString("sexo"));

        return p;
    }

}
