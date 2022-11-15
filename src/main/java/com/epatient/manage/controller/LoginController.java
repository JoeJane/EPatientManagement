package com.epatient.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epatient.manage.model.User;
import com.epatient.manage.repository.UserRepository;

/**
 * Author: Jane Aarthy
 * Created on : 04/11/2022
 * This class handles all the login related functionality
 * ***/

@Controller
public class LoginController {
	
	@Autowired
    UserRepository userRepository;

	 @GetMapping("/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your Email and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
	 
	 //When clicking sign-in
	 @PostMapping(value = "/login")
	    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        User user = userRepository.findByEmail(email);
	        request.getSession().setAttribute("user", user); //Add user to session
	        if (validateUser(email, password, user)) {
	        	if(user.getRole().equals("admin")) {
		            ModelAndView view = new ModelAndView("redirect:/adminHome");
		            return view;
	        	}
	        	if(user.getRole().equals("doctor")) {
		            ModelAndView view = new ModelAndView("redirect:/doctorHome");
		            return view;
	        	}
	        	if(user.getRole().equals("patient")) {
		            ModelAndView view = new ModelAndView("redirect:/patientHome");
		            return view;
	        	}
	        	if(user.getRole().equals("nurse")) {
		            ModelAndView view = new ModelAndView("redirect:/nurseHome");
		            return view;
	        	}if(user.getRole().equals("receptionist")) {
					ModelAndView view = new ModelAndView("redirect:/receptionistHome");
		            return view;
	        	}if(user.getRole().equals("labassistant")) {
		            ModelAndView view = new ModelAndView("redirect:/labAssistantHome");
		            return view;
	        	}
	        	 ModelAndView error = new ModelAndView("login", "errMsg", "Role not defined");
		            return error;	
	        } else {
	            ModelAndView error = new ModelAndView("login", "errMsg", "Invalid Username or Password");
	            return error;
	        }
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	        request.getSession().invalidate();
	        redirectAttributes.addFlashAttribute("message", "You have successfully logged out !");

	        return "redirect:/login";
	    }
	    
	    private boolean validateUser(String email, String password, User user) {
	        boolean isValid = false;
	        try {
	            if (user.getPassword().equals(password)) {
	                isValid = true;
	            }
	        } catch (Exception ex) {
	            isValid = false;
	        }
	        return isValid;
	    }

	   
}
