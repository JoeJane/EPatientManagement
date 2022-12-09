package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class handles all the Receptionist related functionalities
 * Author:
 * Created on :
 */
@Controller
public class ReceptionistController {

	@GetMapping("/receptionistHome")
	public String receptionistHome() {
		return "receptionistHome";
	}
}
