package hospital.mapper;

import hospital.dto.DoctorDto;
import hospital.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapper {

    @Autowired
    private PersonMapper personMapper;

    public Doctor toDoctor(DoctorDto dto) {

        Doctor doctor = new Doctor();
        doctor.setDoctorType(dto.getDoctorType());
        doctor.setPerson(personMapper.toPerson(dto));
        doctor.setDoctorType(dto.getDoctorType());
        return doctor;
    }

}
