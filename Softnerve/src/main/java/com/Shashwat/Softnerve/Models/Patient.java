package com.Shashwat.Softnerve.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {
    @Id
    private int id;
    private String patientName;
    private String patientContactNo;

    public Patient() {
    }

    public Patient(int id, String patientName, String patientContactNo) {
        this.id = id;
        this.patientName = patientName;
        this.patientContactNo = patientContactNo;
    }

    public Patient(String patientName, String patientContactNo) {
        this.id = 0;
        this.patientName = patientName;
        this.patientContactNo = patientContactNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContactNo() {
        return patientContactNo;
    }

    public void setPatientContactNo(String patientContactNo) {
        this.patientContactNo = patientContactNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
