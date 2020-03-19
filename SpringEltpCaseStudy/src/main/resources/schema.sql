DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(50) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL
);

create table user(
	id bigint AUTO_INCREMENT primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	username varchar(30) not null,
	password varchar(60) not null
);

create table role(
    id bigint not null primary key,
    role varchar(10) not null
);