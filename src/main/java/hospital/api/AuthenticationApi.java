package hospital.api;

import hospital.dto.RegistrationDto;
import hospital.entity.User;
import hospital.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user") @Valid @RequestBody RegistrationDto registrationDto) {
        authenticationService.patientSignUp(registrationDto);
        return "registration/registration";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute("user") @Valid @RequestBody User user) {
        authenticationService.signIn(user);
        return "logInPage/logInPage";
    }

    @GetMapping("/signUp")
    public String toSignUp(Model model){
        model.addAttribute("user", new RegistrationDto());
        return "registration/registration";
    }


    @GetMapping("/signIn")
    public String toSignIn(Model model){
        model.addAttribute("user", new User());
        return "logInPage/logInPage";
    }


}
