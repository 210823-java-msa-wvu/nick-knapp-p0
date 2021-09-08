set search_path to electronicsP0;

create table "electronicsP0".users(
	user_id serial primary key, 
	username varchar not null,--unique constraint added later
	user_password varchar not null,
	user_email varchar not null,
	--payment_info varchar,; not in original table
	user_type varchar not null check (user_type = 'Customer' or user_type = 'Employee' or user_type = 'Manager')
);
alter table "electronicsP0".users add column payment_info varchar;
alter table "electronicsP0".users add constraint unique_username unique (username);

create table "electronicsP0".items(--does every table need a primary key?
	item_id serial primary key,
	item_name varchar not null,
	item_specs varchar,
	item_quantity integer not null check (item_quantity >= 0),
	item_price money not null
);

create table "electronicsP0".order_history(
	transact_id serial primary key,
	--foreign key user_id integer references users.user_id,
	--foreign key item_id integer references items.item_id,
	user_id integer not null,
	item_id integer not null,
	order_quantity integer not null check (order_quantity > 0),
	order_time timestamp,
	order_status varchar not null 
	check (order_status = 'Completed' or order_status = 'Returned' or order_status = 'Pending' or order_status = 'Canceled')
);

alter table "electronicsP0".order_history
add constraint orders_users_fk
foreign key (user_id)
references "electronicsP0".users (user_id);

insert into "electronicsP0".users values(default, 'johnny48','johnny48123','johnny48@email.com','Customer');
insert into "electronicsP0".users values(default, 'samantha85','samantha85123','samantha85@email.com','Customer');
insert into "electronicsP0".users values(default, 'gregoryH','gregoryH123','gregoryH@email.com','Employee');
insert into "electronicsP0".users values(default, 'stevenR','stevenR123','stevenR@email.com','Manager');

update "electronicsP0".users set payment_info = '99999' where username = 'johnny48';
update "electronicsP0".users set payment_info = '88888' where username = 'samantha85';

select * from "electronicsP0".users;

insert into "electronicsP0".items values(default, 'Alpine BBX-T600 Amplifier', 
'600W Max (280W RMS) BBX Series 2-ohm Stable 2 Channel Class-A/B Amplifier; 50 Watts RMS x 2 @ 4 ohms; 70 Watts RMS x 2 @ 2 ohms; 130 Watts RMS x 1 @ 4 ohms; Total Peak Power: 600 Watts; High and Low Pass Filters; 0-12dB Bass Boost; Aluminum Heatsink; Dimensions: 9.84" W x 9.44" L x 2" H', 
5, 108.35);

insert into "electronicsP0".items values(default, 'Boss BE10ACP', 
'10.1" Touchscreen Bluetooth Single-DIN, Apple CarPlay & Android Auto, MECH-LESS Multimedia Player (no CD/DVD); In-Dash MP3/USB Car Stereo Receiver, 10.1" TFT LED Touchscreen Display, 80W x 4 Chan. MAX • 3 Sets of 4V Preamp Outputs ', 
10, 384.99);

insert into "electronicsP0".items values(default, 'NVX NSP69 Speakers', 
'6x9" 2-Way N-Series Coaxial Speakers with 20mm Silk Dome Tweeters; Peak Power: 450W Each, RMS Power: 150W Each, CEA-2031 Compliant Speakers, Mounting Depth: 3-1/8" • 20mm Silk Dome Tweeters, 4 Ohms Impedance, Sensitivity: 89dB', 
4, 86.95);

select * from "electronicsP0".items;

--delete from "electronicsP0".items where item_id = '1';



