package hospital.api;

import hospital.dto.DoctorDto;
import hospital.mapper.DoctorMapper;
import hospital.service.DoctorService;
import hospital.service.DoctorTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("doctor")
@RequiredArgsConstructor
public class DoctorApi {

    private final DoctorService doctorService;
    private final DoctorTypeService doctorTypeService;
    private final DoctorMapper doctorMapper;

    @GetMapping("/add")
    public String addDoctor(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        model.addAttribute("doctorTypes", doctorTypeService);
        return "doctor/doctor";


    }

    @PostMapping("doctor/add")
    public String addDoctor(@ModelAttribute("doctor") @Valid @RequestBody DoctorDto doctorDto) {
        doctorService.addDoctor(doctorMapper.toDoctor(doctorDto));
        return "doctor/list";
    }

}
