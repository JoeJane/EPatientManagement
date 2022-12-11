package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class handles all the Doctor related functionalities
 * Author:
 * Created on :
 */
@Controller
public class DoctorController {
	 
	@GetMapping("/doctorHome")
	public String doctorHome() {
		return "doctorHome";
	}
}
