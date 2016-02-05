# CREATE DATABASE `eyeFish`;

CREATE TABLE `fish` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`description` TEXT NULL,
	`fish_type` VARCHAR(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
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
	`bait_type` VARCHAR(30) NOT NULL DEFAULT '0',
	`name` VARCHAR(50) NOT NULL,
	`description` TEXT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bait_binding` (
	`binding_id` INT(11) NOT NULL AUTO_INCREMENT,
	`fish_id` INT(11) NOT NULL,
	`bait_id` INT(11) NOT NULL,
	PRIMARY KEY (`binding_id`),
	INDEX `fish_id` (`fish_id`),
	INDEX `bait_id` (`bait_id`),
	CONSTRAINT `bait_binding_ibfk_1` FOREIGN KEY (`fish_id`) REFERENCES `fish` (`id`),
	CONSTRAINT `bait_binding_ibfk_2` FOREIGN KEY (`bait_id`) REFERENCES `bait` (`id`)
);

CREATE TABLE `bait_color` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
);

CREATE TABLE `bait_taste` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
);

CREATE TABLE `bait_weight` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
);

CREATE TABLE `season_feed_prefer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NULL DEFAULT NULL,
	`taste` VARCHAR(20) NULL DEFAULT NULL,
	`start_period` DATE NOT NULL,
	`end_period` DATE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_season_feed_prefer_bait` (`bait_id`),
	INDEX `FK_season_feed_prefer_bait_taste` (`taste`),
	CONSTRAINT `FK_season_feed_prefer_bait` FOREIGN KEY (`bait_id`) REFERENCES `bait` (`id`),
	CONSTRAINT `FK_season_feed_prefer_bait_taste` FOREIGN KEY (`taste`) REFERENCES `bait_taste` (`name`)
);

CREATE TABLE `weather_feed_prefer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`bait_id` INT(11) NULL DEFAULT NULL,
	`taste` VARCHAR(20) NULL DEFAULT NULL,
	`min_temp` DOUBLE NOT NULL,
	`max_temp` DOUBLE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `weather_feed_prefer_ibfk_1` (`bait_id`),
	INDEX `FK_weather_feed_prefer_bait_taste` (`taste`),
	CONSTRAINT `FK_weather_feed_prefer_bait_taste` FOREIGN KEY (`taste`) REFERENCES `bait_taste` (`name`),
	CONSTRAINT `weather_feed_prefer_ibfk_1` FOREIGN KEY (`bait_id`) REFERENCES `bait` (`id`)
);

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
);

CREATE TABLE day_phases (id INT NOT NULL AUTO_INCREMENT,
  fish_id INT NOT NULL,
  state_data_type VARCHAR(30),
  phase_value VARCHAR(20),  
  result_nibble_value DOUBLE,
  PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id)
);


SELECT s.bait_id, b.name, s.taste FROM season_feed_prefer AS s INNER JOIN bait AS b ON s.bait_id = b.id
WHERE '2016-06-23' BETWEEN s.start_period AND s.end_period; 

SELECT w.bait_id, b.name, w.taste FROM  weather_feed_prefer AS w INNER JOIN bait AS b ON w.bait_id = b.id
WHERE 23 BETWEEN w.min_temp AND w.max_temp
;

SELECT DISTINCT b.name, b.bait_type, b.description, w.taste AS taste_prefer 
FROM season_feed_prefer AS s 
INNER JOIN  
weather_feed_prefer 
AS w ON s.bait_id = w.bait_id 
INNER JOIN bait
 AS b ON w.bait_id = b.id
INNER JOIN bait_binding AS bin ON b.id = bin.bait_id
WHERE 
23 BETWEEN w.min_temp AND w.max_temp
AND 
'2016-06-23' BETWEEN s.start_period AND s.end_period
AND 7 = bin.fish_id;