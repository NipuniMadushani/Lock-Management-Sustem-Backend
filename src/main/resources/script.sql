insert into roles (id,name) values (1,'ADMIN');
insert into user_roles (user_id,role_id) values (1,1);
insert into users (id,email,password,username) values (1,'mali@gmail.com','12345','user');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
