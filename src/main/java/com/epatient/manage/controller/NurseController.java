package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NurseController {

	@GetMapping("/nurseHome")
	public String nurseHome() {
		return "nurseHome";
	}
}
