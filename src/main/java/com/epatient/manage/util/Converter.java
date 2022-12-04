package com.epatient.manage.util;

import com.epatient.manage.model.*;

public class Converter {
    public static User convert(User user){
        User newUser;
        if(user.getRole() == Role.DOCTOR) {
            newUser = convertToDoctor(user, new Doctor());
        } else if(user.getRole() == Role.LAB_ASSISTANT) {
            newUser = convertToLabAssistant(user, new LabAssistant());
        } else if(user.getRole() == Role.NURSE) {
            newUser = convertToNurse(user, new Nurse());
        } else if(user.getRole() == Role.PATIENT) {
            newUser = convertToPatient(user, new Patient());
        } else if(user.getRole() == Role.RECEPTIONIST) {
            newUser = convertToReceptionist(user, new Receptionist());
        } else {
            newUser = user;
        }

        newUser.setUserId(user.getUserId());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setConfirmPassword(user.getConfirmPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAddress(user.getAddress());
        newUser.setAddressNo(user.getAddressNo());
        newUser.setCity(user.getCity());
        newUser.setPostalCode(user.getPostalCode());
        newUser.setProvince(user.getProvince());
        newUser.setCountry(user.getCountry());
        newUser.setGender(user.getGender());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setDeleted(user.getDeleted());
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setRole(user.getRole());

        return newUser;
    }

    private static Doctor convertToDoctor(User user, Doctor doctor){
        doctor.setSpeciality(user.getSpeciality());
        return doctor;
    }

    private static LabAssistant convertToLabAssistant(User user, LabAssistant labAssistant){
        return (LabAssistant)labAssistant;
    }

    private static Nurse convertToNurse(User user, Nurse nurse){
        nurse.setNurseType(user.getNurseType());
        return nurse;
    }

    private static Patient convertToPatient(User user, Patient patient){
        patient.setBloodGroup(user.getBloodGroup());
        patient.setUpComingAppointment(user.getUpComingAppointment());
        patient.setEmergencyFirstName(user.getEmergencyFirstName());
        patient.setEmergencyLastName(user.getEmergencyLastName());
        patient.setEmergencyEmail(user.getEmergencyEmail());
        patient.setEmergencyPhone(user.getEmergencyPhone());

        return patient;
    }

    private static Receptionist convertToReceptionist(User user, Receptionist receptionist){
        return (Receptionist)receptionist;
    }
}
