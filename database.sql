create database auto;
use auto;

CREATE TABLE users (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username varchar(100) NOT NULL,
	password varchar(255) NOT NULL,
	CONSTRAINT users_unique UNIQUE KEY (username)
);

CREATE TABLE roles (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	role VARCHAR(50) NOT NULL
);

CREATE TABLE user_roles (
	user_id BIGINT NOT NULL,
	role_id BIGINT NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY (user_id,role_id),
	CONSTRAINT user_roles_users_FK FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT user_roles_roles_FK FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO roles(role) VALUES ("ROLE_ADMIN"),("ROLE_USER"); 

create table workplace(
	id bigint primary key auto_increment,
	name varchar(100),
	address varchar(100)
);

create table car_meistras(
	id bigint primary key auto_increment,
	name varchar(100) not null,
	workplace_id bigint not null,
	CONSTRAINT car_work_fk FOREIGN key (workplace_id) REFERENCES workplace(id)
);

create table categories(
	id bigint primary key auto_increment,
	service varchar(100) not null

);

create table cars_services(
	meistras_id bigint not null,
	cat_id bigint not null,
	CONSTRAINT cars_services_pk PRIMARY KEY (meistras_id,cat_id),
	CONSTRAINT cars_services_meis_FK FOREIGN KEY (meistras_id) REFERENCES car_meistras(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT cars_services_cat_fk FOREIGN KEY (cat_id) REFERENCES categories(id)
);

CREATE TABLE `reviews` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) NOT NULL,
  `car_id` bigint DEFAULT NULL,
  `date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK6a9k6xvev80se5rreqvuqr7f9` FOREIGN KEY (`car_id`) REFERENCES `car_meistras` (`id`),
  CONSTRAINT `reviews_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)