package hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DoctorType {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_type_gen")
    @SequenceGenerator(
            name = "doctor_type_gen",
            sequenceName = "doctor_type_seq",
            allocationSize = 1)

    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
