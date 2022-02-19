create database if not exists cats;

use cats;

drop table if exists cats;

create table cats (
cat_id INT not null auto_increment,
cat_name VARCHAR(25),
PRIMARY KEY (cat_id)

);

