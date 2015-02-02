createdb HIFI_THATTU_KADA

psql HIFI_THATTU_KADA

create schema admn;

create table admn.tbl_user(
  pki_user_id 	serial primary key not null,
  uvc_user_name varchar unique not null,
  uvc_email 	varchar unique not null,
  vc_passwd 	varchar not null,
  b_send_updates boolean default false,
  dt_time 	timestamp without time zone 
);

-- to retrive all the schemas for db
select schema_name from information_schema.schemata;
-- to retrive all the tables from schema
select * from information_schema.tables where table_schema='admn';
--Creating Sequence for incrementing by 1
create SEQUENCE userEntity_Seq start with 1 increment by 1;

create table UserConnection (
  userId varchar(255) not null,
  providerId varchar(255) not null,
  providerUserId varchar(255),
  rank int not null,
  displayName varchar(255),
  profileUrl varchar(512),
  imageUrl varchar(512),
  accessToken varchar(255) not null,
  secret varchar(255),
  refreshToken varchar(255),
  expireTime bigint,
  primary key (userId, providerId, providerUserId)
  );
  
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);



-- IN MYSQL Database

-- login as mysql -u root -p
-- Enter password: password
-- mysql>
show databases;
CREATE DATABASE HIFI_THATTU_KADA;
create schema admn;

create table admn.tbl_user(

  pki_user_id 	int primary key AUTO_INCREMENT not null, 
  uvc_user_name varchar(255) unique not null,
  uvc_email 	varchar(512) unique not null,
  vc_passwd 	varchar(255) not null,
  b_send_updates boolean default false
  
);
