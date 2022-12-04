CREATE SCHEMA IF NOT EXISTS pmsdatabase;

use pmsdatabase;

create table if not exists users
(
    userid       int auto_increment
        primary key,
    address      varchar(255) null,
    address_no   varchar(255) null,
    city         varchar(255) null,
    country      varchar(255) null,
    created_at   datetime     null,
    dob          date         not null,
    deleted      bit          null,
    email        varchar(255) null,
    first_name   varchar(255) null,
    gender       varchar(255) null,
    last_name    varchar(255) null,
    password     varchar(255) null,
    phone_number varchar(255) null,
    postal_code  varchar(255) null,
    province     varchar(255) not null,
    role         varchar(255) not null,
    updated_at   datetime     null,
    username     varchar(255) null
);

create table if not exists doctor
(
    speciality varchar(255) null,
    userid     int          not null
        primary key,
    constraint FKa8blhfn5icl67pr7ii52kgj9g
        foreign key (userid) references users (userid)
);

create table if not exists lab_assistant
(
    userid int not null
        primary key,
    constraint FKiiovqx785tqbvi5gf5cie9d8n
        foreign key (userid) references users (userid)
);

create table if not exists nurse
(
    nurse_type varchar(255) null,
    userid     int          not null
        primary key,
    constraint FK2pafa0ehrrle3rosrxq5vcnhm
        foreign key (userid) references users (userid)
);

create table if not exists patient
(
    blood_group            varchar(255) not null,
    emergency_email        varchar(255) null,
    emergency_first_name   varchar(255) null,
    emergency_last_name    varchar(255) null,
    emergency_phone_number varchar(255) null,
    upcoming_appointment   datetime     null,
    userid                 int          not null
        primary key,
    doctor_id              int          null,
    constraint FK1smnmhpf652tysjfk1onu0axp
        foreign key (userid) references users (userid),
    constraint FKmer5utvy1hiff7ovs6f4bjtnw
        foreign key (doctor_id) references doctor (userid)
);

create table if not exists diagnosis
(
    id            int auto_increment
        primary key,
    created_at    datetime     null,
    diagnosisname varchar(255) null,
    patient_id    int          null,
    constraint FKp8tgyroh9ehqikufxe905q0xs
        foreign key (patient_id) references patient (userid)
);

create table if not exists prescription
(
    id            int auto_increment
        primary key,
    created_at    datetime     null,
    prescriptions varchar(255) null,
    diagnosis_id  int          null,
    constraint FKrj69paft3na7qqssd01vm9mtp
        foreign key (diagnosis_id) references diagnosis (id)
);

create table if not exists receptionist
(
    userid int not null
        primary key,
    constraint FK6hdavkh3apa5b52hru2p8jjtn
        foreign key (userid) references users (userid)
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
