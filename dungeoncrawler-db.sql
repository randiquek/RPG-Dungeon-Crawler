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
    effect_value int not null,
    description TEXT not null
);    

create table inventory (
	inventory_id int primary key auto_increment,
	player_id char(36) not null,
	item_id int not null,
	quantity int not null,
		foreign key (player_id)
        references player (player_id),
        foreign key (item_id)
        references item (item_id)
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

insert into monster (monster_name, level, monster_hp, attack, xp_reward) values
('Slime', 1, 20, 3, 10),
('Goblin', 2, 35, 5, 20),
('Skeleton', 3, 50, 7, 30),
('Wolf', 4, 60, 8, 40),
('Orc', 5, 80, 10, 50),
('Dark Mage', 6, 70, 12, 60),
('Troll', 7, 120, 15, 80),
('Dragonling', 8, 150, 18, 100);

insert into item (item_name, item_type, effect_value, description) values
('Health Potion', 'potion', 25, 'Restores 25 HP'),
('Damage Potion', 'potion', 10, 'Temporarily increases attack by 10'),
('Iron Sword', 'weapon', 5, 'A basic sword that adds 5 damage'),
('Apprentice Wand', 'weapon', 4, 'A simple wand that adds 4 magic damage'),
('Short Bow', 'weapon', 6, 'A lightweight bow that adds 6 ranged damage');
