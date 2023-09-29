package hospital.dto;

import hospital.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String confirmPassword;

    private String email;

    private String phoneNumber;

    private List<Role> roles;

}
