package com.epatient.manage.service;

import com.epatient.manage.model.Diagnosis;
import com.epatient.manage.repository.DiagnosisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

/**
 * EPatient starter class
 * Author: Maiara Karla
 * Created on : 10/12/2022
 */
@ExtendWith(MockitoExtension.class)
public class DiagnosisServiceTest {

    @InjectMocks
    private DiagnosisServiceImpl service;

    @Mock
    private DiagnosisRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Diagnosis diagnosis = new Diagnosis(1, "feaver");
        doReturn(Optional.of(diagnosis)).when(repository).findById(1);

        // Execute the service call
        Diagnosis returnedDiagnosis = service.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedDiagnosis != null, "Diagnosis was not found");
    }

}
