SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema user
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `user` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `user` ;

-- -----------------------------------------------------
-- Table `user`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`users` (
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `sex` VARCHAR(6) NULL,
  `phone` VARCHAR(20) NULL,
  `email` VARCHAR(60) NULL,
  `address` VARCHAR(45) NULL,
  `previliger` VARCHAR(5) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`login`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
