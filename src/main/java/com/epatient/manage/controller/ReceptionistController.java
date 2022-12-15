package com.epatient.manage.controller;

import com.epatient.manage.model.Patient;
import com.epatient.manage.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Optional;

/**
 * This class handles all the Receptionist related functionalities
 * Author:
 * Created on :
 */
@Controller
public class ReceptionistController {
	private PatientService patientService;

	public ReceptionistController(@Autowired PatientService patientService){
		this.patientService = patientService;
	}

	@GetMapping("/receptionistHome")
	public String receptionistHome() {
		return "receptionistHome";
	}

	@PostMapping("/createPatient")
	public Patient createPatient(@RequestBody Patient patient){
		Objects.requireNonNull(patient.getEmergencyFirstName());
		Objects.requireNonNull(patient.getEmergencyLastName());
		Objects.requireNonNull(patient.getPhoneNumber());
		Objects.requireNonNull(patient.getAddress());
		Objects.requireNonNull(patient.getDateOfBirth());

		patientService.createPatient(patient);

		return patient;
	}

	@GetMapping("/viewPatient") // gets by phone number since it is unique per human being, so guaranteed to work
	public Optional<Patient> viewPatient(@RequestParam String phoneNumber) {
		Objects.requireNonNull(phoneNumber);
		return patientService.viewPatient(phoneNumber);
	}
}
