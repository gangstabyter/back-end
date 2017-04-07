DROP DROP DATABASE IF EXISTS db;
CREATE DATABASE db;

USE db;

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  login varchar(100) NOT NULL,
  firstName varchar(100) NOT NULL,
  lastName varchar(100) NOT NULL,
  pwd varchar(100) NOT NULL,
  isAdmin boolean NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX login (login),
  INDEX loginIdx (login)
)
ENGINE = INNODB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 2048
CHARACTER SET latin1
COLLATE latin1_swedish_ci
ROW_FORMAT = DYNAMIC;

INSERT INTO USER(login, firstName, lastName, pwd, isAdmin) VALUES ('admin@admin.com', 'Ivan', 'Ivanov', 'testadmin', TRUE), ('user@user.com', 'Petrov', 'Petr', 'Petrovich', TRUE);


CREATE TABLE flight (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  flightNumber varchar(100) NOT NULL,
  goesFrom varchar(100) NOT NULL,
  goesTo varchar(100) NOT NULL,
  departureTime date NOT NULL,
  arrivalTime date NOT NULL,
  PRIMARY KEY (id),
  INDEX flightNumberIdx (flightNumber)
)
ENGINE = INNODB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 2048
CHARACTER SET latin1
COLLATE latin1_swedish_ci
ROW_FORMAT = DYNAMIC;

INSERT INTO flight(flightNumber, goesFrom, goesTo, departureTime, arrivalTime) VALUES ('TDF2341', 'Barcelona', 'Berlin', NOW(), NOW()), ('CXSE12434', 'Vilnus', 'Moskow', NOW(), NOW()), ('VDSEW32S', 'London', 'Madrid', NOW(), NOW());


CREATE TABLE userFlight (
  userId bigint(20),
  flightId bigint(20),
  CONSTRAINT userFk FOREIGN KEY (userId)
  REFERENCES user (id),
  CONSTRAINT flightFk FOREIGN KEY (flightId)
  REFERENCES flight (id)
)
ENGINE = INNODB
AVG_ROW_LENGTH = 2048
CHARACTER SET latin1
COLLATE latin1_swedish_ci
ROW_FORMAT = DYNAMIC;

SELECT u.id FROM user u WHERE u.login = 'user@user.com';
SELECT * FROM flight f WHERE f.flightNumber = 'TDF2341';

INSERT INTO userFlight(userId, flightId)  SELECT (SELECT u.id FROM user u WHERE u.login = 'user@user.com'), f.id FROM flight f WHERE f.flightNumber = 'TDF2341';
INSERT INTO userFlight(userId, flightId)  SELECT (SELECT u.id FROM user u WHERE u.login = 'user@user.com'), f.id FROM flight f WHERE f.flightNumber = 'CXSE12434';