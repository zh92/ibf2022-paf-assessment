create database bgg;

use bgg;

create table user(
	user_id varchar(8) not null,
    username varchar(50) not null,
    name varchar(50),
    constraint pk_table_user_id primary key (user_id)
);

create table task(
	task_id int not null auto_increment,
    description varchar(255) not null,
    priority enum('1', '2', '3') default '1',
    due_date date not null,
    user_id varchar(8) not null,
    constraint pk_task_task_id primary key (task_id),
    constraint fk_task_user_id foreign key (user_id) references user(user_id)
    on delete cascade
    on update restrict
);
