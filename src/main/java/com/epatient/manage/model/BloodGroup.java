package com.epatient.manage.model;

public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("0-");
    private final String value;

    private BloodGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
