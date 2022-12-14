package com.epatient.manage.model;

/**
 * Provinces
 * Author: Maiara Karla
 * Created on : 03/12/2022
 */
public enum Province {

    AB("Alberta"),
    BC("British Columbia"),
    MB("Manitoba"),
    NB("New Brunswick"),
    NL("Newfoundland"),
    NT("Northwest Territories"),
    NS("Nova Scotia"),
    NU("Nunavut"),
    ON("Ontario"),
    PE("Prince Edward Island"),
    QC("Quebec"),
    SK("Saskatchewan"),
    YT("Yukon");

    private final String value;

    private Province(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
