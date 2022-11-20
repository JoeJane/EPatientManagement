package com.epatient.manage.controller;

import com.epatient.manage.model.*;
import com.epatient.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Jane Aarthy
 * Created on : 13/11/2022
 * This class handles all the admin related functionality
 * ***/
@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	UserService userService;

	@GetMapping("/home")
	public String adminHome(Model model, Principal principal) {
		List<User> users = userService.findByRoleNot(Role.ADMIN);
		LocalDate curDate = LocalDate.now();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});

		User currentUser  = ((User)((UsernamePasswordAuthenticationToken) principal).getPrincipal());

		model.addAttribute("searchterm", new SearchTerm());
		model.addAttribute("bulkAction", new SearchTerm());
		model.addAttribute("users", users);
		model.addAttribute("message", "Welcome " + currentUser.getFullName());
		return "/admin/home";
	}

	@PostMapping("/search")
	public String search(Model model, @ModelAttribute("searchterm") SearchTerm searchTerm) {

		List<User> users = userService.search(searchTerm.getValue(), searchTerm.getStatus());
		LocalDate curDate = LocalDate.now();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});

		model.addAttribute("searchterm", searchTerm);
		model.addAttribute("bulkAction", searchTerm);
		model.addAttribute("users", users);

		return "/admin/home";
	}

	@PostMapping("/bulkAction")
	public String bulkAction(Model model, @ModelAttribute("bulkAction") SearchTerm searchTerm) {

		List<Integer> ids = Arrays.asList(searchTerm.getIds()).stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());

		userService.saveAllUser(ids, searchTerm.getStatus());

		LocalDate curDate = LocalDate.now();

		List<User> users = userService.findAll();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});

		model.addAttribute("searchterm", new SearchTerm());
		model.addAttribute("bulkAction", new SearchTerm());
		model.addAttribute("users", users);

		return "/admin/home";
	}

	@GetMapping("/users/add")
	public String addUser(Model model) {
		model.addAttribute("userForm", new User());
		populateDefaultCheckBoxesAndRadios(model);
		return "/admin/registerForm";
	}

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id).orElse(new User());

		model.addAttribute("userForm", user);
		populateDefaultCheckBoxesAndRadios(model);

		return "/admin/registerForm";
	}

	@PostMapping("/users")
	public String addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, Model model, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			populateDefaultCheckBoxesAndRadios(model);
			return "admin/registerForm";
		}

		redirectAttributes.addFlashAttribute("alert", "success");
		if (user.isNew()) {
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		} else {
			redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		}

		userService.saveOrUpdate(user);

		return "redirect:/admin/users/view/" + user.getUserId();
	}

	@GetMapping("/users/view/{id}")
	public String viewUser(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id).orElse(new User());

		model.addAttribute("userForm", user);

		return "/admin/viewForm";
	}

	@GetMapping(value="/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> activateUser(@PathVariable("id") Integer id) {
		userService.changeStatusById(id, false);
		return new ResponseEntity<>(id, HttpStatus.OK);

	}

	@GetMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Integer> deleteUser(@PathVariable("id") Integer id) {
		userService.changeStatusById(id, true);
		return new ResponseEntity<>(id, HttpStatus.OK);

	}

	@GetMapping("/addUser1")
	public String addUser1(Model model) {
		model.addAttribute("userForm", new User());
		populateDefaultCheckBoxesAndRadios(model);
		return "/admin/addUser";
	}

	@GetMapping("/users/resetPassword/{id}")
	public String resetPassword(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id).get();
		user.setPassword("");
		model.addAttribute("userForm", user);

		return "/admin/resetPassword";
	}

	@PostMapping("/users/resetPassword")
	public String resetPassword(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, final RedirectAttributes redirectAttributes) {

		if(user.getPassword() == null || user.getPassword().equals("")){
			bindingResult.rejectValue("password", "required.password");
		}

		if(!user.getPassword().equals(user.getConfirmPassword())){
			bindingResult.rejectValue("confirmPassword", "notmatch.confirmPassword");
		}

		if(bindingResult.hasErrors()){
			model.addAttribute("userForm", user);
			return "/admin/resetPassword";
		}

		userService.updatePassword(user);

		return "redirect:/admin/home";
	}

	private void populateDefaultCheckBoxesAndRadios(Model model) {
		Map<Role, String > roles = getRoles();
		roles.remove(Role.ADMIN);

		model.addAttribute("roles", roles);
		model.addAttribute("bloodGroups", getBloodGroups());
		model.addAttribute("provinces", getProvinces());
		model.addAttribute("countries", getCountries());
	}

	private static Map<String, String> getCountries(){
		String[] isoCountries = Locale.getISOCountries();
		Map<String, String> countries = new TreeMap<>();
		for (String country : isoCountries) {
			Locale locale = new Locale("en", country);
			countries.put(locale.getCountry(), locale.getDisplayCountry());
		}
		return countries;
	}

	private static Map<Role, String> getRoles(){
		return Arrays.stream(Role.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<BloodGroup, String> getBloodGroups(){
		return Arrays.stream(BloodGroup.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<Province, String> getProvinces(){
		return Arrays.stream(Province.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}
}
