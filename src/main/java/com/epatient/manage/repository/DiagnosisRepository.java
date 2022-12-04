package com.epatient.manage.repository;

import com.epatient.manage.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    Optional<Diagnosis> findById(Integer id);
}
