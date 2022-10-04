package com.Shashwat.Softnerve.DTO;

public class PatientResponse {
    public int id;
    public String patientName;
    public String patientPhoneNo;

    public PatientResponse(int id, String patientName, String patientPhoneNo) {
        this.id = id;
        this.patientName = patientName;
        this.patientPhoneNo = patientPhoneNo;
    }
}
