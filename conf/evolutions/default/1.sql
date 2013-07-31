# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id                        bigint not null,
  admin_login_name          varchar(255),
  admin_password_name       varchar(255),
  constraint pk_admin primary key (id))
;

create table business (
  id                        bigint not null,
  business_email            varchar(255),
  business_name             varchar(255),
  business_type             varchar(255),
  business_phone_number     varchar(255),
  business_description      varchar(255),
  constraint pk_business primary key (id))
;

create table login (
  email                     varchar(255),
  password                  varchar(255))
;

create table user (
  email                     varchar(255) not null,
  password                  varchar(255),
  name                      varchar(255),
  constraint pk_user primary key (email))
;

create sequence admin_seq;

create sequence business_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists admin;

drop table if exists business;

drop table if exists login;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists admin_seq;

drop sequence if exists business_seq;

drop sequence if exists user_seq;

