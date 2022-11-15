package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LabAssitantController {

	@GetMapping("/labAssistantHome")
	public String labAssistantHome() {
		return "labAssistantHome";
	}
}
