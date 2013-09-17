/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolattes.extracaoHTML;

/**
 * Define todos os regex a serem utilizados nas extrações
 * @author Thatiany Lima e Aline Gonçalves
 */
public class RegexConfig {

    /**
     * Regex pra capturar a data da ultima atualização do c lattes
     */
    public static final String REGEX_LATTES_DATA_ATUALIZACAO = "Última\\s+atualização\\s+do\\s+currículo\\s+em\\s+\\d{1,2}/\\d{1,2}/\\d{2,4}";

    /**
     * Regex pra fazer trim no meio das palavras
     */
    public static final String REGEX_TRIM_INTERNO = "[\\s]{2,}";

    /**
     * Regex para o inicio de texto lattes
     */
    public static final String REGEX_LATTES_ID_TEXTO = "<[^>]*class=\"ProdBibliCelula10\">(\\d+)\\.\\s+</td>";

    /**
     * Regex para o inicio de texto lattes
     */
    public static final String REGEX_LATTES_INICIO_TEXTO = "<td[^>]*class=\"textoProducao\">(.*?)</td>";

    /**
     * Regex para fim de texto lattes
     */
    public static final String REGEX_LATTES_FIM_TEXTO = "(<td bgcolor=\"white\"[^>]*>|</BODY>|</body>|<div class=\"holder\">|<a name=\"Orientac[^>]*>)";

    /**
     * Regex para ano de lattes
     */
     public static final String REGEX_LATTES_ANO = "[:,\\.]\\s+(\\d{4})[,\\.]";

    /**
     * Define todas as regex para encontrar as produções de trabalhos completos e publicados em anais
     */
    public static final String REGEX_PRODUCAO_TRABALHO = "<[^>]*class=\"agrupadorsub\">\\s+Trabalhos\\s+completos\\s+publicados\\s+em\\s+anais\\s+de\\s+congressos";
    
    /**
     * Define todas as regex para encontrar as produções de trabalhos completos e publicados em anais
     */
    public static final String REGEX_PRODUCAO_LIVRO = "<[^>]*class=\"agrupadorsub\">\\s+Livros\\s+publicados/organizados\\s+ou\\s+edições";

    /**
     * Define todas as regex para encontrar as produções de trabalhos completos e publicados em anais
     */
    public static final String REGEX_PRODUCAO_CAPITULOS = "<[^>]*class=\"agrupadorsub\">\\s+Capítulos\\s+de\\s+livros\\s+publicados";

    /**
     * Define todas as regex para encontrar as produções de trabalhos completos e publicados em anais
     */
    public static final String REGEX_PRODUCAO_ARTIGO = "<[^>]*class=\"agrupadorsub\">\\s+Artigos\\s+completos\\s+publicados\\s+em\\s+periódicos";

    /**
     * Define todas as regex para encontrar as bancas julgadoras
     */
    public static final String REGEX_BANCA_JULGADORA_INICIO = "<[^>]*class=\"AtuaProfTabelaCelula95\">\\s+Participação\\s+em\\s+bancas\\s+de\\s+comissões\\s+julgadoras";
    public static final String REGEX_BANCA_JULGADORA_FIM = "(<[^>]*class=\"AtuaProfTabelaCelula95\">|</BODY>|</body>)";

    /**
     * Define todas as regex para encontrar as bancas examinadoras
     */
    public static final String REGEX_BANCA_EXAMINADORA_INICIO = "<[^>]*class=\"AtuaProfTabelaCelula95\">\\s+Participação\\s+em\\s+bancas\\s+examinadoras";
    public static final String REGEX_BANCA_EXAMINADORA_FIM = REGEX_BANCA_JULGADORA_FIM;

    /**
     * Define um regex para capturar os subtipos de banca
     */
    public static final String REGEX_BANCA_SUBTIPO = "<[^>]*class=\"agrupadorsub\">([^<]+)<[^>]+>";

    /**
     * Regex para capturar as orientações em andamento PRECISA AINDA PEGAR OS SUBTIPOS
     */
    public static final String REGEX_ORIENTACAO_ANDAMENTO_INICIO = "<[^>]*class=\"AtuaProfTabelaCelula95\">\\s+Orientações\\s+em\\s+andamento";
    public static final String REGEX_ORIENTACAO_ANDAMENTO_FIM = REGEX_BANCA_JULGADORA_FIM;

    /**
     * Regex para capturar as orientações concluídas PRECISA AINDA PEGAR OS SUBTIPOS
     */
    public static final String REGEX_ORIENTACAO_CONCLUIDA_INICIO = "<[^>]*class=\"AtuaProfTabelaCelula95\">\\s+Supervisões\\s+e\\s+orientações\\s+concluídas";
    public static final String REGEX_ORIENTACAO_CONCLUIDA_FIM = REGEX_BANCA_JULGADORA_FIM;

    /**
     * Regez para capturar as orientações de graduação, especialização, mestrado e doutorado
     */
    public static final String REGEX_ORIENTACAO_GRADUACAO = "<[^>]*class=\"agrupadorsub\">\\s*Trabalho\\s+de\\s+conclusão\\s+de\\s+curso\\s+de\\s+graduação";
    public static final String REGEX_ORIENTACAO_ESPECIALIZACAO = "<[^>]*class=\"agrupadorsub\">\\s*Monografia\\s+de\\s+conclusão\\s+de\\s+curso\\s+de\\s+aperfeiçoamento/especialização";
    public static final String REGEX_ORIENTACAO_MESTRADO = "<[^>]*class=\"agrupadorsub\">\\s*Dissertação\\s+de\\s+mestrado";
    public static final String REGEX_ORIENTACAO_DOUTORADO = "<[^>]*class=\"agrupadorsub\">\\s*Tese\\s+de\\s+doutorado";
}
