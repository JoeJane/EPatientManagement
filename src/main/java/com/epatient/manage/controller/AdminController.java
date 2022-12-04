package com.epatient.manage.controller;

import com.epatient.manage.model.*;
import com.epatient.manage.service.UserService;
import com.epatient.manage.util.Converter;
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

	private User getTempUser(){
		User newUser = new User();

		newUser.setEmail("a@gmail.com");
		newUser.setPassword("password");
		newUser.setFirstName("Joe");
		newUser.setAddress("68 Corporate Drive");
		newUser.setAddressNo("123");
		newUser.setCity("Scarborough");
		newUser.setPostalCode("M1H3h3");
		newUser.setProvince(Province.ON);
		newUser.setCountry("CA");
		newUser.setGender("MALE");
		newUser.setPhoneNumber("12345678");
		return newUser;
	}

	@GetMapping("/home")
	public String adminHome(Model model, Principal principal) {
		List<User> users = userService.findByRoleNot(Role.ADMIN);
		LocalDate curDate = LocalDate.now();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});
		

		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

		model.addAttribute("searchterm", new SearchTerm());
		model.addAttribute("bulkAction", new SearchTerm());
		model.addAttribute("users", users);
		model.addAttribute("roles", getRoles());
		model.addAttribute("message", "Welcome " + currentUser.getFullName());
		
		return "/admin/home";
	}

	@PostMapping("/search")
	public String search(Model model, @ModelAttribute("searchterm") SearchTerm searchTerm) {

		List<User> users = userService.searchUsersForAdminRole(searchTerm);
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

		List<User> users = userService.findByRoleNot(Role.ADMIN);
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});

		model.addAttribute("searchterm", new SearchTerm());
		model.addAttribute("bulkAction", new SearchTerm());
		model.addAttribute("users", users);

		return "/admin/home";
	}

	@GetMapping("/add")
	public String addUser(Model model) {
		// model.addAttribute("userForm", new User());
		model.addAttribute("userForm", getTempUser());
		populateDefaultCheckBoxesAndRadios(model);
		return "/admin/registerForm";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id).orElse(new User());

		model.addAttribute("userForm", user);
		populateDefaultCheckBoxesAndRadios(model);

		return "/admin/registerForm";
	}

	@PostMapping("/save")
	public String addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, Model model, final RedirectAttributes redirectAttributes) {

		if(user.getRole() == Role.DOCTOR){
			if(user.getSpeciality() == null){
				bindingResult.rejectValue("speciality", "required.speciality");
			}
		} else if(user.getRole() == Role.NURSE){
			if(user.getNurseType() == null){
				bindingResult.rejectValue("nurseType", "required.nurseType");
			}
		} else if(user.getRole() == Role.PATIENT){

			if(user.getBloodGroup() == null){
				bindingResult.rejectValue("bloodGroup", "required.bloodGroup");
			}
			if(user.getEmergencyFirstName() == null){
				bindingResult.rejectValue("emergencyFirstName", "required.emergencyFirstName");
			}
			if(user.getEmergencyLastName() == null){
				bindingResult.rejectValue("emergencyLastName", "required.emergencyLastName");
			}
			if(user.getEmergencyEmail() == null){
				bindingResult.rejectValue("emergencyEmail", "required.emergencyEmail");
			}
			if(user.getEmergencyPhone() == null){
				bindingResult.rejectValue("emergencyPhone", "required.emergencyPhone");
			}
		}

		if(user.getUserId()==null && userService.findUserByUsername(user.getUsername()).isPresent()){
			bindingResult.rejectValue("username", "Duplicate.userForm.username");
		}


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

		User newUser = Converter.convert(user);
		userService.saveOrUpdate(newUser);

		return "redirect:/admin/view/" + newUser.getUserId();
	}

	@GetMapping("/view/{id}")
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

	@GetMapping("/user/resetPassword/{id}")
	public String resetUserPassword(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id).get();
		user.setPassword("");
		model.addAttribute("userForm", user);

		return "/admin/resetPassword";
	}

	@PostMapping("/user/resetPassword")
	public String resetUserPassword(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, final RedirectAttributes redirectAttributes) {

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

	@GetMapping("/resetPassword")
	public String resetAdminPassword(Model model, Principal principal) {
		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

		User user = userService.findById(currentUser.getUserId()).get();
		user.setPassword("");
		model.addAttribute("userForm", user);

		return "/admin/resetAdminPassword";
	}

	@PostMapping("/resetPassword")
	public String resetAdminPassword(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, Principal principal) {
		if(user.getPassword() == null || user.getPassword().equals("")){
			bindingResult.rejectValue("password", "required.password");
		}

		if(!user.getPassword().equals(user.getConfirmPassword())){
			bindingResult.rejectValue("confirmPassword", "notmatch.confirmPassword");
		}

		if(bindingResult.hasErrors()){
			model.addAttribute("userForm", user);
			return "/admin/resetAdminPassword";
		}

		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
		currentUser = userService.findById(currentUser.getUserId()).get();

		currentUser.setPassword(user.getPassword());

		userService.updatePassword(currentUser);

		return "redirect:/admin/home";
	}

	private void populateDefaultCheckBoxesAndRadios(Model model) {
		Map<Role, String > roles = getRoles();

		model.addAttribute("roles", roles);
		model.addAttribute("bloodGroups", getBloodGroups());
		model.addAttribute("provinces", getProvinces());
		model.addAttribute("countries", getCountries());
		model.addAttribute("nurseTypes", getNurseTypes());
		model.addAttribute("doctorSpecialities", getDoctorSpecialities());
	}

	private static Map<String, String> getCountries(){
		Map<String, String> countries = new TreeMap<>();
		countries.put("CA", "Canada");
		countries.put("US", "America");

		return countries;
	}

	private static Map<Role, String> getRoles(){
		Map<Role, String> roles = Arrays.stream(Role.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
		roles.remove(Role.ADMIN);
		return roles;
	}

	private static Map<BloodGroup, String> getBloodGroups(){
		return Arrays.stream(BloodGroup.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<Province, String> getProvinces(){
		return Arrays.stream(Province.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<NurseType, String> getNurseTypes(){
		return Arrays.stream(NurseType.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<DoctorSpeciality, String> getDoctorSpecialities(){
		return Arrays.stream(DoctorSpeciality.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}
}
