package hospital.api;

import hospital.dto.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/doctors")
    public String toSignUp(Model model){
        model.addAttribute("user", new RegistrationDto());
        return "admin/doctors";
    }

    @GetMapping("/")
    public String dashboard(Model model){
        model.addAttribute("user", new RegistrationDto());
        return "admin/index";
    }
}
