# CREATE TABLE `parameters_names` (
# 	`id` INT(11) NOT NULL AUTO_INCREMENT,
# 	`name` VARCHAR(50) NOT NULL,
# 	`priority_level` INT(11) NULL,
# 	PRIMARY KEY (`id`)
# );

CREATE TABLE `fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL 
	`description` TEXT NULL 
	`type_id` INT(11) NULL DEFAULT NULL,
	`area_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`type_id`) REFERENCES `fish_types` (`id`),
	FOREIGN KEY (`area_id`) REFERENCES `living_areas` (`id`)
);

CREATE TABLE `fish_types` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`type_name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bait_types` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`type_name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `living_areas` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`area_name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `rain_volume` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`min_mm_level` DOUBLE NULL DEFAULT NULL,
	`max_mm_level` DOUBLE NULL DEFAULT NULL,
	`description` VARCHAR(500) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `baits` (
	`id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`bait_name` VARCHAR(50) NOT NULL 
	`type_id` INT(11) NULL,
	`description` TEXT NOT NULL,
	`is_color` BIT(1) NOT NULL,
	`is_taste` BIT(1) NOT NULL,
	`is_mass` BIT(1) NOT NULL,
	`is_speed` BIT(1) NOT NULL,
	`is_deep` BIT(1) NOT NULL,
 	FOREIGN KEY (`type_id`) REFERENCES `bait_types` (`id`)
);

CREATE TABLE `baits_to_seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NOT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`)
);

CREATE TABLE `baits_mass` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`mass_name` VARCHAR(30) NOT NULL,
	`description` TEXT NOT NULL ,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bait_colors` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`color_name` VARCHAR(20) NOT NULL COLLATE 'utf16_bin',
	`description` TEXT NULL COLLATE 'utf16_bin',
	PRIMARY KEY (`id`)
);

CREATE TABLE `bait_tastes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`taste_name` VARCHAR(30) NOT NULL,
	`description` TEXT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bait_colors_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`color_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`color_id`) REFERENCES `bait_colors` (`id`),
 	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
);

CREATE TABLE `bait_mass_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`mass_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`mass_id`) REFERENCES `baits_mass` (`id`),
	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
);

CREATE TABLE `bait_tastes_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`taste_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`taste_id`) REFERENCES `bait_tastes` (`id`),
	FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
)

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
	`name_type` VARCHAR(20),
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`deep_id` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `fish_settings` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`name_type` VARCHAR(20),
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`nibble_level` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
);

CREATE TABLE `messages` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`string_key` VARCHAR(30) NOT NULL,
	`mess_text` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `fish_nibble` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	fish_id INT(11) NOT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	`nibble_value` DOUBLE NOT NULL,  #%
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
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

CREATE TABLE bait_date (
`id` INT(11) NOT NULL AUTO_INCREMENT,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
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
