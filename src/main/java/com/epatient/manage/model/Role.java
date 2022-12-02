package com.epatient.manage.model;

public enum Role {
    ADMIN("Admin"),
    DOCTOR("Doctor"),
    LAB_ASSISTANT("Lab Assistant"),
    NURSE("Nurse"),
    PATIENT("Patient"),
    RECEPTIONIST("Receptionist");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
