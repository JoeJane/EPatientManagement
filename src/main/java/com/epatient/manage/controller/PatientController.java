package com.epatient.manage.controller;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.model.Patient;
import com.epatient.manage.model.Prescription;
import com.epatient.manage.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class handles all the Patient related functionalities
 * Author:
 * Created on :
 */
@Controller
public class PatientController {

	private PatientService patientService;

	public PatientController(@Autowired PatientService patientService){
		this.patientService = patientService;
	}

	@GetMapping("/patientHome")
	public String patientHome() {
		return "patientHome";
	}

	@GetMapping("/viewAppointments") // easier to find by phone no. patients dont remember their id usually
	public LocalDateTime viewAppointments(@RequestParam String phoneNumber){
		Objects.requireNonNull(phoneNumber);

		Optional<Patient>patient = patientService.viewPatient(phoneNumber);
		if(patient.isPresent()) return patient.get().getUpComingAppointment();
		else return null;
	}

	@GetMapping("/viewPrescription")
	public List<Prescription> viewPrescription(@RequestParam String phoneNumber) {
		Objects.requireNonNull(phoneNumber);

		return patientService.getPrescriptions(phoneNumber);
	}

	@GetMapping("/viewDiagnoses")
	public List<Diagnosis> viewDiagnosis(@RequestParam String phoneNumber) {
		Objects.requireNonNull(phoneNumber);

		return patientService.getDiagnoses(phoneNumber);
	}

}
