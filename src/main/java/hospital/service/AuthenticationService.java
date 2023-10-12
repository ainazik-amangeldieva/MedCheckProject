package hospital.service;

import hospital.dto.RegistrationDto;
import hospital.entity.User;

public interface AuthenticationService {

    User patientSignUp(RegistrationDto registrationDto);

    void signIn(User user);
}
