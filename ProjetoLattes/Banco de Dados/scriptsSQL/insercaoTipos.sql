USE projeto_lattes;
-- Insere os tipos de orientação
INSERT INTO tipoOrientacao (idTipoOrientacao, nome) VALUES (0, "Graduação");
INSERT INTO tipoOrientacao (idTipoOrientacao, nome) VALUES (1, "Especialização");
INSERT INTO tipoOrientacao (idTipoOrientacao, nome) VALUES (2, "Mestrado");
INSERT INTO tipoOrientacao (idTipoOrientacao, nome) VALUES (3, "Doutorado");

-- Insere os tipos de produção
INSERT INTO tipoProducao (idTipoProducao, nome) VALUES (0, "Trabalhos");
INSERT INTO tipoProducao (idTipoProducao, nome) VALUES (1, "Capítulos");
INSERT INTO tipoProducao (idTipoProducao, nome) VALUES (2, "Artigos");
INSERT INTO tipoProducao (idTipoProducao, nome) VALUES (3, "Livros");

-- Insere os tipos de banca
INSERT INTO tipoBanca (idTipoBanca, nome) VALUES (0, "Examinadora");
INSERT INTO tipoBanca (idTipoBanca, nome) VALUES (1, "Julgadora");

-- Os subtipos de bancas são muuito variáveis e serão cadastrados para
-- cada professor