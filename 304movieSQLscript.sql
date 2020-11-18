-- if you want ot run the whole script, you need to run the create database line, use dataabse lien seperately
-- then run the rest of the script
create database 304movie;
USE 304movie;


create table customer(
 customer_id integer auto_increment primary key,
 name varchar(20),
 address varchar(100),
 email varchar(50),
 phoneNumber varchar(15)
);
insert into customer(name, address, email, phoneNumber) values
('Brenon', 'Centre Park Street 5003',  'brendon001@gmail.com', '778-123-2211'),
('Mike', 'Boardcast Street 5223',  'Mike22@gmail.com', '778-123-1211'),
('Lily', 'Ching Street 003',  'lily2001@gmail.com', '778-123-7211'),
('Jack', 'Stiany Drive Building 3002',  'jack400021@gmail.com', '778-123-2128'),
('Marry', 'Harvard Drive 6454',  'marry223@gmail.com', '778-123-9911'),
('Frank', 'Harvard Drive 2132',  'Frank@gmail.com', '556-123-9911'),
('Jerry', 'Harvard Drive 2323',  'Jerry@gmail.com', '445-123-9551');


create table theater(
 branch_name varchar(50) primary key,
 open_time varchar(20) not null,
 close_time varchar(20) not null,
 city varchar(20),
 location varchar(100) not null
);
insert into theater(branch_name, open_time, close_time, city, location) values
('theater1', '09:00', '24:00', 'Vancouver', 'Marine Drive Street 3002' ),
('theater2', '10:00', '24:00', 'Vancouver', 'China Town 3002' ),
('theater3', '08:00', '24:00', 'Toronto', 'Centre Street Street 3002' );


create table movie(
  movie_id int auto_increment primary key,
  movie_name varchar(30) not null, 
  language varchar(20) not null,
  format varchar(2),
  movie_genre varchar(20),
  firm_rating varchar(10)
);
insert into movie(movie_name, language, format, movie_genre, firm_rating) values
('2012', 'English', '2D', 'Disaster', 'G'),
('2012', 'English', '3D', 'Disaster', 'G'),
('Alone', 'English', '2D', 'Scary', 'G'),
('Alone', 'French', '2D', 'Disaster', 'G'),
('Titanic', 'English', '2D', 'Romance', 'G'),
('Titanic', 'French', '2D', 'Romance', 'G');


create table moviePrice(
  movie_id int auto_increment primary key,
  movie_price double,
  foreign key(movie_id) references movie(movie_id) on delete cascade on update cascade
);
insert into moviePrice( movie_price) values (35.0), (40.0), (30.0), (30.0), (35.0), (45.0) ;
-- delete from movie where movie_id=4;


create table payment(
  payment_id integer auto_increment primary key,
  payment_amount double not null
);
insert into payment(payment_amount)values 
(35.0),
(40.0),
(30.0),
(30.0),
(30.0),
(30.0),
(35.0),
(40.0),
(30.0),
(30.0),
(30.0),
(30.0);

create table cash(
  payment_id integer primary key,
 --  receive_amount double,
--   change_back double,
  payment_amount double not null,
  foreign key (payment_id) references payment(payment_id) on delete cascade on update cascade
);
insert into cash(payment_id, payment_amount) values
(1, 35.0),
(2, 40.0),
(3, 30.0),
(7, 35.0),
(8, 40.0),
(9, 30.0);

create table card(
  payment_id integer primary key,
  card_number varchar(20) not  null,
  cvv varchar(3) not null,
  foreign key (payment_id) references payment(payment_id) on delete cascade on update cascade
);
insert into card(payment_id, card_number, cvv) values
(4, 4506778933563444, 113),
(5, 4607897011234451, 998),
(6, 4506774899706542, 786),
(10, 4506755933563444, 111),
(11, 4607776011234451, 992),
(12, 4506774665606542, 723);

create table reservation(
  confirmation_number integer auto_increment primary key,
  order_time timestamp not null,
  branch_name varchar(50),
  movie_id  int,
  payment_id int,
  customer_id int,
  foreign key(branch_name) references theater(branch_name) on delete cascade on update cascade,
  foreign key(movie_id) references movie(movie_id) on delete cascade on update cascade,
  foreign key(payment_id) references payment(payment_id) on delete cascade on update cascade,
  foreign key(customer_id) references customer(customer_id) on delete cascade on update cascade
);

insert into reservation(order_time, branch_name, movie_id, payment_id, customer_id)values
('20201008120000', 'theater1', 1, 1, 1),
('20201109120000', 'theater1', 2, 2, 2),
('20201112143000', 'theater2', 3, 3, 3),
('20201114140000', 'theater2', 4, 4, 4),
('20201116200000', 'theater1', 3, 5, 5),
('20201116200000', 'theater1', 4, 6, 5),
('20201208120000', 'theater3', 3, 7, 1),
('20201209120000', 'theater3', 5, 8, 1),
('20201212143000', 'theater3', 1, 9, 6),
('20201214140000', 'theater2', 2, 10, 7),
('20201216200000', 'theater1', 3, 11, 6),
('20201216200000', 'theater1', 4, 12, 7);


create table ticket(
  ticket_number integer auto_increment primary key,
  confirmation_number integer,
  seat_id varchar(5) not null,
  hall_id varchar(5) not null,
  movie_start_time timestamp not null,
  foreign key (confirmation_number) references reservation(confirmation_number) on update cascade on delete cascade
);

insert into ticket(confirmation_number, movie_start_time, seat_id, hall_id) values
(1, '20201008130000', 'D10', '1' ),
(2, '20201110120000', 'E10', '2' ),
(3, '20201113143000', 'A09', '3' ),
(4, '20201115140000', 'D01', '4' ),
(5, '20201117100000', 'B10', '3' ),
(6, '20201117200000', 'F08', '4' ),
(7, '20201008130000', 'D07', '1' ),
(8, '20201110120000', 'F01', '2' ),
(9, '20201113143000', 'A04', '3' ),
(10, '20201115140000', 'D11', '4' ),
(11, '20201117100000', 'B12', '3' ),
(12, '20201117200000', 'F01', '4' );




