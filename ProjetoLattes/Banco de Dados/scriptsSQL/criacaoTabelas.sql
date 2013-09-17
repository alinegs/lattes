SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `projeto_lattes` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `projeto_lattes`;

-- -----------------------------------------------------
-- Table `projeto_lattes`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`professor` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`professor` (
  `matricula` VARCHAR(10) NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  `sexo` VARCHAR(9) NULL ,
  PRIMARY KEY (`matricula`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`curriculoLattes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`curriculoLattes` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`curriculoLattes` (
  `idCurriculoLattes` INT NOT NULL AUTO_INCREMENT ,
  `link` VARCHAR(100) NOT NULL ,
  `dataAtualizacao` DATETIME NOT NULL ,
  `professor_matricula` VARCHAR(10) NOT NULL ,
  INDEX `fk_curriculoLattes_professor` (`professor_matricula` ASC) ,
  PRIMARY KEY (`idCurriculoLattes`) ,
  CONSTRAINT `fk_curriculoLattes_professor`
    FOREIGN KEY (`professor_matricula` )
    REFERENCES `projeto_lattes`.`professor` (`matricula` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`tipoBanca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`tipoBanca` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`tipoBanca` (
  `idTipoBanca` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoBanca`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`subTipoBanca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`subTipoBanca` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`subTipoBanca` (
  `idSubTipoBanca` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(200) NULL ,
  PRIMARY KEY (`idSubTipoBanca`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`banca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`banca` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`banca` (
  `idBanca` INT NOT NULL AUTO_INCREMENT ,
  `descricao` TEXT NULL ,
  `ano` INT NULL ,
  `idTipoBanca` INT NULL ,
  `idSubTipoBanca` INT NULL ,
  `idLattes` INT NULL ,
  `idCurriculoLattes` INT NULL ,
  PRIMARY KEY (`idBanca`) ,
  INDEX `fk_banca_tipoBanca` (`idTipoBanca` ASC) ,
  INDEX `fk_banca_subTipoBanca` (`idSubTipoBanca` ASC) ,
  INDEX `fk_banca_curriculoLattes` (`idCurriculoLattes` ASC) ,
  CONSTRAINT `fk_banca_tipoBanca`
    FOREIGN KEY (`idTipoBanca` )
    REFERENCES `projeto_lattes`.`tipoBanca` (`idTipoBanca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_subTipoBanca`
    FOREIGN KEY (`idSubTipoBanca` )
    REFERENCES `projeto_lattes`.`subTipoBanca` (`idSubTipoBanca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_banca_curriculoLattes`
    FOREIGN KEY (`idCurriculoLattes` )
    REFERENCES `projeto_lattes`.`curriculoLattes` (`idCurriculoLattes` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`tipoOrientacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`tipoOrientacao` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`tipoOrientacao` (
  `idTipoOrientacao` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoOrientacao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`orientacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`orientacao` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`orientacao` (
  `idOrientacao` INT NOT NULL AUTO_INCREMENT ,
  `ano` INT NULL ,
  `descricao` TEXT NULL ,
  `status` TEXT NULL ,
  `idLattes` INT NULL ,
  `idTipoOrientacao` INT NULL ,
  `idCurriculoLattes` INT NULL ,
  PRIMARY KEY (`idOrientacao`) ,
  INDEX `fk_orientacao_tipoOrientacao` (`idTipoOrientacao` ASC) ,
  INDEX `fk_orientacao_curriculoLattes` (`idCurriculoLattes` ASC) ,
  CONSTRAINT `fk_orientacao_tipoOrientacao`
    FOREIGN KEY (`idTipoOrientacao` )
    REFERENCES `projeto_lattes`.`tipoOrientacao` (`idTipoOrientacao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orientacao_curriculoLattes`
    FOREIGN KEY (`idCurriculoLattes` )
    REFERENCES `projeto_lattes`.`curriculoLattes` (`idCurriculoLattes` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`tipoProducao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`tipoProducao` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`tipoProducao` (
  `idTipoProducao` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoProducao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`producao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`producao` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`producao` (
  `idProducao` INT NOT NULL AUTO_INCREMENT ,
  `idTipoProducao` INT NULL ,
  `descricao` TEXT NULL ,
  `ano` INT NULL ,
  `idLattes` INT NULL ,
  `idCurriculoLattes` INT NULL ,
  INDEX `fk_producao_tipoProducao` (`idTipoProducao` ASC) ,
  PRIMARY KEY (`idProducao`) ,
  INDEX `fk_producao_curriculoLattes` (`idCurriculoLattes` ASC) ,
  CONSTRAINT `fk_producao_tipoProducao`
    FOREIGN KEY (`idTipoProducao` )
    REFERENCES `projeto_lattes`.`tipoProducao` (`idTipoProducao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producao_curriculoLattes`
    FOREIGN KEY (`idCurriculoLattes` )
    REFERENCES `projeto_lattes`.`curriculoLattes` (`idCurriculoLattes` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto_lattes`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto_lattes`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `projeto_lattes`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT ,
  `matricula` VARCHAR(10) NOT NULL ,
  `senha` VARCHAR(6) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idusuario`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
