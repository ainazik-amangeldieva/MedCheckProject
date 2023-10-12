package hospital.service;

import hospital.entity.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);

    List<Person> getAllPeople();

    Person getPersonById(Long id);

    void updatePerson(Long id, Person person);

    String deletePersonById(Long id);
}
