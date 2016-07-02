package ch.keepcalm.web.controller;

import ch.keepcalm.web.model.Person;
import ch.keepcalm.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hkesq on 20.06.2016.
 */
@RestController
@RequestMapping("/people")
public class PersonController  {


    @Autowired
    private PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Person> listPeople() {
        return personService.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person) {
        personService.save(new Person(person.getFirstName(), person.getLastName()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person existingPerson = personService.findOne(id);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        personService.save(existingPerson);
    }
}
