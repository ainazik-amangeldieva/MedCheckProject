package hospital.service.impl;

import hospital.entity.WorkingTime;
import hospital.repository.WorkingTimeRepository;
import hospital.service.WorkingTimeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor

public class WorkingTimeServiceImpl implements WorkingTimeService {

    private final WorkingTimeRepository workingTimeRepository;

    @Override
    public void addWorkingTime(WorkingTime workingTime) {
        workingTimeRepository.save(workingTime);
    }
}
