package hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "working_times")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WorkingTime {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "working_time_gen")
    @SequenceGenerator(
            name = "working_time_gen",
            sequenceName = "working_time_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "lunch_time")
    private LocalTime lunchTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
