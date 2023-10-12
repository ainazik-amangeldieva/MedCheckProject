package hospital.service.impl;

import hospital.dto.RegistrationDto;
import hospital.entity.Person;
import hospital.entity.Role;
import hospital.entity.User;
import hospital.repository.PersonRepository;
import hospital.repository.RoleRepository;
import hospital.repository.UserRepository;
import hospital.service.AuthenticationService;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;


    @Override
    public User patientSignUp(RegistrationDto registrationDto) {


        if (userRepository
                .existsByUserName(registrationDto.getUserName())) {
            throw new EntityExistsException(String.format(
                    "User with email: %s already exists!", registrationDto.getUserName()));
        }

        if (registrationDto.getConfirmPassword() != registrationDto.getPassword())
            throw new RuntimeException("Paroli ne sovpadaiut");


        Person person = new Person();
        person.setFirstName(registrationDto.getFirstName());
        person.setLastName(registrationDto.getLastName());
        person.setPhoneNumber(registrationDto.getPhoneNumber());
        person.setEmail(registrationDto.getEmail());
        person.setDateOfBirth(registrationDto.getDateOfBirth());

        personRepository.save(person);

        Role patientRole = roleRepository.getReferenceById(3l);

        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setPerson(person);
        user.setRoles(Arrays.asList(patientRole));

        userRepository.save(user);

        return user;
    }

    @Override
    public void signIn(User user) {

       User user1 = (User) userRepository.getUserByUserName(user.getUserName())
                .orElseThrow(() -> new NoSuchElementException
                        ("User with username:" + user.getUserName() + " not found!"));


        if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Incorrect password!");
        }

    }
}
