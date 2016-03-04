CREATE TABLE `fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`description` TEXT NOT NULL,
	`fish_type` VARCHAR(50) NOT NULL,
	`living_area` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `baits` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`bait_type` VARCHAR(50) NOT NULL,
	`description` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bindings_baits_to_fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`bait_id` INT(11) NOT NULL,
	`is_priority` BIT(1) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
);

CREATE TABLE `baits_colors` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`color_name` VARCHAR(20) NOT NULL,
	`description` VARCHAR(500) NOT NULL,
	`cloud_min` DOUBLE NOT NULL,
	`cloud_max` DOUBLE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `baits_mass` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `baits_tastes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`taste_name` VARCHAR(20) NOT NULL,
	`description` TEXT NOT NULL,
	`temp_min` DOUBLE NOT NULL,
	`temp_max` DOUBLE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `binding_baits_to_seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NOT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`)
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

CREATE TABLE `parameters_names` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameters_name` VARCHAR(50) NOT NULL,
	`priority_level` INT(11) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `fishes_nibble_properties` (
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

CREATE TABLE `pond_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`deep_id` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
);

CREATE TABLE `seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`description` TEXT NOT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `year_periods` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`start_period` TIMESTAMP NOT NULL,
	`end_period` TIMESTAMP NOT NULL,
	`result_nibble_value` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
);

