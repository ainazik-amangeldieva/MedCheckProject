package hospital.service.impl;

import hospital.entity.DoctorType;
import hospital.repository.DoctorTypeRepository;
import hospital.service.DoctorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorTypeServiceImpl implements DoctorTypeService {

    private final DoctorTypeRepository doctorTypeRepository;

    @Override
    public void createDoctorType(DoctorType doctorType) {
        doctorTypeRepository.save(doctorType);
    }
}
