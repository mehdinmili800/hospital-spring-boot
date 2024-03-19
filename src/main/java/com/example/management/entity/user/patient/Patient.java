package com.example.management.entity.user.patient;

import com.example.management.entity.appointment.Appointment;
import com.example.management.entity.treatment.Treatment;
import com.example.management.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private User patient;




    private String patientName;
    private String patient_mobile;
    private String patient_email;
    private String patient_address;


    @JsonManagedReference
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();



    public Patient(User patient, String patientName,
                   String patient_mobile, String patient_email,
                   String patient_address) {
        this.patient = patient;
        this.patientName = patientName;
        this.patient_mobile = patient_mobile;
        this.patient_email = patient_email;
        this.patient_address = patient_address;
    }

    public Patient() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatient_mobile() {
        return patient_mobile;
    }

    public void setPatient_mobile(String patient_mobile) {
        this.patient_mobile = patient_mobile;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
