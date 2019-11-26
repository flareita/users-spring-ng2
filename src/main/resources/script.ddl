create table users (
id serial primary key,
username varchar(255) not null,
password varchar(80) not null,
email varchar(255) null,
country varchar(255) null,
createTS timestamp DEFAULT now(),
updateTS timestamp DEFAULT now(),
version int not null
);


