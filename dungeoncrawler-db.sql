drop database if exists dungeoncrawler;
create database dungeoncrawler;
use dungeoncrawler;

create table player (
	player_id char(36) primary key,
    username varchar(128) not null,
    password varchar(128) not null,
    level int not null, 
    xp int not null,
    player_hp int not null
);

create table monster (
	monster_id int primary key auto_increment,
    monster_name varchar(128) not null,
    level int not null,
    monster_hp int not null,
    attack int not null, 
    xp_reward int not null
);

create table item (
	item_id int primary key auto_increment,
    item_name varchar(128) not null, 
    item_type varchar(50) not null,
    effect_value int not null
);    

create table inventory (
	inventory_id int primary key auto_increment,
	player_id char(36) not null,
	item_name varchar(128) not null,
	quantity int not null,
		foreign key (player_id)
        references player (player_id),
        foreign key (item_name)
        references item (item_name)
);

create table battle (
	battle_id int primary key auto_increment,
	player_id char(36) not null,
	monster_id int not null,
	result varchar(10) not null,
	timestamp datetime default current_timestamp not null,
		foreign key (player_id)
        references player (player_id),
        foreign key (monster_id)
        references monster (monster_id)
);
