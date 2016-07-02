package ch.keepcalm.web.service;

import ch.keepcalm.web.model.Person;
import ch.keepcalm.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcelwidmer on 02/07/16.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAllPersons() {
       return personRepository.findAll();
    }

    public Person findOnePerson(Long id) {
        return personRepository.findOne(id);
    }

    public void saveOnePerson(Person person) {
        personRepository.save(person);
    }
}
