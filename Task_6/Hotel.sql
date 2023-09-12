drop table if exists reservations;
drop table if exists user;
drop table if exists rooms;
drop table if exists hotels;

create table if not exists hotels (
	id serial,
	location varchar(35) not null
);
alter table hotels add primary key(id);

create table if not exists user (
	id serial,
	is_admin boolean not null,
	login varchar(35) not null,
	passw varchar(35) not null 
);
alter table user add primary key(id);

create table if not exists rooms (
	id serial,
	hotel_id int
);
alter table rooms add primary key(id);
alter table rooms add foreign key(hotel_id) references hotels(id);

create table if not exists reservations (
	id serial,
	hotel_id int,
	room_id int,
	start_date date not null,
	end_date date not null
);
alter table reservations add primary key(id);
alter table reservations add foreign key(hotel_id) references hotels(id);
alter table reservations add foreign key(room_id) references rooms(id);

