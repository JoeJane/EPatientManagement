package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;

/**
 * Service for Diagnosis entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
public interface DiagnosisService {
    public Diagnosis findById(Integer id);

    void editDiagnoses(Integer patientId, Diagnosis diagnosis);
}
