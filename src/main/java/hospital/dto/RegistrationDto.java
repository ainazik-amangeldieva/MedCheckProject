package hospital.dto;

import hospital.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDto {

    @NotEmpty(message = "first name should not me empty!")
    @Size(min = 2,max = 50, message = "min 2,max 50 symbols")
    private String firstName;

    @NotEmpty(message = "last name should not me empty!")
    @Size(min = 2,max = 50, message = "min 2,max 50 symbols")
    private String lastName;

    @NotEmpty(message = "username should not me empty!")
    @Size(min = 2,max = 50, message = "min 2,max 50 symbols")
    private String userName;

    @NotEmpty(message = "password should not me empty!")
    @Size(min = 8,max = 50, message = "min 8,max 50 symbols")
    private String password;

    @NotEmpty(message = "enter your password again!")
    private String confirmPassword;

    @NotEmpty(message = "date of birth should not be empty!")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "email should not be empty!")
    @Email(message = "email should be valid!")
    private String email;


    @Pattern(regexp = "\\(\\+996\\)\\d{9}",message = "wrong format!")
    private String phoneNumber;

    private List<Role> roles;

}
