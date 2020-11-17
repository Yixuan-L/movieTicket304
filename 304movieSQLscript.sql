
create database 304movie;
USE 304movie;

create table customer(
 customer_id integer auto_increment primary key,
 name varchar(20),
 address varchar(100),
 email varchar(50) unique,
 phoneNumber varchar(15) unique
);
insert into customer(name, address, email, phoneNumber) values
('Brenon', 'Centre Park Street 5003',  'brendon001@gmail.com', '778-123-2211');
insert into customer(name, address, email, phoneNumber) values
('Mike', 'Boardcast Street 5223',  'Mike22@gmail.com', '778-123-1211');
insert into customer(name, address, email, phoneNumber) values
('Lily', 'Ching Street 003',  'lily2001@gmail.com', '778-123-7211');
insert into customer(name, address, email, phoneNumber) values
('Jack', 'Stiany Drive Building 3002',  'jack400021@gmail.com', '778-123-2128');
insert into customer(name, address, email, phoneNumber) values
('Marry', 'Harvard Drive 6454',  'marry223@gmail.com', '778-123-9911');


create table theatre(
 branch_name varchar(50) primary key,
 open_time varchar(20) not null,
 close_time varchar(20) not null,
 city varchar(20),
 location varchar(100) not null
);
insert into theatre(branch_name, open_time, close_time, city, location) values
('theatre1', '09:00', '24:00', 'Vancouver', 'Marine Drive Street 3002' );
insert into theatre(branch_name, open_time, close_time, city, location) values
('theatre2', '10:00', '24:00', 'Vancouver', 'China Town 3002' );
insert into theatre(branch_name, open_time, close_time, city, location) values
('theatre3', '08:00', '24:00', 'Toronto', 'Centre Street Street 3002' );


create table movie(
  movie_id int auto_increment primary key,
  movie_name varchar(30) not null, 
  language varchar(20) not null,
  format varchar(2),
  movie_genre varchar(20),
  firm_rating varchar(10),
  active_date integer not null
);
insert into movie(movie_name, language, format, movie_genre, firm_rating, active_date) values
('2012', 'English', '2D', 'Disaster', 'G', 60);
insert into movie(movie_name, language, format, movie_genre, firm_rating, active_date) values
('2012', 'English', '3D', 'Disaster', 'G', 60);
insert into movie(movie_name, language, format, movie_genre, firm_rating, active_date) values
('Alone', 'English', '2D', 'Scary', 'G', 30);
insert into movie(movie_name, language, format, movie_genre, firm_rating, active_date) values
('Alone', 'French', '2D', 'Disaster', 'G', 60);
insert into movie(movie_name, language, format, movie_genre, firm_rating, active_date) values
('Titanic', 'English', '2D', 'Romance', 'G', 60);


create table moviePrice(
  movie_id int primary key,
  movie_price double,
  foreign key(movie_id) references movie(movie_id) on delete cascade on update cascade
);
insert into moviePrice(movie_id, movie_price) values (1, 35.0), (2, 40.0), (3, 30.0), (4, 30.0), (5, 35.0);
-- delete from movie where movie_id=4;


create table payment(
  payment_id integer auto_increment primary key,
  payment_amount double not null
);
insert into payment(payment_amount)values (35.0);
insert into payment(payment_amount)values (40.0);
insert into payment(payment_amount)values(30.0);
insert into payment(payment_amount)values(30.0);
insert into payment(payment_amount)values(30.0);
insert into payment(payment_amount)values(30.0);

insert into payment(payment_amount)values (35.0);
insert into payment(payment_amount)values (40.0);
insert into payment(payment_amount)values(35.0);

create table cash(
  payment_id integer primary key,
  receive_amount double,
  change_back double,
  foreign key (payment_id) references payment(payment_id) on delete cascade on update cascade
);
insert into cash(payment_id, receive_amount, change_back) values
(1, 50.0, 15.0);
insert into cash(payment_id, receive_amount, change_back) values
(2, 100.0, 60.0);
insert into cash(payment_id, receive_amount, change_back) values
(3, 30.0, 0.0);

create table card(
  payment_id integer primary key,
  card_number varchar(20) not  null,
  cvv varchar(3) not null,
  foreign key (payment_id) references payment(payment_id) on delete cascade on update cascade
);
insert into card(payment_id, card_number, cvv) values
(4, 4506778933563444, 113);
insert into card(payment_id, card_number, cvv) values
(5, 4607897011234451, 998);
insert into card(payment_id, card_number, cvv) values
(6, 4506774899706542, 786);

insert into card(payment_id, card_number, cvv) values
(7, 4506774899706542, 786);
insert into card(payment_id, card_number, cvv) values
(8, 4506774899706542, 786);
insert into card(payment_id, card_number, cvv) values
(9, 4506774899706542, 786);

create table reservation(
  confirmation_number integer auto_increment primary key,
  order_time timestamp not null,
  branch_name varchar(50),
  movie_id  int,
  payment_id int,
  customer_id int,
  foreign key(branch_name) references theatre(branch_name) on delete cascade on update cascade,
  foreign key(movie_id) references movie(movie_id) on delete cascade on update cascade,
  foreign key(payment_id) references payment(payment_id) on delete cascade on update cascade,
  foreign key(customer_id) references customer(customer_id) on delete cascade on update cascade
);

insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201008120000', 'theatre1', 1, 1, 1);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201109120000', 'theatre1', 2, 2, 2);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201112143000', 'theatre2', 3, 3, 3);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201114140000', 'theatre2', 4, 4, 4);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201116200000', 'theatre1', 3, 5, 5);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201116200000', 'theatre1', 4, 6, 5);

insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201116200000', 'theatre1', 1, 7, 5);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201116200000', 'theatre1', 2, 8, 5);
insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201116200000', 'theatre1', 5, 9, 5);




create table ticket(
  ticket_number integer auto_increment primary key,
  confirmation_number integer,
  movie_start_time timestamp not null,
  seat_id varchar(5) not null,
  hall_id varchar(5) not null,
  foreign key (confirmation_number) references reservation(confirmation_number) on update cascade on delete cascade
);

insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(1, '20201008130000', 'D10', '1' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(2, '20201110120000', 'E10', '2' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(3, '20201113143000', 'A09', '3' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(4, '20201115140000', 'D01', '4' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(5, '20201117100000', 'B10', '3' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(6, '20201117200000', 'F08', '4' );

insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(7, '20201117100000', 'F08', '4' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(8, '20201118200000', 'F08', '4' );
insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(9, '20201119200000', 'F08', '4' );




