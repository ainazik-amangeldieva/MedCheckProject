package hospital.mapper;

import hospital.dto.DoctorDto;
import hospital.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {


    public Person toPerson(DoctorDto dto){
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());
        person.setPhoneNumber(dto.getPhoneNumber());
        return person;
    }

}
