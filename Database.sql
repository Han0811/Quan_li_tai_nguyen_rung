create database Quan_li_rung;
use Quan_li_rung;

create table administrative_level(
	id int primary key not null,
    `name` nvarchar(50) not null,
    level int not null
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;


create table administrations(
	id int primary key not null,
	`name` nvarchar(100) not null,
    subordinate int null,
    level_id int not null,
    foreign key(level_id)
        references administrative_level(id),
	foreign key (subordinate)
		references administrations(id)
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

	
create table users(
	id int primary key not null,
    first_name nvarchar(50) not null,
    last_name nvarchar(50) not null,
    role_user nvarchar(50) not null,
    birth_date date not null,
    address nvarchar(200) not null,
    email nvarchar(50) not null,
    phone nvarchar(16) not null,
    `password` nvarchar(50) not null,
    is_active bit not null,
    administrations_id int not null,
    foreign key(administrations_id)
		references administrations(id)
) engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN ;

create table animal_storage_facilities(
    id int primary key not null,
    `name` nvarchar(100) not null,
    `date` date null,
    capacity long not null,
    administrations_id int not null,
    detail nvarchar(500) null,
    lat nvarchar(100) null,
    lng nvarchar(100) null,
    foreign key(administrations_id)
		references administrations(id)
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table fluctuation(
    id int primary key not null,
    `name` nvarchar(100) not null,
	detail nvarchar(500) null
);

create table animal_species(
    `name` nvarchar(100) primary key not null,
    animal_type nvarchar(50) not null,
	image nvarchar(500) not null,
    main_food nvarchar(100) not null,
    main_disease nvarchar(100) not null,
	longevity int not null,
	fluctuation_id int not null,
	foreign key(fluctuation_id)
		references fluctuation(id)
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table asf_as_relationship(
    id int primary key not null,
    animal_storage_facilities_id int not null,
    animal_species_name nvarchar(100) not null,
    quantity long not null,
    `date` date null,
    foreign key (animal_storage_facilities_id)
        references animal_storage_facilities(`id`)
        on delete cascade on update cascade,
	foreign key(animal_species_name)
        references animal_species(name)
        on delete cascade on update cascade
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table operation_form(
    `name` nvarchar(50) primary key not null,
    decription nvarchar(500) not null
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table production_type(
    wood_type nvarchar(50) primary key not null,
	image nvarchar(100) not null,
    capacity long null
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table wood_facilities(
	id int primary key not null,
    `name` nvarchar(50) not null,
    `date` date null,
	capacity long not null,
    adminstration_id int not null,
    operation_form_name nvarchar(100) not null,
    lat nvarchar(100) null,
    lng nvarchar(100) null,
    foreign key (adminstration_id)
        references administrations(id),
	foreign key (operation_form_name)
        references operation_form(`name`)
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table wf_pt_relationship(
    id int primary key not null,
    wood_facilities_id int not null,
    production_type_name nvarchar(100) not null,
    quantity long not null,
    `date` date null,
    foreign key (wood_facilities_id)
        references wood_facilities(id)
        on delete cascade on update cascade,
		foreign key(production_type_name)
        references production_type(wood_type)
        on delete cascade on update cascade
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table plant_seed(
    `name` nvarchar(50) primary key not null,
    `type` nvarchar(50) not null,
	image nvarchar(500) not null,
    soil_type nvarchar(100) null,
    main_pest nvarchar(50) null,
    harvesting_period int null,
    plant_season nvarchar(100) null
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;


create table plant_facilities(
	id int primary key not null,
    `name` nvarchar(100) not null,
    `date` date null,
	capacity long not null,
    adminstration_id int not null,
    lat nvarchar(100) null,
    lng nvarchar(100) null,

    foreign key (adminstration_id)
        references administrations(id)
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table pf_ps_relationship(
    id int primary key not  null,
    plant_facilities_id int not null,
    plant_seed_name nvarchar(100) not null,
    quantity long null,
    `date` date null,
    foreign key (plant_facilities_id)
        references plant_facilities(id)
        on delete cascade on update cascade,
	foreign key (plant_seed_name)
        references plant_seed(name)
        ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

create table access_history(
	id int primary key not null,
    username nvarchar(100) not null,
    method nvarchar(500) null,
    `time` datetime
)engine=InnoDB character set=UTF8MB4 collate = UTF8MB4_BIN;

