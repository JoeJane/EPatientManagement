package com.epatient.manage.util;

import com.epatient.manage.model.*;

/**
 * Utility class to convert User entity based on @ROle
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
public class Converter {

    /**
     * Convert users into target user based on @Role
     * @param user User entity
     * @return Target user
     */
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

    /**
     * Convert @User into @Doctor
     * @param user @User entity
     * @param doctor @Doctor entity
     * @return @Doctor entity
     */
    private static Doctor convertToDoctor(User user, Doctor doctor){
        doctor.setSpeciality(user.getSpeciality());
        return doctor;
    }

    /**
     * Convert @User into @Doctor
     * @param user @User entity
     * @param doctor @Doctor entity
     * @return @Doctor entity
     */
    private static LabAssistant convertToLabAssistant(User user, LabAssistant labAssistant){
        return (LabAssistant)labAssistant;
    }

    /**
     * Convert @User into @Nurse
     * @param user @User entity
     * @param nurse @Nurse entity
     * @return @Nurse entity
     */
    private static Nurse convertToNurse(User user, Nurse nurse){
        nurse.setNurseType(user.getNurseType());
        return nurse;
    }

    /**
     * Convert @User into @Patient
     * @param user @User entity
     * @param patient @Patient entity
     * @return @Patient entity
     */
    private static Patient convertToPatient(User user, Patient patient){
        patient.setBloodGroup(user.getBloodGroup());
        patient.setUpComingAppointment(user.getUpComingAppointment());
        patient.setEmergencyFirstName(user.getEmergencyFirstName());
        patient.setEmergencyLastName(user.getEmergencyLastName());
        patient.setEmergencyEmail(user.getEmergencyEmail());
        patient.setEmergencyPhone(user.getEmergencyPhone());

        return patient;
    }

    /**
     * Convert @User into @Receptionist
     * @param user @User entity
     * @param receptionist @Receptionist entity
     * @return @Receptionist entity
     */
    private static Receptionist convertToReceptionist(User user, Receptionist receptionist){
        return (Receptionist)receptionist;
    }
}
