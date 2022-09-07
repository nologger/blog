delete from member;
delete from category;

insert into member(account, password, pinnumber, name, phonenumber, createat, authority)
values ('email', 'password', 'pinNumber', 'name', 'phoneNumber', now(), 'admin');

insert into category(title)
values('java');

insert into category(title)
values('spring');

insert into category(title)
values('os');

insert into category(title)
values('report');

insert into category(title)
values('life');

insert into category(title)
values('etc');

insert into category(title, authority)
values('posting', 'admin');