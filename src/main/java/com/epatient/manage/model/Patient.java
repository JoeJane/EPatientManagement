package com.epatient.manage.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient extends User {

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Blood group is mandatory")
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;

    @Column(name = "upcoming_appointment", updatable = false)
    private LocalDateTime upComingAppointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @NotBlank(message = "Emergency first name cannot be empty")
    @Column(name = "emergency_first_name")
    private String emergencyFirstName;

    @NotBlank(message = "Emergency last name cannot be empty")
    @Column(name = "emergency_last_name")
    private String emergencyLastName;

    @NotBlank(message = "Emergency email cannot be empty")
    @Column(name = "emergency_email")
    private String emergencyEmail;

    @NotBlank(message = "Emergency phone number cannot be empty")
    @Column(name = "emergency_phone_number")
    private String emergencyPhone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<Diagnosis> diagnoses;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public LocalDateTime getUpComingAppointment() {
        return upComingAppointment;
    }

    public void setUpComingAppointment(LocalDateTime upComingAppointment) {
        this.upComingAppointment = upComingAppointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getEmergencyFirstName() {
        return emergencyFirstName;
    }

    public void setEmergencyFirstName(String emergencyFirstName) {
        this.emergencyFirstName = emergencyFirstName;
    }

    public String getEmergencyLastName() {
        return emergencyLastName;
    }

    public void setEmergencyLastName(String emergencyLastName) {
        this.emergencyLastName = emergencyLastName;
    }

    public String getEmergencyEmail() {
        return emergencyEmail;
    }

    public void setEmergencyEmail(String emergencyEmail) {
        this.emergencyEmail = emergencyEmail;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
