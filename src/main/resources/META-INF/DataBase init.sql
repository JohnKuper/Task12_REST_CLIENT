drop database if exists auto_show;
create database if not exists auto_show;

use auto_show;

create table if not exists cars (
	id_car int(4) auto_increment primary key,
	name varchar(100) not null,
	model varchar(100) not null,
	modification int(5) not null,
	color varchar(30) not null,
	unique key mark_unique_key (name,model,modification)
);

create table if not exists merchants(
	id_merchant int(3) auto_increment primary key,
	name varchar(100),
	surname varchar(100),
	patronymic varchar(100)
);

create table if not exists customers(
	id_customer int(7) auto_increment primary key,
	name varchar(100),
	surname varchar(100),
	patronymic varchar(100),
	passport_series char(4),
	passport_number char(6),
	birthdate date,
	unique unique_passport(passport_series,passport_number),
	key customer_surname_key (surname)
);

create table if not exists sales(
	id_sale int(11) auto_increment primary key,
	id_car int(11),
	id_customer int(7),
	id_merchant int(3),
	price decimal(11,2) ,
	sale_date timestamp not null default current_timestamp(),
	foreign key fk_car(id_car) references cars(id_car)
	on delete set NULL
	on update cascade,
	foreign key fk_customer(id_customer) references customers(id_customer)
	on delete set NULL
	on update cascade,
	foreign key fk_merchant(id_merchant) references merchants(id_merchant)
	on delete set NULL
	on update cascade
);

create table if not exists store(
	id_store int(11) auto_increment primary key,
	id_car int(11) not null,
	count int(3) unsigned,
	price decimal(11,2),
	testdrive_avaible bit default 0,
	unique unique_id_car(id_car,price,testdrive_avaible),
	foreign key fk_car(id_car) references cars(id_car)
	on update cascade
	on delete cascade
);

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION;

insert into cars(name,model,modification,color)
values('Audi','R5','400','Красный'),
	  ('Audi','R6','666','Мокрый асфальт'),
	  ('Audi','R8','888','Оранжевый'),	
	  ('BMW','X3','250','Белый'),
	  ('Toyota','Corolla','300','Черный'),
	  ('Lada','Granta','150','Синий'),
      ('Lamborghini','Diablo SV','900','Металлик');

insert into customers(name,surname,patronymic,passport_series,passport_number,birthdate)
values('Игорь','Ежов','Владимирович','5705','032667', cast('1970-04-16' as datetime)),
	  ('Олег','Шашков','Михайлович','5522','035878', cast('1975-07-25' as datetime)),
	  ('Никифор','Швечиков','Евлампиевич','5533','034378', cast('1985-04-22' as datetime)),
	  ('Юлия','Сильвестрова','Михеевна','4422','235998', cast('1986-01-01' as datetime)),
	  ('Яна','Осинова','Якововна','5589','712260', cast('1972-02-27' as datetime));

insert into merchants(name,surname,patronymic)
values('Михаил','Захаров','Олегович'),
	  ('Алексей','Иванов','Петрович'),
	  ('Семен','Воронцов','Дмитриевич');

DELIMITER $$
 DROP PROCEDURE IF EXISTS fillDataBaseSales$$
 CREATE PROCEDURE fillDataBaseSales()
	BEGIN
		DECLARE step INT;
		DECLARE carRnd INT;
		DECLARE customerRnd INT;
		DECLARE merchantRnd INT;
		DECLARE priceRnd DECIMAL(11,2);

		set step = 1;

		WHILE step  <= 5 DO

			set carRnd = step;
			set customerRnd = ROUND(RAND()*4)+1 ;
			set merchantRnd = ROUND(RAND()*2)+1;
			set priceRnd = ROUND(RAND()*1000000.50);


			insert into sales(id_car,id_customer,id_merchant,price)
			values(carRnd,customerRnd,merchantRnd,priceRnd);



			set step = step + 1;
		END WHILE;
	END$$
DELIMITER ;   

DELIMITER $$
 DROP PROCEDURE IF EXISTS fillDataBaseStore$$
 CREATE PROCEDURE fillDataBaseStore()
	BEGIN
		DECLARE step INT;
		DECLARE carRnd INT;
		DECLARE countRnd INT;
		DECLARE priceRnd DECIMAL(11,2);
		DECLARE testDriveRnd Bit;

		set step = 1;

		WHILE step  <= 5 DO

			set carRnd = step;
			set countRnd = ROUND(RAND()*9)+1 ;
			set priceRnd = ROUND(RAND()*1000000.50);
			set testDriveRnd = ROUND(RAND()*1);


			insert into store(id_car,count,price,testdrive_avaible)
			values(carRnd,countRnd,priceRnd,testDriveRnd);



			set step = step + 1;
		END WHILE;
	END$$
DELIMITER ;  

call fillDataBaseSales(); 
call fillDataBaseStore(); 
