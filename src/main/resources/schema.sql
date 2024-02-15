CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE `blog`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `middleName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  `passwordHash` VARCHAR(32) NOT NULL,
  `registeredAt` DATETIME NOT NULL,
  `lastLogin` DATETIME NULL DEFAULT NULL,
  `intro` TINYTEXT NULL DEFAULT NULL,
  `profile` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_mobile` (`mobile` ASC),
  UNIQUE INDEX `uq_email` (`email` ASC) );