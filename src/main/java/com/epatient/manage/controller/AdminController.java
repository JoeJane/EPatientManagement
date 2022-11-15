package com.epatient.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Jane Aarthy
 * Created on : 13/11/2022
 * This class handles all the admin related functionality
 * ***/
@Controller
public class AdminController {

	@GetMapping("/adminHome")
	public String adminHome() {
		return "/admin/home";
	}

	@GetMapping("/addUser")
	public String addUser() {
		return "/addUser";
	}

	@GetMapping("/editUser")
	public String editUser() {
		return "/editUser";
	}

	@GetMapping("/resetPassword")
	public String resetPassword() {
		return "/resetPassword";
	}
}
