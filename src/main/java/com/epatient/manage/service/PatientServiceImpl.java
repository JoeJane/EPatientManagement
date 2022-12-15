package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.model.Patient;
import com.epatient.manage.model.Prescription;
import com.epatient.manage.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation for @PatientService entity
 * Author: Maiara Karla
 * Created on : 13/11/2022
 */
@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    public PatientServiceImpl(@Autowired PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @Override
    public void createPatient(Patient patient) {
        patientRepository.saveAndFlush(patient); // jpa magic!
    }

    @Override
    public Optional<Patient> viewPatient(String phoneNumber) {
        Patient patient = new Patient();
        patient.setPhoneNumber(phoneNumber);
        Example<Patient>example = Example.of(patient); // find by criteria
        return patientRepository.findOne(example);
    }

    @Override
    public List<Prescription> getPrescriptions(String phoneNumber) {
        List<Prescription>prescriptions = new ArrayList<>();

        Patient patient = new Patient();
        patient.setPhoneNumber(phoneNumber);
        Example<Patient>example = Example.of(patient); // find by criteria
        Optional<Patient> patientOpt =  patientRepository.findOne(example);
        if(patientOpt.isPresent()){
            for(Diagnosis diagnosis: patient.getDiagnoses()){
                for(Prescription prescription: diagnosis.getPrescriptions()){
                    prescriptions.add(prescription);
                }
            }
        }

        return prescriptions;
    }

    @Override
    public List<Diagnosis> getDiagnoses(String phoneNumber) {
        List<Diagnosis>diagnosisList = new ArrayList<>();

        Patient patient = new Patient();
        patient.setPhoneNumber(phoneNumber);
        Example<Patient>example = Example.of(patient); // find by criteria
        Optional<Patient> patientOpt =  patientRepository.findOne(example);
        if(patientOpt.isPresent()){
            for(Diagnosis diagnosis: patient.getDiagnoses()){
                diagnosisList.add(diagnosis);
            }
        }

        return diagnosisList;
    }
}
