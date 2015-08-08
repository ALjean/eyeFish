# CREATE DATABASE `eyeFishBase`;

CREATE TABLE fish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(400),
  PRIMARY KEY (id)
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

CREATE TABLE parameters(
  id INT NOT NULL AUTO_INCREMENT,
  id_fish INT NOT NULL,
  type_data_weather VARCHAR(30) NOT NULL,
  type_behavior VARCHAR(40) NOT NULL,
  type_key VARCHAR(30) NOT NULL,
  range_min INT NOT NULL,
  range_max INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_fish) REFERENCES fish(id)
);