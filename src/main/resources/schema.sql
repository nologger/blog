create table if not exists member (
    id bigint auto_increment,
    account varchar(40) not null,
    password varchar(40) not null,
    pinNumber varchar(40) not null,
    name varchar(40) not null,
    phoneNumber varchar(15) not null,
    createAt timestamp not null,
    authority varchar(10),
    primary key(id)
);

create table if not exists category (
  id bigint auto_increment,
  title varchar(40) not null,
  viewPath varchar(40) not null,
  authority varchar(40),
  primary key(id)
);

create table if not exists posts (
  id bigint auto_increment,
  categoryId bigint,
  title varchar(80) not null,
  summary varchar(200),
  content clob,
  createAt timestamp,
  modifiedAt timestamp,
  foreign key(categoryId) references category(id),
  primary key(id)
);

