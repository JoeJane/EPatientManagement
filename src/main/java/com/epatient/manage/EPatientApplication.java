package com.epatient.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * EPatient starter class
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
@SpringBootApplication
public class EPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EPatientApplication.class, args);
		System.out.println("E-Patient Application is Started Succesfully");
	}

}
