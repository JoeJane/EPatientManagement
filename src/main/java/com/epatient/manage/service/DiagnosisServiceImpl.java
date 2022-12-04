package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public Diagnosis findById(Integer id){
        return diagnosisRepository.findById(id).get();
    }
}
