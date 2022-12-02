CREATE SCHEMA IF NOT EXISTS pmsdatabase;

use pmsdatabase;

create table if not exists users
(
    userid                 int auto_increment primary key,
    email                  varchar(45)  not null,
    username               varchar(45)  not null,
    password               varchar(150) not null,
    first_name             varchar(45)  not null,
    last_name              varchar(45)  not null,
    address                varchar(100) not null,
    address_no             varchar(5)   not null,
    city                   varchar(30)  not null,
    province               varchar(20)  not null,
    postal_code            varchar(10)  not null,
    country                varchar(45)  not null,
    gender                 varchar(20)  not null,
    blood_group            varchar(15)  not null,
    phone_number           varchar(15)  not null,
    created_at             datetime     null,
    updated_at             datetime     null,
    role                   varchar(15)  not null,
    dob                    date         not null,
    deleted                tinyint(1)   null,
    emergency_email        varchar(45)  not null,
    emergency_first_name   varchar(45)  not null,
    emergency_last_name    varchar(45)  not null,
    emergency_phone_number varchar(15)  not null
);

CREATE TABLE if not exists doctor
(
    doctorid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    position VARCHAR(45)     NOT NULL,
    userid   INT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE if not exists nurse
(
    nurseid   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    position  VARCHAR(45)     NOT NULL,
    nursetype VARCHAR(2)      NOT NULL, # Registered Nurse (RN) or Regular Nurse 👎
    userid    INT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE if not exists patient
(
    patientid           INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    bloodgroup          VARCHAR(10)     NOT NULL,
    healthcardnumber    VARCHAR(30),
    upcomingappointment VARCHAR(30),
    doctorid            INT,
    FOREIGN KEY (doctorid) REFERENCES doctor (doctorid),
    userid              INT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE if not exists receptionist
(
    receptionistid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userid         INT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE if not exists labassistant
(
    labassistantid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userid         INT,
    FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE if not exists reports
(
    appointmentid  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    report         VARCHAR(255)    NOT NULL,
    patientid      INT,
    FOREIGN KEY (patientid) REFERENCES patient (patientid),
    doctorid       INT,
    FOREIGN KEY (doctorid) REFERENCES doctor (doctorid),
    labassistantid INT,
    FOREIGN KEY (labassistantid) REFERENCES labassistant (labassistantid),
    fileviewer     BLOB            NOT NULL
);
