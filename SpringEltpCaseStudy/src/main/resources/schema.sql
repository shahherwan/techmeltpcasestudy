CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(50) DEFAULT NULL,
  first_name VARCHAR(50) DEFAULT NULL,
  last_name VARCHAR(50) DEFAULT NULL
);

CREATE TABLE USERS(
	username VARCHAR(50) NOT NULL PRIMARY,
	password varchar(100) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE AUTHORITIES (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES USERS(username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username,authority);