SELECT
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 0) AS orientacao_graduacao,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 1) AS orientacao_especializacao,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 2) AS orientacao_mestrado,
  (SELECT COUNT(o.idOrientacao) FROM orientacao o WHERE o.idTipoOrientacao = 3) AS orientacao_doutorado,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 0) AS trabalhos,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 2) AS artigos,
  (SELECT COUNT(p.idProducao) FROM producao p WHERE p.idTipoProducao = 3 OR p.idTipoProducao = 1) AS livros_capitulos,
  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 0) AS banca_examinadora,
  (SELECT COUNT(b.idBanca) FROM banca b WHERE b.idTipoBanca = 1) AS banca_julgadora