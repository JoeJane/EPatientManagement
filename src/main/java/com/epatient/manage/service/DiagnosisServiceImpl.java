package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.model.Patient;
import com.epatient.manage.repository.DiagnosisRepository;
import com.epatient.manage.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation for @DiagnosisService entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    private PatientRepository patientRepository;
    private DiagnosisRepository diagnosisRepository;

    public DiagnosisServiceImpl(@Autowired PatientRepository patientRepository,
                                @Autowired DiagnosisRepository diagnosisRepository){
        this.patientRepository = patientRepository;
    }

    /**
     * Get @Diagnosis based on id
     * @param id user ID
     * @return Diagnosis
     */
    public Diagnosis findById(Integer id){
        return diagnosisRepository.findById(id).get();
    }

    @Override
    public void editDiagnoses(Integer patientId, Diagnosis diagnosis) {
        Optional<Patient> patientOpt =  patientRepository.findById(patientId);
        if(patientOpt.isPresent()){
            for(Diagnosis diagnosis2: patientOpt.get().getDiagnoses()){
                if(diagnosis2.getId().equals(diagnosis.getId())){
                    diagnosisRepository.save(diagnosis);
                }
            }
        }
    }
}
