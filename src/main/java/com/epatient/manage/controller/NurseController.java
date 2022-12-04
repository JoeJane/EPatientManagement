package com.epatient.manage.controller;

import com.epatient.manage.model.*;
import com.epatient.manage.service.DiagnosisService;
import com.epatient.manage.service.PatientService;
import com.epatient.manage.service.UserService;
import com.epatient.manage.util.Converter;
import org.apache.taglibs.standard.lang.jstl.test.ParserTest;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("nurse")
public class NurseController {

	@Autowired
	UserService userService;

	@Autowired
	PatientService patientService;

	@Autowired
	DiagnosisService diagnosisService;

	@GetMapping("/home")
	public String nurseHome(Model model, Principal principal) {
		List<User> users = userService.findByRole(Role.PATIENT);
		LocalDate curDate = LocalDate.now();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});


		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

		model.addAttribute("searchterm", new SearchTerm());
		model.addAttribute("users", users);
		model.addAttribute("message", "Welcome " + currentUser.getFullName());

		return "/nurse/home";
	}

	@PostMapping("/search")
	public String search(Model model, @ModelAttribute("searchterm") SearchTerm searchTerm, Principal principal) {

		List<User> users = userService.searchUsersForNurseRole(searchTerm.getValue(), searchTerm.getStatus());
		LocalDate curDate = LocalDate.now();
		users.forEach( user -> {
			user.setAge(Period.between(user.getDateOfBirth(), curDate).getYears());
		});

		model.addAttribute("searchterm", searchTerm);
		model.addAttribute("users", users);

		return "/nurse/home";
	}

	@GetMapping("/patient/view/{id}")
	public String viewUser(@PathVariable("id") Integer id, Model model) {
		User user = (User) userService.findById(id).get();
		Patient patient = (Patient) user;

		model.addAttribute("userForm", user);
		model.addAttribute("diagnoses", patient.getDiagnoses());

		return "/nurse/viewForm";
	}

	@GetMapping("/patient/view-prescription/{diagnosisID}")
	public String viewPatientPrescription(@PathVariable("diagnosisID") Integer diagnosisID, Model model) {

		Diagnosis diagnosis = diagnosisService.findById(diagnosisID);
		User patient = diagnosis.getPatient();
		List<Prescription> prescriptions = diagnosis.getPrescriptions();

		model.addAttribute("patient", patient);
		model.addAttribute("diagnoses", diagnosis);
		model.addAttribute("prescriptionList", prescriptions);

		return "/nurse/viewPrescription";
	}

	@GetMapping("/profile")
	public String viewProfile(Model model, Principal principal) {
		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

		User user = userService.findById(currentUser.getUserId()).orElse(new User());

		model.addAttribute("userForm", user);

		return "/nurse/viewProfile";
	}

	@GetMapping("/edit")
	public String editUser(Model model, Principal principal) {
		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
		User user = userService.findById(currentUser.getUserId()).orElse(new User());

		model.addAttribute("userForm", user);
		populateDefaultCheckBoxesAndRadios(model);

		return "/nurse/editProfile";
	}

	@PostMapping("/save")
	public String addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, Model model, final RedirectAttributes redirectAttributes, Principal principal) {

		Nurse currentUser  = (Nurse)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
		Optional<User> optionalNurse = userService.findById(currentUser.getUserId());

		if(user.getNurseType() == null){
			bindingResult.rejectValue("nurseType", "required.nurseType");
		}

		if(!optionalNurse.isPresent()){
			bindingResult.rejectValue("username", "invalid.user");
		}

		if (bindingResult.hasErrors()) {
			populateDefaultCheckBoxesAndRadios(model);
			return "nurse/registerForm";
		}

		Nurse nurseUser = (Nurse) optionalNurse.get();
		nurseUser.setFirstName(user.getFirstName());
		nurseUser.setLastName(user.getLastName());
		nurseUser.setNurseType(user.getNurseType());
		nurseUser.setDateOfBirth(user.getDateOfBirth());
		nurseUser.setGender(user.getGender());
		nurseUser.setEmail(user.getEmail());
		nurseUser.setPhoneNumber(user.getPhoneNumber());
		nurseUser.setAddress(user.getAddress());
		nurseUser.setAddressNo(user.getAddressNo());
		nurseUser.setCity(user.getCity());
		nurseUser.setProvince(user.getProvince());
		nurseUser.setPostalCode(user.getPostalCode());
		nurseUser.setCountry(user.getCountry());

		redirectAttributes.addFlashAttribute("alert", "success");
		redirectAttributes.addFlashAttribute("msg", "User updated successfully!");

		user.setRole(Role.NURSE);
		User newUser = Converter.convert(user);
		userService.saveOrUpdate(newUser);

		return "redirect:/nurse/view/" + newUser.getUserId();
	}

	@GetMapping("/resetPassword")
	public String resetPassword(Model model, Principal principal) {
		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();

		User user = userService.findById(currentUser.getUserId()).get();
		user.setPassword("");
		model.addAttribute("userForm", user);

		return "/nurse/resetPassword";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model, Principal principal) {
		if(user.getPassword() == null || user.getPassword().equals("")){
			bindingResult.rejectValue("password", "required.password");
		}

		if(!user.getPassword().equals(user.getConfirmPassword())){
			bindingResult.rejectValue("confirmPassword", "notmatch.confirmPassword");
		}

		if(bindingResult.hasErrors()){
			model.addAttribute("userForm", user);
			return "/nurse/resetPassword";
		}

		User currentUser  = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
		currentUser = userService.findById(currentUser.getUserId()).get();

		currentUser.setPassword(user.getPassword());

		userService.updatePassword(currentUser);

		return "redirect:/nurse/home";
	}

	private void populateDefaultCheckBoxesAndRadios(Model model) {
		model.addAttribute("provinces", getProvinces());
		model.addAttribute("countries", getCountries());
		model.addAttribute("nurseTypes", getNurseTypes());
	}

	private static Map<String, String> getCountries(){
		Map<String, String> countries = new TreeMap<>();
		countries.put("CA", "Canada");
		countries.put("US", "America");

		return countries;
	}

	private static Map<Province, String> getProvinces(){
		return Arrays.stream(Province.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

	private static Map<NurseType, String> getNurseTypes(){
		return Arrays.stream(NurseType.values()).collect(Collectors.toMap(e->e, e->e.getValue(), (oldValue, newValue) -> oldValue, TreeMap::new));
	}

}
