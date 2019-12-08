/*---- Creacion de la tabla de usuario para el login ---*/

-- MySQL Workbench Synchronization
-- Generated: 2019-12-07 20:14
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Andorid

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `LaSalle` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `LaSalle`.`usuario` (
  `id_usr` INT(11) NOT NULL,
  `usuario_usuario` VARCHAR(60) NOT NULL,
  `usuario_contraseña` VARCHAR(45) NOT NULL,
  `usuario_nombre` VARCHAR(45) NULL DEFAULT 'Sin nombre',
  `usuario_paterno` VARCHAR(45) NULL DEFAULT 'Sin paterno',
  `usuario_materno` VARCHAR(45) NULL DEFAULT 'Sin materno',
  `usuario_status` INT(11) NOT NULL COMMENT '1 activado \n2 desactivado',
  `usuario_fecha` DATE NOT NULL COMMENT 'Fecha de insercion de base de datos',
  PRIMARY KEY (`id_usr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*-------------------------------------------------------------*/
