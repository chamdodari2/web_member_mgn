select  * from member;

desc member;

insert into member values(
1, 
password('1111'), 
'김상건',
40, 
'여자', 
'test@test.co.kr'
);

insert into member values(
'admin', 
password('rootroot'), 
'이종윤',
41, 
'여자', 
'admin@test.co.kr'
);
CREATE TABLE member (
	id  varchar(15)    NOT null,
	passwd    char(41),
	name  varchar(15), 
	age int(11),   
	gender varchar(5),
	email varchar(30),
	primary key(id)
);

select id, name, age, gender,email 
from member 
where id =1 and passwd = password('1111');


insert into member values
(1, password('1111'), '김상건',40, '여자', 'test@test.co.kr');