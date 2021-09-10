-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`baseaddress` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `code` VARCHAR(30) NULL DEFAULT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3626
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`dongcode` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongcode` VARCHAR(45) NOT NULL,
  `city` TEXT NULL DEFAULT NULL,
  `gugun` TEXT NULL DEFAULT NULL,
  `dong` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`guguncode` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `gugun_code` VARCHAR(10) NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugun_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`housedeal` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `dealAmount` VARCHAR(50) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(30) NULL DEFAULT NULL,
  `dealDay` VARCHAR(30) NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  `dongcode` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `housedeal2_dongcode_fk_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `housedeal2_dongcode_fk`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`houseinfo` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 5990
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`sidocode` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sido_code` VARCHAR(10) NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`user` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(12) NOT NULL,
  `nickname` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`user_copy1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`user_copy1` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`user_copy1` (
  `dd` INT NOT NULL,
  `usercolff` VARCHAR(45) NULL,
  PRIMARY KEY (`dd`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`favorite_dong`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`favorite_dong` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`favorite_dong` (
  `user_id` VARCHAR(20) NOT NULL,
  `dongcode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`, `dongcode`),
  INDEX `favorite_dong_dongcode_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `favorite_dong_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `happyhouse`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `favorite_dong_dongcode`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`dongcode` (`dongcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`eco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`eco` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`eco` (
  `idx` INT NOT NULL,
  `company_name` VARCHAR(50) NOT NULL,
  `license_number` VARCHAR(50) NULL,
  `buisiness_code` VARCHAR(50) NULL,
  `business_name` VARCHAR(50) NULL,
  `inspection_date` VARCHAR(50) NULL,
  `agency_code` VARCHAR(50) NULL,
  `agency_name` VARCHAR(50) NULL,
  `is_disposed` VARCHAR(50) NULL,
  `inspection` VARCHAR(50) NULL,
  `road_address` VARCHAR(50) NULL,
  PRIMARY KEY (`idx`, `company_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `happyhouse`.`shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `happyhouse`.`shop` ;

CREATE TABLE IF NOT EXISTS `happyhouse`.`shop` (
  `dongcode` VARCHAR(45) NOT NULL,
  `shopName` VARCHAR(45) NULL,
  `shopkind` VARCHAR(45) NULL,
  `shipAddress` VARCHAR(45) NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
