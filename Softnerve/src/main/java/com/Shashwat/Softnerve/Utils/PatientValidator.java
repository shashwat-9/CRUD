package com.Shashwat.Softnerve.Utils;

import com.Shashwat.Softnerve.DTO.PatientResponse;

public class PatientValidator {

    public static boolean validateReq(PatientResponse patientResponse) {

        return patientResponse.patientName != null &&
                patientResponse.patientPhoneNo != null;
    }

    public static boolean validate(PatientResponse patientResponse) {

        return patientResponse.patientName != null &&
                patientResponse.id != 0 &&
                patientResponse.patientPhoneNo != null;

    }
}
