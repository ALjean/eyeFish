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