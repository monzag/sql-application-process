CREATE TABLE `mentors` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	`first_name`	TEXT,
	`last_name`	TEXT,
	`nick_name`	TEXT,
	`phone_number`	TEXT,
	`email`	TEXT,
	`city`	TEXT,
	`favourite_number`	INTEGER
);


CREATE TABLE `applicants` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	`first_name`	TEXT,
	`last_name`	TEXT,
	`phone_number`	TEXT,
	`email`	TEXT,
	`application_code`	INTEGER
);
