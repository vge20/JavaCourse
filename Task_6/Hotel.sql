drop table if exists reservation;
drop table if exists public.user;
drop table if exists room;
drop table if exists hotel;

create table if not exists hotel (
	id serial,
	location varchar(35) not null
);
alter table hotel add primary key(id);

create table if not exists public.user (
	id serial,
	is_admin boolean not null,
	login varchar(35) not null,
	passw varchar(35) not null 
);
alter table public.user add primary key(id);

create table if not exists room (
	id serial,
	hotel_id int
);
alter table room add primary key(id);
alter table room add foreign key(hotel_id) references hotel(id);

create table if not exists reservation (
	id serial,
	hotel_id int,
	room_id int,
	user_id int,
	start_date date not null,
	end_date date not null
);
alter table reservation add primary key(id);
alter table reservation add foreign key(room_id) references room(id);
alter table reservation add foreign key(user_id) references public.user(id);
alter table reservation add constraint date_order check (start_date <= end_date);

select * from reservation;
select * from public.user;
select * from room;
select * from hotel;

-- id отелей и кол-во свободных номеров в наличии на определённый промежуток дат и в нужной локации
select h.id as hotel_id, count(r.id) as count_rooms
from hotel as h join room as r on h.id = r.hotel_id
where h."location" = 'Moscow' and r.id in 
(select room_id
from reservations
where end_date < '2023-10-01' or start_date > '2023-10-05'
group by hotel_id;)
group by h.id;

-- id комнат, забронированных на заданный промежуток времени
select room_id
from reservations
where not (end_date < '2023-10-01' or start_date > '2023-10-05')
group by hotel_id;


create table users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
