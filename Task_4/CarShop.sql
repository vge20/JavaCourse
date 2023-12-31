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

copy clients(id, full_name, date_birth, gender) from '/clients.csv' delimiter ':' csv;
copy cars(id, brand, color, engine_capacity, manufacture_date, price) from '/cars.csv' delimiter ':' csv;
copy customer_orders(client_id, car_id, order_date) from '/customer_orders.csv' delimiter ':' csv;

select * from clients;
select * from cars;
select * from customer_orders;

-- какой клиент сколько машин заказал
select t.full_name, count(t.car_id)
from (clients as cli join customer_orders as c_o on cli.id = c_o.client_id) as t
group by t.id, t.full_name;

-- как много заказали красных машин
select count(car_id)
from (cars join customer_orders as c_o on cars.id = c_o.car_id) as t
where t.color = 'Krasnyye';

-- ФИО клиента, который заказал больше всего машин (суммарно всех марок и цветов)
select t.full_name 
from (clients as cli join customer_orders as c_o on cli.id = c_o.client_id) as t
group by t.id, t.full_name
order by count(t.car_id) desc
limit 1;

select t.full_name		
from (clients as cli join customer_orders as c_o on cli.id = c_o.client_id) as t
group by t.id, t.full_name
having count(t.car_id) - (select count(t.car_id) as cnt 
						from (clients as cli join customer_orders as c_o on cli.id = c_o.client_id) as t
						group by t.id, t.full_name
						order by count(t.car_id) desc
						limit 1) = 0;

-- в каком месяце больше всего заказывают машин
select extract(month from t.order_date) as month
from customer_orders as t
group by month
order by count(extract(month from t.order_date)) desc
limit 1;

select extract(month from t.order_date) as month
from customer_orders as t
group by month
having count(extract(month from t.order_date)) - (select count(extract(month from t.order_date)) as cnt
												from customer_orders as t
												group by extract(month from t.order_date)
												order by count(extract(month from t.order_date)) desc
												limit 1) = 0;