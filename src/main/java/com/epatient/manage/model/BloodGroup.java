package com.epatient.manage.model;

/**
 * Blood groups
 * Author: Maiara Karla
 * Created on : 03/12/2022
 */
public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");
    private final String value;

    private BloodGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
