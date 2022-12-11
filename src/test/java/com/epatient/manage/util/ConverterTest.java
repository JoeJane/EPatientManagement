package com.epatient.manage.util;

import com.epatient.manage.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * EPatient starter class
 * Author: Maiara Karla
 * Created on : 10/12/2022
 */
@ExtendWith(MockitoExtension.class)
public class ConverterTest {
    @Test
    @DisplayName("Test ConvertToUser to Nurse Success")
    void testConvertToNurseUser() {
        User nurseUser = new User(1, "nurse", "password", Role.NURSE);
        User convertedUser = Converter.convert(nurseUser);

        Assertions.assertTrue(convertedUser instanceof Nurse);
    }

    @Test
    @DisplayName("Test ConvertToUser to LabAssistant Success")
    void testConvertToLabAssistantUser() {
        User labAssistantUser = new User(1, "labassistant", "password", Role.LAB_ASSISTANT);
        User convertedUser = Converter.convert(labAssistantUser);

        Assertions.assertTrue(convertedUser instanceof LabAssistant);
    }

    @Test
    @DisplayName("Test ConvertToDoctorUser to Doctor Success")
    void testConvertToDoctorUser() {
        User doctorUser = new User(1, "doctor", "password", Role.DOCTOR);
        User convertedUser = Converter.convert(doctorUser);

        Assertions.assertTrue(convertedUser instanceof Doctor);
    }

    @Test
    @DisplayName("Test ConvertToReceptionistUser to Doctor Success")
    void testConvertToReceptionistUser() {
        User receptionistUser = new User(1, "receptionist", "password", Role.RECEPTIONIST);
        User convertedUser = Converter.convert(receptionistUser);

        Assertions.assertTrue(convertedUser instanceof Receptionist);
    }

    @Test
    @DisplayName("Test ConvertToPatientUser to Doctor Success")
    void testConvertToPatientUser() {
        User patientUser = new User(1, "patient", "password", Role.PATIENT);
        User convertedUser = Converter.convert(patientUser);

        Assertions.assertTrue(convertedUser instanceof Patient);
    }
}
