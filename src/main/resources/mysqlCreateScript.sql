CREATE DATABASE `dmf-manager`;

CREATE TABLE `Task` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name`  VARCHAR(25) NOT NULL,
  `description` VARCHAR(500),
  PRIMARY KEY (`id`)
);