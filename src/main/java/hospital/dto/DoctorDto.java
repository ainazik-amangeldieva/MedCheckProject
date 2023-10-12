package hospital.dto;

import hospital.entity.DoctorType;
import hospital.entity.WorkingTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DoctorDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private int experience;

    private DoctorType doctorType;

    private WorkingTime workingTime;



}