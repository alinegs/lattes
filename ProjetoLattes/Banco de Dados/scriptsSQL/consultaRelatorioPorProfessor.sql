SELECT
  prof.nome AS nome_professor,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 0 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_graduacao,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 1 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_especializacao,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 2 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_mestrado,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 3 AND o.idCurriculoLattes = cl.idCurriculoLattes) AS orientacao_doutorado,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 0 AND p.idCurriculoLattes = cl.idCurriculoLattes) AS trabalhos,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 2 AND p.idCurriculoLattes = cl.idCurriculoLattes) AS artigos,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE (p.idTipoProducao = 3 OR p.idTipoProducao = 1) AND p.idCurriculoLattes = cl.idCurriculoLattes) AS livros_capitulos,
  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 0 AND b.idCurriculoLattes = cl.idCurriculoLattes) AS banca_examinadora,
  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 1 AND b.idCurriculoLattes = cl.idCurriculoLattes) AS banca_julgadora

FROM 
  professor prof,
  curriculolattes cl

WHERE
  cl.professor_matricula = prof.matricula