create database dataExam
CHARACTER SET 'utf8' 
COLLATE 'utf8_general_ci';
 use dataExam;
 
 CREATE TABLE examinee(
  id char(20) NOT NULL,
  name char(20) DEFAULT NULL,
  sex char(4) DEFAULT NULL,
  company varchar(50) DEFAULT NULL,
  address varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  password char(20) DEFAULT NULL,
  memo varchar(100) DEFAULT NULL,
  examtype varchar(50) DEFAULT NULL,
  pic varchar(50) DEFAULT NULL,
     primary key (id)
)engine=InnoDB default charset=utf8;
show variables like'char%';