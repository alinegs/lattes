/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.bd;

import java.sql.ResultSet;
import java.util.ArrayList;
import projetolattes.beans.Banca;
import projetolattes.beans.CurriculoLattes;
import projetolattes.beans.Orientacao;
import projetolattes.beans.Producao;
import projetolattes.util.Main;
import projetolattes.util.Utilidades;

/**
 * Classe que manipula o banco de dados em relação ao curriculo lattes
 * @author Thatiany Lima e Aline Gonçalves
 */
public class CurriculoLattesBD implements DAO {

    /**
     * c - Representa o beans que será manipulado
     */
    private CurriculoLattes c;

    /**
     * Inicia o objeto apenas de for passado um id e um bean curriculoLattes
     * @param c
     */
    public CurriculoLattesBD(CurriculoLattes c){
        this.c = c;
    }

    /**
     * Salva o beans no banco
     * @throws Exception
     */
    public void salvar() throws Exception {
       // Verifica se o bean existe
        if(c == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "INSERT INTO curriculoLattes (idCurriculoLattes, link, dataAtualizacao, professor_matricula) " +
                "VALUES (null, '"+ c.getLink() +"'," +
                "'"+ Utilidades.formatarData("ano-mes-dia hora:minuto:segundo", c.getDataAtualizacao().getTime()) +"', '"+ c.getProfessor().getMatricula() +"')";

        //System.out.println("Tentando salvar lattes: " + sql);

        // Salva só os dados do curriculo
        Transacao.executar(sql);

        // Se tiver executado com sucesso, recupera o id gerado
        Transacao.consultar("SELECT LAST_INSERT_ID() AS ultimo_id");

        if(Transacao.getRs().first())
            c.setIdCurriculoLattes(Transacao.getRs().getInt("ultimo_id"));

        // Salva as bancas uma a uma
        Banca[] b = c.getBancas();
        for( int i = 0; i < b.length; i++ )
            new BancaBD( b[i], c.getIdCurriculoLattes() ).salvar();

        //Salva as produções
        Producao[] p = c.getProducoes();
        for( int i = 0; i < p.length; i++ )
            new ProducaoBD( p[i], c.getIdCurriculoLattes() ).salvar();

        //Salva as orientações
        Orientacao[] o = c.getOrientacoes();
        for( int i = 0; i < o.length; i++ )
            new OrientacaoBD( o[i], c.getIdCurriculoLattes() ).salvar();
    }

    /**
     * Deleta o beans do banco
     * @throws Exception
     */
    public void deletar() throws Exception {
        // Verifica se o bean existe
        if(c == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        // O banco foi criado com DELETE CASCADE, ou seja, deletando um curriculo, deleta-se também as bancas
        // orientações e produções, atraves do proprio mysql
        String sql = "DELETE FROM curriculoLattes WHERE idCurriculoLattes = " + c.getIdCurriculoLattes();

        Transacao.executar(sql);
    }

    /**
     * Consulta o beans no banco
     * @param id
     * @return o beans curriculo
     * @throws Exception
     */
    @SuppressWarnings("empty-statement")
    public CurriculoLattes consultar(int id) throws Exception {
        // Verifica se o bean existe
        if(c == null)
            throw new Exception(Main.recursos.getString("bd.objeto.nulo"));

        String sql = "SELECT * FROM curriculoLattes WHERE idCurriculoLattes = " + id;

        Transacao.consultar(sql);

        if(!Transacao.getRs().first())
            throw new Exception("Não foi encontrado curriculo para a matricula " + id);

        c.setLink(Transacao.getRs().getString("link"));
        c.setDataAtualizacao(Transacao.getRs().getDate("dataAtualizacao"));
        c.setIdCurriculoLattes(Transacao.getRs().getInt("idCurriculoLattes"));
        c.getProfessor().setMatricula(Transacao.getRs().getString("professor_matricula"));

        // Arraylists para armazenar as bancas, orientações e produções
        ArrayList<Banca> bancas = new ArrayList<Banca>();
        ArrayList<Orientacao> orientacoes = new ArrayList<Orientacao>();
        ArrayList<Producao> producoes = new ArrayList<Producao>();

        sql = "SELECT * FROM banca WHERE idCurriculoLattes = " + id;
        Transacao.consultar(sql);
        ResultSet rs = Transacao.getRs();
        while(rs.next()){
            Banca b = new Banca();
            b.setAno(rs.getInt("ano"));
            b.setDescricao(rs.getString("descricao"));
            b.setIdBanca(rs.getInt("idBanca"));
            b.setIdLattes(rs.getInt("idLattes"));
            b.getSubTipoBanca().setIdSubTipoBanca(rs.getInt("idSubTipoBanca"));
            b.getTipoBanca().setIdTipoBanca(rs.getInt("idTipoBanca"));
            bancas.add(b);
        }

        sql = "SELECT * FROM orientacao WHERE idCurriculoLattes = " + id;
        Transacao.consultar(sql);
        ResultSet res = Transacao.getRs();
        while(res.next()){
            Orientacao o = new Orientacao();
            o.setAno(res.getInt("ano"));
            o.setDescricao(res.getString("descricao"));
            o.setIdLattes(res.getInt("idLattes"));
            o.setIdOrientacao(res.getInt("idOrientacao"));
            o.setStatus(res.getInt("status"));
            o.getTipoOrientacao().setIdTipoOrientaco(res.getInt("idTipoOrientacao"));
            orientacoes.add(o);
        }

        sql = "SELECT * FROM producao WHERE idCurriculoLattes = " + id;
        Transacao.consultar(sql);
        res = Transacao.getRs();
        while(res.next()){
            Producao p = new Producao();
            p.getTipoProducao().setIdTipoProducao(res.getInt("idTipoProducao"));
            p.setAno(res.getInt("ano"));
            p.setDescricao(res.getString("descricao"));
            p.setIdLattes(res.getInt("idLattes"));
            p.setIdProducao(res.getInt("idProducao"));
            producoes.add(p);
        }

        // Associa as bancas, orientações e produções
        Banca[] cb = new Banca[bancas.size()];
        Orientacao[] co = new Orientacao[orientacoes.size()];
        Producao[] cp = new Producao[producoes.size()];

        for(int i = 0, size = bancas.size(); i < size; cb[i] = bancas.get(i), i++);
        for(int i = 0, size = orientacoes.size(); i < size; co[i] = orientacoes.get(i), i++);
        for(int i = 0, size = producoes.size(); i < size; cp[i] = producoes.get(i), i++);

        c.setBancas(cb);
        c.setOrientacoes(co);
        c.setProducoes(cp);

        return c;
    }

}
