use mini_test;
create table address(
	id int primary key auto_increment,
    address varchar(100)
);
create table classes(
	id int primary key auto_increment,
    `name` varchar(30),
    `language` varchar(20),
    `description` text
);
create table student(
	id int primary key auto_increment,
    fullName varchar(20),
    address_id int,
    age tinyint,
    phone varchar(15) unique,
    classes_id int,
    foreign key(address_id) references address(id),
    foreign key(classes_id) references classes(id)
);
create table course(
	id int primary key auto_increment,
    `name` varchar(20),
    `description` text
);

create table `point`(
	id int primary key auto_increment,
    course_id int,
    student_id int,
    `point` int,
    foreign key(course_id) references course(id),
    foreign key(student_id) references student(id)
);

insert into `address`(`address`)
values ("address1");
insert into `address`(`address`)
values ("address2");
insert into `address`(`address`)
values ("address3");
insert into `address`(`address`)
values ("address4");
insert into `address`(`address`)
values ("address5");

insert into classes(`name`, `language`,`description`)
values ("class_name1", "language1", "description1");
insert into classes(`name`, `language`,`description`)
values ("class_name2", "language2", "description2");
insert into classes(`name`, `language`,`description`)
values ("class_name3", "language3", "description3");
insert into classes(`name`, `language`,`description`)
values ("class_name4", "language4", "description4");
insert into classes(`name`, `language`,`description`)
values ("class_name5", "language5", "description5");

insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName1", 4, 20, 123456789, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName2", 4, 20, 1234567891, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName3", 4, 20, 1234567892, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName4", 4, 20, 1234567893, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName5", 4, 20, 1234567894, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName6", 4, 20, 1234567895, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName7", 4, 20, 1234567896, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName8", 4, 20, 1234567897, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName9", 4, 20, 1234567898, 2);
insert into student(fullName,address_id,age,phone,classes_id)
values ("fullName10", 4, 20, 1234567899, 3);

insert into `point`(course_id, student_id, `point`)
values(1, 11, 7);
insert into `point`(course_id, student_id, `point`)
values(2, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);
insert into `point`(course_id, student_id, `point`)
values(1, 1, 7);

select * from student where fullName like "%Nguyen%";
select * from student where fullName like "%Anh%";
select * from student where age >= 5 and age <= 15;
select * from student where id = 12 or id = 13;

select c.`name`, count(*) sốHV from student s
join classes c on s.classes_id = c.id
group by c.`name`;

select c.`name`, count(s.fullName) sốHV, avg(p.`point`) DTB  from `point` p
join course c on p.course_id = c.id
join student s on p.student_id = s.id
group by c.`name`;



