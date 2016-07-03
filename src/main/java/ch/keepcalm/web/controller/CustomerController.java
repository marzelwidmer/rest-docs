package ch.keepcalm.web.controller;

import ch.keepcalm.web.model.Person;
import ch.keepcalm.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcel Widmer on 20.06.2016.
 */
@RestController
@RequestMapping("/user")
public class CustomerController {


    @Autowired
    private PersonService personService;


    /**
     * TODO refactore
     * @return HATEOAS
     */
    @RequestMapping(value = "/{customer}", method = RequestMethod.GET)
    public List<PersonAndLink> listAll() {
        return personService.listAll();
    }

    @RequestMapping(value = "/{customer}/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Person> deleteUser(@PathVariable ("id") Long id) {
        personService.deleteUser(id);

        Person person = personService.findOnePerson(id);
        if (person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        personService.deleteUser(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);

    }


    @RequestMapping(value = "/{users}/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.findOnePerson(id);
    }

    @RequestMapping(value = "/{users}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person) {
        personService.saveOnePerson(new Person(person.getFirstName(), person.getLastName()));
    }

    @RequestMapping(value = "/{users}/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person existingPerson = personService.findOnePerson(id);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        personService.saveOnePerson(existingPerson);
    }


}
