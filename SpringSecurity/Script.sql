drop database if exists springsecurity;
create database springsecurity;
use springsecurity;
CREATE TABLE USERS (
    USERNAME VARCHAR(128) PRIMARY KEY,
    PASSWORD VARCHAR(128) NOT NULL,
    ENABLED CHAR(1) CHECK (ENABLED IN ('Y','N') ) NOT NULL,
   AUTHORITY VARCHAR(128) NOT NULL
);

insert into USERS values('pritam','pritam','Y','ROLE_USER');
insert into USERS values('basudev','basudev','Y','ROLE_ADMIN');
insert into USERS values('saurav','saurav','Y','ROLE_SUPERADMIN');
