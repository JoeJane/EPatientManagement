package com.epatient.manage.model;

public enum NurseType {
    INTENSIVE_CARE_NURSE("Intensive Care Nurse"),
    MIDWIFE("Mid Wife"),
    PRACTITIONER_NURSE("Nurse Practitioner"),
    HEALTH_NURSE("Health Nurse"),
    ONCOLOGY_NURSE("Oncology Nurse"),
    PALLIATIVE_CARE_NURSE("Palliative Care Nurse"),
    OCCUPATIONAL_HEALTH_NURSE("Occupational Health Nurse");

    private final String value;

    private NurseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
