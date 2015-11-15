# CREATE DATABASE `eyeFishBase`;

CREATE TABLE fish(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(400),
  type VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE spawning(
  id INT NOT NULL AUTO_INCREMENT,
  fish_id INT NOT NULL,
  spawning TIMESTAMP,
  gluttony TIMESTAMP,
  sick TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (fish_id) REFERENCES fish(id)
);

CREATE TABLE weather_state(
  id INT NOT NULL AUTO_INCREMENT,
  type_data_weather VARCHAR(20) NOT NULL,
  nibble DOUBLE NOT NULL,
  min FLOAT NOT NULL,
  max FLOAT NOT NULL,
  fish_id INT NOT NULL,
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

# CREATE TABLE parameters(
#   id INT NOT NULL AUTO_INCREMENT,
#   id_fish INT NOT NULL,
#   type_data_weather VARCHAR(30) NOT NULL,
#   type_behavior VARCHAR(40) NOT NULL,
#   type_key VARCHAR(30) NOT NULL,
#   range_min INT NOT NULL,
#   range_max INT NOT NULL,
#   PRIMARY KEY (id),
#   FOREIGN KEY (id_fish) REFERENCES fish(id)
# );