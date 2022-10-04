package com.Shashwat.Softnerve.Repository;

import com.Shashwat.Softnerve.Models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, Integer> {

    List<Patient> findByPatientName(String name);

    Patient findTopByOrderByIdDesc();
    void deleteById(int id);

    boolean existsById(int id);
}
