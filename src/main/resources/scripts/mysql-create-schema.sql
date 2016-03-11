CREATE TABLE `parameters_names` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`priority_level` INT(11) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`description` VARCHAR(500),
	`type` VARCHAR(50) NOT NULL,
	`living_area` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `baits` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`type` VARCHAR(50) NOT NULL,
	`description` VARCHAR(200),
	PRIMARY KEY (`id`)
);


CREATE TABLE baits_settings (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`type` VARCHAR(50) NOT NULL,
	`description` VARCHAR(200),
	`cloud_min` DOUBLE,
	`cloud_max` DOUBLE,
	`temp_min` DOUBLE,
	`temp_max` DOUBLE,
	PRIMARY KEY (`id`)
);




CREATE TABLE `daily_forecast_weathers` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`city` VARCHAR(30) NOT NULL,
	`date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`temp_day` FLOAT NOT NULL,
	`temp_night` FLOAT NOT NULL,
	`temp_even` FLOAT NOT NULL,
	`temp_morn` FLOAT NOT NULL,
	`pressure` FLOAT NOT NULL,
	`wind_speed` FLOAT NOT NULL,
	`wind_deg` INT(11) NOT NULL,
	`humidity` INT(11) NOT NULL,
	`clouds` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
);



CREATE TABLE `pond` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`deep_id` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
);

CREATE TABLE `fishes_nibble` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`nibble_level` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
);

CREATE TABLE `messages` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`string_key` VARCHAR(30) NOT NULL,
	`mess_text` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`description` VARCHAR(400),
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `year_periods` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	fish_id INT(11) NOT NULL,
	seasons_id INT(11) NOT NULL,
	`result_nibble_value` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`),
	FOREIGN KEY (`seasons_id`) REFERENCES `seasons` (`id`)
);


CREATE TABLE `baits_to_fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`bait_id` INT(11) NOT NULL,
	`is_priority` BIT(1) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
);

CREATE TABLE `baits_to_seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NOT NULL,
	`seasons_id` INT(11) NOT NULL,
	FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`),
	FOREIGN KEY (`seasons_id`) REFERENCES `seasons` (`id`),
	PRIMARY KEY (`id`)

);

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(30) NOT NULL,
	password VARCHAR(100),
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	role VARCHAR(20),
	PRIMARY KEY (id)
);
