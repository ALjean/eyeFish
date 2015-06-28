CREATE DATABASE `dmf-manager`;

CREATE TABLE fish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(400),
  temp_min FLOAT NOT NULL,
  temp_max FLOAT NOT NULL,
  pressure_min INT NOT NULL,
  pressure_max INT NOT NULL,
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
  temp FLOAT NOT NULL,
  temp_min FLOAT NOT NULL,
  temp_max FLOAT NOT NULL,
  pressure INT NOT NULL,
  wind_speed FLOAT NOT NULL,
  wind_deg INT NOT NULL,
  clouds INT NOT NULL,
  PRIMARY KEY (id)
);