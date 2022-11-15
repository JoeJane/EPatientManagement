package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceptionistController {

	@GetMapping("/receptionistHome")
	public String receptionistHome() {
		return "receptionistHome";
	}
}
