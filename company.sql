create schema company;

use company;

drop table if exists departments;

create table departments (
	id int primary key auto_increment,
    name varchar(128)
);

drop table if exists employees;

create table employees (
	id int primary key auto_increment,
    deptId int not null,
    name varchar(128),
    patronymic varchar(128),
    surname varchar(128),
    birth date,
    salary int,
    foreign key (deptId) references departments(id)
);


CREATE VIEW avgSalary AS SELECT departments.name, AVG(salary) AS salary FROM departments, employees WHERE departments.id = employees.deptId  GROUP BY deptId;

INSERT INTO `departments` (`id`,`name`) VALUES (1,'IT');
INSERT INTO `departments` (`id`,`name`) VALUES (2,'Engineering');
INSERT INTO `departments` (`id`,`name`) VALUES (3,'Legal');
INSERT INTO `departments` (`id`,`name`) VALUES (4,'Supply');
INSERT INTO `departments` (`id`,`name`) VALUES (5,'Logistics');
INSERT INTO `departments` (`id`,`name`) VALUES (6,'Development');
INSERT INTO `departments` (`id`,`name`) VALUES (7,'Administration');
INSERT INTO `departments` (`id`,`name`) VALUES (8,'Marketing');
INSERT INTO `departments` (`id`,`name`) VALUES (9,'Sales');
INSERT INTO `departments` (`id`,`name`) VALUES (10,'Canteen');
INSERT INTO `departments` (`id`,`name`) VALUES (14,'New-new name0.910460198060604');
INSERT INTO `departments` (`id`,`name`) VALUES (24,'Testers');



INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (8,3,'Dmitriy','Evgenievich','Mischenko','1993-09-15',1000);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (9,4,'Anna','Vitalievna','Pashkevich','1991-07-15',600);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (11,5,'Oksana','Valentinovna','Sidoryk','1990-01-20',700);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (12,1,'Vitalik','Alexandrovich','Voitehovsky','1991-02-19',1000);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (14,1,'Yauheniya','Dmitrievna','Yarmaliuk','1991-02-10',600);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (18,10,'Zinaida','Olegavna','Levchyk','1966-06-06',300);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (19,2,'Elena','Nikolaevna','Ganchyk','1950-10-10',430);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (20,8,'Elena','Egorovna','Chymanova','1992-10-09',550);
INSERT INTO `employees` (`id`,`deptId`,`name`,`patronymic`,`surname`,`birth`,`salary`) VALUES (21,1,'Yauheniya','Dmitrievna','Yarmaliuk','1991-02-10',600);


