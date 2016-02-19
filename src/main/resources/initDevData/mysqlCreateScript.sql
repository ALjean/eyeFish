CREATE TABLE `activity_levels` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	`min_value` DOUBLE NULL DEFAULT NULL,
	`max_value` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `baits` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`bait_type` VARCHAR(30) NOT NULL DEFAULT '0',
	`description` TEXT NOT NULL,
	`is_color` BIT(1) NOT NULL,
	`is_taste` BIT(1) NOT NULL,
	`is_deep` BIT(1) NOT NULL,
	`is_weight` BIT(1) NOT NULL,
	`is_speed` BIT(1) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7;

CREATE TABLE `baits_colors` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`color_name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `baits_deeps` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`deep_level` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `baits_speeds` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`speed` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7;

CREATE TABLE `baits_tastes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`taste_name` VARCHAR(20) NOT NULL,
	`description` TEXT NULL,
	`min_temp_value` DOUBLE NOT NULL,
	`max_temp_value` DOUBLE NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6;

CREATE TABLE `baits_weights` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`description` TEXT NULL,
	`fish_type` INT(11) NULL DEFAULT NULL,
	`living_area` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=14;

CREATE TABLE `seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`description` TEXT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=13;

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
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `parameters_names` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameters_name` VARCHAR(50) NOT NULL,
	`priority_level` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=9;

CREATE TABLE `seasons` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`description` TEXT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=13;

CREATE TABLE `year_periods` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`start_period` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`end_period` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	`result_nibble_value` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `fish_id` (`fish_id`),
	CONSTRAINT `year_periods_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `baits_colors_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL DEFAULT '0',
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`color_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `color_id` (`color_id`),
	INDEX `FK_baits_colors_properties_envirmoment_parameters_names` (`parameter_id`),
	CONSTRAINT `FK_baits_colors_properties_envirmoment_parameters_names` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`),
	CONSTRAINT `baits_colors_properties_ibfk_1` FOREIGN KEY (`color_id`) REFERENCES `baits_colors` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=15;

CREATE TABLE `baits_deep_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NULL DEFAULT NULL,
	`min_value` DOUBLE NULL DEFAULT NULL,
	`max_value` DOUBLE NULL DEFAULT NULL,
	`deep_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `parameter_id` (`parameter_id`),
	INDEX `deep_id` (`deep_id`),
	CONSTRAINT `baits_deep_properties_ibfk_1` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`),
	CONSTRAINT `baits_deep_properties_ibfk_2` FOREIGN KEY (`deep_id`) REFERENCES `baits_deeps` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7;

CREATE TABLE `baits_speeds_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NULL DEFAULT NULL,
	`min_value` DOUBLE NULL DEFAULT NULL,
	`max_value` DOUBLE NULL DEFAULT NULL,
	`speed_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `parameter_id` (`parameter_id`),
	INDEX `speed_id` (`speed_id`),
	CONSTRAINT `baits_speeds_properties_ibfk_1` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`),
	CONSTRAINT `baits_speeds_properties_ibfk_2` FOREIGN KEY (`speed_id`) REFERENCES `baits_speeds` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

CREATE TABLE `baits_tastes_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`taste_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_baits_tastes_properties_envirmoment_parameters_names` (`parameter_id`),
	INDEX `FK_baits_tastes_properties_bait_taste` (`taste_id`),
	CONSTRAINT `FK_baits_tastes_properties_bait_taste` FOREIGN KEY (`taste_id`) REFERENCES `baits_tastes` (`id`),
	CONSTRAINT `FK_baits_tastes_properties_envirmoment_parameters_names` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=8;

CREATE TABLE `baits_weights_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`weight_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_baits_weights_properties_parameters_names` (`parameter_id`),
	INDEX `FK_baits_weights_properties_baits_deeps` (`weight_id`),
	CONSTRAINT `FK_baits_weights_properties_baits_deeps` FOREIGN KEY (`weight_id`) REFERENCES `baits_weights` (`id`),
	CONSTRAINT `FK_baits_weights_properties_parameters_names` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;


CREATE TABLE `bindings_baits_to_fishes` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NULL DEFAULT NULL,
	`bait_id` INT(11) NULL DEFAULT NULL,
	`activity_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_bindings_baits_to_fishes_fish` (`fish_id`),
	INDEX `FK_bindings_baits_to_fishes_bait` (`bait_id`),
	INDEX `FK_bindings_baits_to_fishes_activity_levels` (`activity_id`),
	CONSTRAINT `FK_bindings_baits_to_fishes_activity_levels` FOREIGN KEY (`activity_id`) REFERENCES `activity_levels` (`id`),
	CONSTRAINT `FK_bindings_baits_to_fishes_bait` FOREIGN KEY (`bait_id`) REFERENCES `baits` (`id`),
	CONSTRAINT `FK_bindings_baits_to_fishes_fish` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `fishes_nibble_properties` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`parameter_id` INT(11) NOT NULL,
	`min_value` DOUBLE NOT NULL,
	`max_value` DOUBLE NOT NULL,
	`nibble_level` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fish_id` (`fish_id`),
	INDEX `FK_fishes_nibble_properties_parameters_names` (`parameter_id`),
	CONSTRAINT `FK_fishes_nibble_properties_parameters_names` FOREIGN KEY (`parameter_id`) REFERENCES `parameters_names` (`id`),
	CONSTRAINT `fishes_nibble_properties_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fishes` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=89;

