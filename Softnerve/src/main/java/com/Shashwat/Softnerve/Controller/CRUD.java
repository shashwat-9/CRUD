package com.Shashwat.Softnerve.Controller;

import com.Shashwat.Softnerve.DTO.PatientResponse;
import com.Shashwat.Softnerve.Models.Patient;
import com.Shashwat.Softnerve.Repository.PatientRepository;
import com.Shashwat.Softnerve.Utils.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CRUD {

    @Autowired
    private PatientRepository repository;

    @GetMapping("/")
    public String hello() {
        
        return "Hello\nAPI(s)\n1. readAll\n2. readByName (Request Param arg -> name)\n3. add(RequestBody arg -> Json as specified in the assignment)"
             + "\n4.update (RequestBody arg -> JSON with all the details and the id of the document to be changed) \n 5. delete (RequestParam arg -> id of document)";
    }
    
    @GetMapping("/readAll")
    public List<Patient> readAll() {
        return repository.findAll();
    }

    @GetMapping("/readByName")
    public List<Patient> readByName(@RequestParam String name) {
        List<Patient> list = new ArrayList<>();

        list = repository.findByPatientName(name);

        return list;
    }

    @PostMapping("/add")
    public String add(@RequestBody PatientResponse patientResponse) {
        Patient patient;
        if (PatientValidator.validateReq(patientResponse)) {

            //next id is id + 1
            Patient topP = repository.findTopByOrderByIdDesc();
            int id = topP == null? 0: topP.getId();

            patient = new Patient((id + 1),patientResponse.patientName, patientResponse.patientPhoneNo);
            repository.save(patient);

            return "SUCCESS";
        }  else {
            return "Document Invalid";
        }
    }

    //provide the full document along with req id
    @PutMapping("/update")
    public String update(@RequestBody PatientResponse patientResponse) {

        Patient patient;
        if (PatientValidator.validate(patientResponse)) {
            if (repository.existsById(patientResponse.id))  {
                patient = new Patient(patientResponse.id, patientResponse.patientName,
                        patientResponse.patientPhoneNo);
                repository.save(patient);
                return "Updated Successfully";
            }   else return "Invalid ID in Document";
        }

        return "Invalid Document";
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        repository.deleteById(id);
    }
}
