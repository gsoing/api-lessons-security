create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into users(username, password, enabled) values('user1', '$2a$10$ggsqB0kGQUxOrHRowveZNuG3WAp2Wt3QNv/hYRFA4BZ1MaQ6xJNau', true);
insert into users(username, password, enabled) values('user2', '$2a$10$iSmLxLKT9Km0nuHsxBjkv.tu.Ktfbj9dzYQQAmxxdcjVuvBllxFHi', true);

insert into authorities(username, authority) values('user1', 'USER');
insert into authorities(username, authority) values('user2', 'ADMIN');
