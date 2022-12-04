package com.epatient.manage.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String prescriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="diagnosis_id")
    Diagnosis diagnosis;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
