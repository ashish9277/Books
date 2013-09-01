drop database project;
create database project;

use project;

create table users(u_id int primary key AUTO_INCREMENT,u_name varchar(50),u_password varchar(50),email_id varchar(50),
                   sem varchar(20),university varchar(20));
	

create table books(b_id int primary key AUTO_INCREMENT,b_name varchar(100),b_author varchar(50),b_edition varchar(50),
 b_description varchar(500), b_owner int, foreign key(b_owner) REFERENCES users(u_id),previewLoc varchar(500) );
 
 insert into users(u_name,u_password,email_id) values('a','a','bbhaskeryadav05@gmail.com');