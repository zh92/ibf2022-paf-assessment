
insert into user (user_id, username, name) values ('1b80114c', 'fred', 'Fred');
insert into user (user_id, username, name) values ('cf66dae3', 'wilma', 'Wilma');
insert into user (user_id, username, name) values ('a8b9800d', 'barney', 'Barney');
insert into user (user_id, username, name) values ('66223e28', 'betty', 'Betty');

/*Test (to be deleted)*/
insert into task (description, priority, due_date, user_id) values ('Watch movie', '1', '2022-12-12', '1b80114c');

select * from user where username = 'fred';

select u.username, t.description, t.priority, t.due_date 
from user as u
join task as t
on u.user_id = t.user_id where u.username like 'fred'