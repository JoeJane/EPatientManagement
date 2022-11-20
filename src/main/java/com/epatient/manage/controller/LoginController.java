package com.epatient.manage.controller;

import com.epatient.manage.model.User;
import com.epatient.manage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Jane Aarthy
 * Created on : 04/11/2022
 * This class handles all the login related functionality
 ***/

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Username or password is incorrect!");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
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
