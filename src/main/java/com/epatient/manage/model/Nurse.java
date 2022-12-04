package com.epatient.manage.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
public class Nurse extends User {
    @Enumerated(EnumType.STRING)
    private NurseType nurseType;

    @Override
    public NurseType getNurseType() {
        return nurseType;
    }

    @Override
    public void setNurseType(NurseType nurseType) {
        this.nurseType = nurseType;
    }
}
