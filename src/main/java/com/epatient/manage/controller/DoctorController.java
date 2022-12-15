package com.epatient.manage.controller;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;

/**
 * This class handles all the Doctor related functionalities
 * Author:
 * Created on :
 */
@Controller
public class DoctorController {

	private DiagnosisService diagnosisService;

	public DoctorController(@Autowired DiagnosisService diagnosisService){
		this.diagnosisService = diagnosisService;
	}
	 
	@GetMapping("/doctorHome")
	public String doctorHome() {
		return "doctorHome";
	}

	@PutMapping("/editDiagnoses")
	public void editDiagnoses(Integer patientId, Diagnosis diagnosis){
		Objects.requireNonNull(patientId);

		diagnosisService.editDiagnoses(patientId, diagnosis);
	}
}
