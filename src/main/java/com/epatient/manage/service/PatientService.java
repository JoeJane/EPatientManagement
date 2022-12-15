package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.model.Patient;
import com.epatient.manage.model.Prescription;

import java.util.List;
import java.util.Optional;

/**
 * Service for Patient entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
public interface PatientService {
    void createPatient(Patient patient);

    Optional<Patient> viewPatient(String phoneNumber);

    List<Prescription> getPrescriptions(String phoneNumber);

    List<Diagnosis> getDiagnoses(String phoneNumber);
}
