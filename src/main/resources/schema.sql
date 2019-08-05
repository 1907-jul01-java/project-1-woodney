 drop table if exists players,gm,request;
 
 create table players 
(
    id serial primary key,
    firstName text not null,
    lastName text not null,
    username text not null,
    user_password text not null,
    age numeric
);

create table gm(
    id serial primary key,
    username text not null,
    gm_password text not null
);

create table request(
    id serial primary key,
    firstName text not null,
    lastName text not null,
    deal text not null,
    highlight text,
    status text not null
);

insert into gm(username,gm_password) values ('TamperingGod', 'KingJames');
insert into players(firstName,lastName,username,user_password,age) values ('Anthony', 'Davis', 'AD3', 'ScrewPelicans',26);
insert into players(firstName,lastName,username,user_password,age) values ('Kawhi', 'Leonard', 'BoredMan', 'Uhhaha', 28);
insert into players(firstName,lastName,username,user_password,age) values ('Kevin', 'Durant', 'KDtrey7', 'Burnerboy', 30);
insert into players(firstName,lastName,username,user_password,age) values ('Kyrie', 'Irving', 'UncleDrew', 'FlatEarthers', 27);
insert into players(firstName,lastName,username,user_password,age) values ('Kemba', 'Walker', 'KWalk8', 'Successful', 29);
insert into players(firstName,lastName,username,user_password,age) values ('Klay', 'Thompson', 'Game6Klay', 'Patrick', 29);
insert into players(firstName,lastName,username,user_password,age) values ('Demarcus', 'Cousins', 'Dcuzz', 'Ridiculous', 28);
insert into players(firstName,lastName,username,user_password,age) values ('Jimmy', 'Butler', 'JimmyBuckets', 'Houston', 29);
insert into players(firstName,lastName,username,user_password,age) values ('D-Angelo', 'Russell', 'DLO31', 'Snitch', 23);
insert into players(firstName,lastName,username,user_password,age) values ('Julius', 'Randle', 'Juju30', 'Ithadtobeyou', 24);
insert into players(firstName,lastName,username,user_password,age) values ('Cream', 'Biggums', 'Spice', 'Adams', 34);










