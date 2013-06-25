SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `HotelDB` ;
CREATE SCHEMA IF NOT EXISTS `HotelDB` DEFAULT CHARACTER SET utf8 ;
USE `HotelDB` ;

-- -----------------------------------------------------
-- Table `HotelDB`.`tipo_quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`tipo_quarto` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`tipo_quarto` (
  `idTipo` INT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`quarto` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`quarto` (
  `idQuarto` INT NULL AUTO_INCREMENT ,
  `descricaoQuarto` VARCHAR(45) NULL ,
  `tipo` INT NULL ,
  `capacidade` INT NULL ,
  PRIMARY KEY (`idQuarto`) ,
  INDEX `fk_quarto_tipo_quarto_idx` (`tipo` ASC) ,
  CONSTRAINT `fk_quarto_tipo_quarto`
    FOREIGN KEY (`tipo` )
    REFERENCES `HotelDB`.`tipo_quarto` (`idTipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`visitante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`visitante` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`visitante` (
  `idVisitante` INT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL ,
  `telefone` VARCHAR(13) NULL ,
  `email` VARCHAR(45) NULL ,
  PRIMARY KEY (`idVisitante`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`reserva` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`reserva` (
  `codReserva` INT NULL AUTO_INCREMENT ,
  `idVisitante` INT NULL ,
  `idQuarto` INT NULL ,
  `data_entrada` DATE NULL ,
  `data_saida` DATE NULL ,
  `pagamento` DOUBLE NULL ,
  `status` TINYINT(1) NULL ,
  PRIMARY KEY (`codReserva`) ,
  INDEX `fk_reserva_quarto1_idx` (`idQuarto` ASC) ,
  INDEX `fk_reserva_visitante1_idx` (`idVisitante` ASC) ,
  CONSTRAINT `fk_reserva_quarto1`
    FOREIGN KEY (`idQuarto` )
    REFERENCES `HotelDB`.`quarto` (`idQuarto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_visitante1`
    FOREIGN KEY (`idVisitante` )
    REFERENCES `HotelDB`.`visitante` (`idVisitante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`usuario` (
  `idUsuario` INT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`permissao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`permissao` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`permissao` (
  `idPermissao` INT NULL AUTO_INCREMENT ,
  `create` TINYINT(1) NULL ,
  `read` TINYINT(1) NULL ,
  `update` TINYINT(1) NULL ,
  `delete` TINYINT(1) NULL ,
  PRIMARY KEY (`idPermissao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`perfil` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`perfil` (
  `idPerfil` INT NULL AUTO_INCREMENT ,
  `descPerfil` VARCHAR(45) NULL ,
  `status` TINYINT(1) NULL ,
  `permissao_idPermissao` INT NOT NULL ,
  PRIMARY KEY (`idPerfil`) ,
  INDEX `fk_perfil_permissao1_idx` (`permissao_idPermissao` ASC) ,
  CONSTRAINT `fk_perfil_permissao1`
    FOREIGN KEY (`permissao_idPermissao` )
    REFERENCES `HotelDB`.`permissao` (`idPermissao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelDB`.`usuario_has_perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `HotelDB`.`usuario_has_perfil` ;

CREATE  TABLE IF NOT EXISTS `HotelDB`.`usuario_has_perfil` (
  `usuario_idUsuario` INT NOT NULL ,
  `perfil_idPerfil` INT NOT NULL ,
  PRIMARY KEY (`usuario_idUsuario`, `perfil_idPerfil`) ,
  INDEX `fk_usuario_has_perfil_perfil1_idx` (`perfil_idPerfil` ASC) ,
  INDEX `fk_usuario_has_perfil_usuario1_idx` (`usuario_idUsuario` ASC) ,
  CONSTRAINT `fk_usuario_has_perfil_usuario1`
    FOREIGN KEY (`usuario_idUsuario` )
    REFERENCES `HotelDB`.`usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_perfil_perfil1`
    FOREIGN KEY (`perfil_idPerfil` )
    REFERENCES `HotelDB`.`perfil` (`idPerfil` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
