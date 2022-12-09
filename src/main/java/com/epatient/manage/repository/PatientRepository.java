package com.epatient.manage.repository;

import com.epatient.manage.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Patient entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
