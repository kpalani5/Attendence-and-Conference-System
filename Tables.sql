create database das;
use das;

drop table validation;

create table validation (
userName varchar(30) primary key,
passwd varchar(30),
panelNo bigint(5)
);

insert into validation values ("lib","ssn@123",1);
insert into validation values ("ofc","ssn@123",2);
insert into validation values ("cpe","ssn@123",4);

select * from validation;

drop table attended;
drop table marks;
drop table subjects;
drop table student;

create table student (
regno bigint(15) primary key,
fname varchar(40) not null,
lname varchar(30) not null,
course varchar(20) not null,
semester int(2) not null,
section varchar(2) not null
);

create table subjects (
subcode varchar(10) not null,
subname varchar(50) not null,
semester int(2) not null,
course varchar(20) not null,
subtype varchar(20) not null,
primary key(subcode,semester,course)
);

create table attended (
regno bigint(15) not null,
subcode varchar(10) not null,
total_hours int(3) not null,
hours_attended int(3) not null,
period int(1) not null,
foreign key(regno) references student(regno),
foreign key(subcode) references subjects(subcode),
primary key(regno,subcode,period)
);

create table marks (
regno bigint(15) not null,
subcode varchar(10) not null,
mark int(3) not null,
test_no int(1) not null,
foreign key(regno) references student(regno),
foreign key(subcode) references subjects(subcode),
primary key(regno,subcode,test_no)
);

select * from student;
select * from subjects;
select * from attended;
select * from marks;


drop table participants;
drop table resource;
drop table organize;
drop table attending;
drop table lecture;

create table organize (
sno bigint(20) primary key,
title varchar(80),
eventDate date not null,
eventType varchar(40),
duration varchar(20),
sponsor varchar(50)
);

create table resource (
sno bigint(20),
person varchar(40),
primary key(sno,person),
foreign key(sno) references organize(sno)
);

create table participants (
sno bigint(20),
participantType varchar(50),
count int(7),
foreign key(sno) references organize(sno),
primary key(sno,participantType)
);

create table attending (
sno bigint(20),
title varchar(80),
eventDate date not null,
eventType varchar(40),
duration varchar(20),
sponsor varchar(50),
payment varchar(30),
staff varchar(50),
staffID varchar(10) not null,
inst varchar(50),
place varchar(40),
primary key(sno,staffID)
);

create table lecture (
sno bigint(20) primary key,
title varchar(80),
eventDate date,
topic varchar(100),
duration varchar(20),
staff varchar(50),
staffID varchar(10),
inst varchar(50),
place varchar(40)
);


select * from organize;
select * from participants;
select * from resource;
select * from attending;
select * from lecture;
