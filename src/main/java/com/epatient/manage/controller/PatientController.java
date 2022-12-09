package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class handles all the Patient related functionalities
 * Author:
 * Created on :
 */
@Controller
public class PatientController {

	@GetMapping("/patientHome")
	public String patientHome() {
		return "patientHome";
	}
}
