CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(30) NOT NULL,
  password VARCHAR(100),
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  role VARCHAR(20),
  PRIMARY KEY (id)
);

INSERT INTO users (email, password, first_name, last_name, role) VALUES ('mail@mail.com', '$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW', 'Bill', 'Montgomery', 'ADMIN');
INSERT INTO users (email, password, first_name, last_name, role) VALUES ('mail1@mail.com', '$2a$08$.Vib2ZN7L3C3kx.BRAf5xOW8wKNN/v8FFpKSMcV21lfkoSy.ILpRW', 'Taller', 'Derdon', 'USER');

DROP TABLE users;