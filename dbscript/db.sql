create database dbds120251;
use dbds120251;

create table tperson(
idPerson char(36) not null,
firstName varchar(70) not null,
surName varchar(40) not null,
dni char(8) not null,
gender boolean not null,
birthDate date not null,
createdAt datetime not null,
updatedAt datetime not null,
primary key(idPerson)
) engine = innodb;

create table tprovider(
idProvider char(36) not null,
name varchar(70) not null,
createdAt datetime not null,
updatedAt datetime not null,
primary key(idProvider)
) engine = innodb;

create table tphone(
idPhone char(36) not null,
idPerson char(36) not null,
idProvider char(36) not null,
number varchar(20) not null,
createdAt datetime not null,
updatedAt datetime not null,
foreign key(idPerson) references tperson(idPerson)
on delete cascade on update cascade,
foreign key(idProvider) references tprovider(idPerson)
on delete cascade on update cascade,
primary key(idPhone)
) engine = innodb;