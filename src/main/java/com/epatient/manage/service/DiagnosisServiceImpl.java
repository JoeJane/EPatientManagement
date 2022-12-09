package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation for @DiagnosisService entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    /**
     * Get @Diagnosis based on id
     * @param id user ID
     * @return Diagnosis
     */
    public Diagnosis findById(Integer id){
        return diagnosisRepository.findById(id).get();
    }
}
