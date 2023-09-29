package hospital.entity;
import lombok.*;

@Entity
@Table(name="doctor_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DcotorType {

    private Long id;

    private String name;

}
