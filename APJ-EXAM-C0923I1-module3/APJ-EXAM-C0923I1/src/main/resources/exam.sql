use exam;
drop table if exists employees;
create table employees(
    id int auto_increment primary key,
    email varchar(50)  ,
    `name` varchar(50),
    address varchar(30),
    phonenumber varchar(20),
    salary varchar(20),
    department varchar(30)

);
INSERT INTO `employees` (`email`, `name`, `address`, `phonenumber`, `salary`, `department`) VALUES ('phuong123@gmail.com', 'phương', 'Đồng tháp', '1234567890', '2.000.000', 'RnD');
INSERT INTO `employees` (`email`, `name`, `address`, `phonenumber`, `salary`, `department`) VALUES ('phu123@gmail.com', 'phú', 'Bình Dương', '1234567890', '3.000.000', 'RnD');