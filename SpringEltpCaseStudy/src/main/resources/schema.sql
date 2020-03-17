DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(50) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL
);

create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar(60) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
create unique index ix_email on employees (email)