package hospital.service;

import hospital.dto.DoctorDto;
import hospital.entity.Doctor;

import java.util.List;

public interface DoctorService {

    void addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    void updateDoctor(Long id, Doctor doctor);

    String deleteDoctorById(Long id);
}
