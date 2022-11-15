CREATE SCHEMA IF NOT EXISTS pmsdatabase;
use pmsdatabase;
CREATE TABLE `users` (
                         `userid` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) NOT NULL,
                         `email` varchar(45) NOT NULL,
                         `password` varchar(25) NOT NULL,
                         `firstname` varchar(45) NOT NULL,
                         `lastname` varchar(45) NOT NULL,
                         `address` varchar(50) NOT NULL,
                         `city` varchar(30) NOT NULL,
                         `province` varchar(20) NOT NULL,
                         `postalcode` varchar(10) NOT NULL,
                         `country` varchar(45) NOT NULL,
                         `phonenumber` varchar(20) NOT NULL,
                         `role` varchar(15) NOT NULL,
                         PRIMARY KEY (`userid`)
);

DROP TABLE IF EXISTS doctor;
CREATE TABLE doctor(
                       doctorid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       position VARCHAR(45) NOT NULL,
                       userid INT, FOREIGN KEY(userid) REFERENCES users(userid)
);


DROP TABLE IF EXISTS nurse;
CREATE TABLE nurse(
                      nurseid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      position VARCHAR(45) NOT NULL,
                      nursetype VARCHAR(2) NOT NULL,
                          userid INT, FOREIGN KEY(userid) REFERENCES users(userid)
);

DROP TABLE IF EXISTS patient;
CREATE TABLE patient(
                        patientid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        bloodgroup VARCHAR(10) NOT NULL,
                        healthcardnumber VARCHAR(30),
                        upcomingappointment VARCHAR(30),
                        doctorid INT, FOREIGN KEY(doctorid) REFERENCES doctor(doctorid),
                        userid INT, FOREIGN KEY(userid) REFERENCES users(userid)
);

DROP TABLE IF EXISTS receptionist;
CREATE TABLE receptionist(
                             receptionistid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             userid INT, FOREIGN KEY(userid) REFERENCES users(userid)
);

DROP TABLE IF EXISTS labassistant;
CREATE TABLE labassistant(
                             labassistantid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             userid INT, FOREIGN KEY(userid) REFERENCES users(userid)
);

DROP TABLE IF EXISTS reports;
CREATE TABLE reports(
                        appointmentid  INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        report VARCHAR(255) NOT NULL,
                        patientid INT, FOREIGN KEY(patientid) REFERENCES patient(patientid),
                        doctorid INT, FOREIGN KEY(doctorid) REFERENCES doctor(doctorid),
                        labassistantid INT, FOREIGN KEY(labassistantid) REFERENCES labassistant(labassistantid),
                        fileviewer BLOB NOT NULL
);

