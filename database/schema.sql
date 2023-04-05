create database bgg;

use bgg;

create table user(
	user_id varchar(8) not null,
    username varchar(50) not null,
    name varchar(50),
    constraint pk_table_user_id primary key (user_id)
);