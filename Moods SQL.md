# Moods SQL

create database moods;

use moods;



create table looksays (username varchar(7),say_id bigint);

create table says (say_id bigint primary key auto_increment,saywords varchar(500),picture varchar(70),var varchar(100),times date,username varchar(7) );

create table userm(username varchar(7) primary key,password varchar(100),sex tinyint,phone varchar(11),age date,avatar varchar(100));

create table words (word_id tinyint,word varchar(30));



CREATE TABLE collections (say_id BIGINT,username VARCHAR(7),PRIMARY KEY(say_id,username));

CREATE TABLE comments (say_id BIGINT,comment_id BIGINT PRIMARY KEY AUTO_INCREMENT, contexts VARCHAR(100),goodnum TINYINT,username VARCHAR(7)) ;

CREATE TABLE  barrage (bar_id BIGINT  PRIMARY KEY AUTO_INCREMENT,username VARCHAR(7),extime DATE,runtime VARCHAR(10),goodnum TINYINT ,contexts VARCHAR(30),fontsize TINYINT,speed TINYINT,color VARCHAR(10));