create table login(
	login_id int primary key auto_increment,
	user varchar(100) not null,
	email varchar(255) not null,
	password varchar(255) not null
);

insert into login (user, email, password)
values('“y”óšõ‘¾', 'keita@gmail.com', 'hogehoge');

insert into login (user, email, password)
values('‚Â‚¿‚Æ‚¢‚¯‚¢‚½', 'google@gmail.com', 'piyopiyo');

select * from login where email='hogehoge@gmail.com' and password='hogehoge';
