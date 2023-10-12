package hospital.service.impl;

import hospital.entity.Person;
import hospital.repository.PersonRepository;
import hospital.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        Person person = personRepository.findById(id).get();
        return person;
    }

    @Override
    public void updatePerson(Long id, Person person) {

        Person person1 = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id: " + id + " not found!"));
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setEmail(person.getEmail());
        person1.setPhoneNumber(person.getPhoneNumber());
        person1.setDateOfBirth(person.getDateOfBirth());

        personRepository.save(person1);

    }

    @Override
    public String deletePersonById(Long id) {
        personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id: " + id + " not found!"));

        personRepository.deleteById(id);
        return "Person with id: " + id + " successfully deleted!";
    }
}
