package hospital.service.impl;

import hospital.entity.Doctor;
import hospital.entity.Person;
import hospital.entity.WorkingTime;
import hospital.mapper.DoctorMapper;
import hospital.repository.DoctorRepository;
import hospital.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).get();
        return doctor;
    }

    @Override
    public void updateDoctor(Long id, Doctor doctor) {
        Doctor doctor1 = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor with id: " + id + " not found!"));

        doctor1.setPerson(new Person());
        doctor1.setDoctorType(doctor.getDoctorType());
        doctor1.setExperience(doctor.getExperience());
        doctor1.setWorkingTime(new WorkingTime());

        doctorRepository.save(doctor);
    }

    @Override
    public String deleteDoctorById(Long id) {
        doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor with id: " + id + " not found!"));

        doctorRepository.deleteById(id);
        return "Doctor with id: " + id + " successfully deleted!";
    }
}
