# CREATE DATABASE `eyeFish`;

CREATE TABLE fish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  description TEXT,
  type VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE year_periods (id INT NOT NULL AUTO_INCREMENT,
  fish_id INT NOT NULL,
  start_period TIMESTAMP,   
  end_period TIMESTAMP,
  result_nibble_value DOUBLE,
  PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id)
);

CREATE TABLE fish_parameters(
  id INT NOT NULL AUTO_INCREMENT,
  fish_id INT NOT NULL,
  state_data_type VARCHAR(30) NOT NULL,
  min_range_value DOUBLE NOT NULL,
  max_range_value DOUBLE NOT NULL,
  result_nibble_value DOUBLE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id)
);

CREATE TABLE `bait` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL DEFAULT '0',
	`bait_type` VARCHAR(30) NOT NULL DEFAULT '0',
	`name` VARCHAR(50) NOT NULL,
	`description` TEXT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_bait_fish` (`fish_id`),
	CONSTRAINT `FK_bait_fish` FOREIGN KEY (`fish_id`) REFERENCES `fish` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6;

CREATE TABLE `bait_color` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `bait_taste` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `bait_weight` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;

CREATE TABLE `season_feed_prefer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NOT NULL,
	`color_id` INT(11) NULL DEFAULT NULL,
	`taste_id` INT(11) NULL DEFAULT NULL,
	`weight_id` INT(11) NULL DEFAULT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_season_feed_prefer_bait` (`bait_id`),
	INDEX `FK_season_feed_prefer_bait_color` (`color_id`),
	INDEX `FK_season_feed_prefer_bait_taste` (`taste_id`),
	INDEX `FK_season_feed_prefer_bait_weight` (`weight_id`),
	CONSTRAINT `FK_season_feed_prefer_bait` FOREIGN KEY (`bait_id`) REFERENCES `bait` (`id`),
	CONSTRAINT `FK_season_feed_prefer_bait_color` FOREIGN KEY (`color_id`) REFERENCES `bait_color` (`id`),
	CONSTRAINT `FK_season_feed_prefer_bait_taste` FOREIGN KEY (`taste_id`) REFERENCES `bait_taste` (`id`),
	CONSTRAINT `FK_season_feed_prefer_bait_weight` FOREIGN KEY (`weight_id`) REFERENCES `bait_weight` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6;

CREATE TABLE `weather_feed_prefer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NOT NULL,
	`color_id` INT(11) NULL DEFAULT NULL,
	`taste_id` INT(11) NULL DEFAULT NULL,
	`weight_id` INT(11) NULL DEFAULT NULL,
	`state_data_type` VARCHAR(40) NOT NULL,
	`min_range_value` DOUBLE NOT NULL,
	`max_range_value` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `weather_feed_prefer_ibfk_1` (`bait_id`),
	INDEX `FK_weather_feed_prefer_bait_color` (`color_id`),
	INDEX `FK_weather_feed_prefer_bait_taste` (`taste_id`),
	INDEX `FK_weather_feed_prefer_bait_weight` (`weight_id`),
	CONSTRAINT `FK_weather_feed_prefer_bait_color` FOREIGN KEY (`color_id`) REFERENCES `bait_color` (`id`),
	CONSTRAINT `FK_weather_feed_prefer_bait_taste` FOREIGN KEY (`taste_id`) REFERENCES `bait_taste` (`id`),
	CONSTRAINT `FK_weather_feed_prefer_bait_weight` FOREIGN KEY (`weight_id`) REFERENCES `bait_weight` (`id`),
	CONSTRAINT `weather_feed_prefer_ibfk_1` FOREIGN KEY (`bait_id`) REFERENCES `bait` (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7;


CREATE TABLE messages(
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(30) NOT NULL,
  state VARCHAR(30) NOT NULL,
  text VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE weather(
  id INT NOT NULL AUTO_INCREMENT,
  city VARCHAR(30) NOT NULL,
  date TIMESTAMP,
  temp_day FLOAT NOT NULL,
  temp_night FLOAT NOT NULL,
  temp_even FLOAT NOT NULL,
  temp_morn FLOAT NOT NULL,
  pressure FLOAT NOT NULL,
  wind_speed FLOAT NOT NULL,
  wind_deg INT NOT NULL,
  humidity INT NOT NULL,
  clouds INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(30) NOT NULL,
  password VARCHAR(50),
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  PRIMARY KEY (id)
)

CREATE TABLE day_phases (id INT NOT NULL AUTO_INCREMENT,
  fish_id INT NOT NULL,
  state_data_type VARCHAR(30),
  phase_value VARCHAR(20),  
  result_nibble_value DOUBLE,
  PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id)
);