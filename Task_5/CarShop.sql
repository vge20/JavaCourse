drop table if exists clients;

create table if not exists clients (
	id int,
	full_name varchar(70) not null,
	date_birth date not null,
	gender boolean not null
);
alter table clients add primary key(id);

drop table if exists cars;

create table if not exists cars (
	id int,
	brand varchar(30) not null,
	color varchar(30) not null,
	engine_capacity float not null,
	manufacture_date date not null,
	price bigint not null
);
alter table cars add primary key(id);

drop table if exists customer_orders;

create table if not exists customer_orders (
	client_id int,
	car_id int,
	order_date date not null
);
alter table customer_orders add foreign key(client_id) references clients(id);
alter table customer_orders add foreign key(car_id) references cars(id);

truncate table clients;
truncate table cars;
truncate table customer_orders;
truncate table databasechangelog;
truncate table databasechangeloglock;

copy clients(id, full_name, date_birth, gender) from '/clients.csv' delimiter ':' csv;
copy cars(id, brand, color, engine_capacity, manufacture_date, price) from '/cars.csv' delimiter ':' csv;
copy customer_orders(client_id, car_id, order_date) from '/customer_orders.csv' delimiter ':' csv;

select * from clients;
select * from cars;
select * from customer_orders;