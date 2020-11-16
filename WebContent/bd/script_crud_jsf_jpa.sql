
create database daw2_crud_jsf_jpa;

-- -----------------------------------------------------
-- Table `daw2_crud_jsf_jpa`.`TB_GENERO`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `daw2_crud_jsf_jpa`.`TB_GENERO` (
  `GEN_COD` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `GEN_NOM` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`GEN_COD`) )
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `daw2_crud_jsf_jpa`.`TB_PELICULA`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `daw2_crud_jsf_jpa`.`TB_PELICULA` (
  `PEL_COD` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `PEL_NOM` VARCHAR(45) NOT NULL ,
  `PEL_HINI` INT NULL ,
  `GEN_COD` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`PEL_COD`) ,
  INDEX `fk_TB_PELICULA_TB_GENERO` (`GEN_COD` ASC) ,
  CONSTRAINT `fk_TB_PELICULA_TB_GENERO`
    FOREIGN KEY (`GEN_COD` )
    REFERENCES `daw2_crud_jsf_jpa`.`TB_GENERO` (`GEN_COD` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



INSERT INTO `daw2_crud_jsf_jpa`.`tb_genero` (`GEN_NOM`) VALUES ('Drama');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_genero` (`GEN_NOM`) VALUES ('Accion');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_genero` (`GEN_NOM`) VALUES ('Comedia');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_genero` (`GEN_NOM`) VALUES ('Ciencia Ficcion');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_genero` (`GEN_NOM`) VALUES ('Terror');

INSERT INTO `daw2_crud_jsf_jpa`.`tb_pelicula` (`PEL_NOM`, `PEL_HINI`, `GEN_COD`) VALUES ('Ted', '20', '3');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_pelicula` (`PEL_NOM`, `PEL_HINI`, `GEN_COD`) VALUES ('Lo Imposible', '16', '1');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_pelicula` (`PEL_NOM`, `PEL_HINI`, `GEN_COD`) VALUES ('Prometheus', '18', '4');
INSERT INTO `daw2_crud_jsf_jpa`.`tb_pelicula` (`PEL_NOM`, `PEL_HINI`, `GEN_COD`) VALUES ('Rec 4', '20', '5');

