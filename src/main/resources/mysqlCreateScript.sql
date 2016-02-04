# CREATE DATABASE `eyeFish`;

CREATE TABLE fish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(500),
  type VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE year_periods (
  id INT NOT NULL AUTO_INCREMENT,
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

CREATE TABLE bait (
	id INT(11) NOT NULL AUTO_INCREMENT,
	fish_id INT(11) NOT NULL,
	bait_type VARCHAR(30),
	name VARCHAR(50) NOT NULL,
	description VARCHAR(400) NULL,
	PRIMARY KEY (`id`),
  FOREIGN KEY (fish_id) REFERENCES fish(id)

);

CREATE TABLE bait_color (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bait_taste (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bait_weight (
	id INT(11) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE season_feed_prefer (
	id INT(11) NOT NULL AUTO_INCREMENT,
	fish_id INT(11) NOT NULL,
  bait_id INT(11),
	taste VARCHAR(20),
	start_period TIMESTAMP NOT NULL,
	end_period TIMESTAMP NOT NULL,
	PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id),
  FOREIGN KEY (taste) REFERENCES bait_taste(name),
  FOREIGN KEY (bait_id) REFERENCES bait(name)
);

CREATE TABLE weather_feed_prefer (
	id INT(11) NOT NULL AUTO_INCREMENT,
	fish_id INT(11) NOT NULL DEFAULT '0',
	bait_id INT(11),
	taste VARCHAR(20),
	min_temp DOUBLE NOT NULL,
	max_temp DOUBLE NOT NULL,
	PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id),
  FOREIGN KEY (taste) REFERENCES bait_taste(name),
  FOREIGN KEY (bait_id) REFERENCES bait(id)
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
  role VARCHAR(30),
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

# SELECT s.bait_id, b.name, s.taste FROM season_feed_prefer AS s, bait AS b
# WHERE '2016-05-23' BETWEEN s.start_period AND s.end_period
# AND s.bait_id = b.id;
#
# SELECT w.bait_id, b.name, w.taste FROM  weather_feed_prefer AS w, bait AS b
# WHERE 23 BETWEEN w.min_temp AND w.max_temp
# AND w.bait_id = b.id;
#
# SELECT DISTINCT b.name, b.bait_type, b.name, w.taste FROM season_feed_prefer AS s, bait AS b, weather_feed_prefer AS w
# WHERE 32 BETWEEN w.min_temp AND w.max_temp
# AND '2016-09-23' BETWEEN s.start_period AND s.end_period
# AND s.bait_id = b.id
# AND w.bait_id = b.id
# AND s.bait_id = w.bait_id;