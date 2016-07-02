package ch.keepcalm.web.controller;

import ch.keepcalm.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcel Widmer on 20.06.2016.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private PersonService personService;


    /**
     * TODO refactore
     * @return HATEOAS
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PersonAndLink> listAll() {
        return personService.listAll();
    }



}
