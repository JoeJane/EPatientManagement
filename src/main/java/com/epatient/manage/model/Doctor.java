package com.epatient.manage.model;

import javax.persistence.*;
import java.util.List;

/**
 * Doctor entity
 * Author: Jane Aarthy,
 * Created on : 03/12/2022
 */
@Entity
@Table(name = "doctor")
public class Doctor extends User {

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "speciality")
    private DoctorSpeciality speciality;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Patient> patients;

    public DoctorSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpeciality speciality) {
        this.speciality = speciality;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
