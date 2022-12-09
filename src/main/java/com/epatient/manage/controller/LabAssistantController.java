package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class handles all the Lab Assistant related functionalities
 * Author:
 * Created on :
 */
@Controller
public class LabAssistantController {

	@GetMapping("/labAssistantHome")
	public String labAssistantHome() {
		return "labAssistantHome";
	}
}
