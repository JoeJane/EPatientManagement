package com.epatient.manage.model;

public enum DoctorSpeciality {
    ANESTHESIOLOGISTS("Anesthesiologists"),
    CARDIOLOGISTS("Cardiologists"),
    COLON_AND_RECTAL_SURGEONS("Colon and Rectal Surgeons"),
    CRITICAL_CARE_MEDICINE_SPECIALISTS("Critical Care Medicine Specialists"),
    DERMATOLOGISTS("Dermatologists"),
    ENDOCRINOLOGISTS("Endocrinologists"),
    EMERGENCY_MEDICINE_SPECIALISTS("Emergency Medicine Specialists"),
    FAMILY_PHYSICIANS("Family Physicians"),
    GASTROENTEROLOGISTS("Gastroenterologists"),
    NEUROLOGISTS("Neurologists"),
    PEDIATRICIANS("Pediatricians"),
    PHYSIATRISTS("Physiatrists");

    private final String value;

    private DoctorSpeciality(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
