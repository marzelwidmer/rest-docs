package ch.keepcalm.web.controller;

import ch.keepcalm.web.model.Person;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

// tag::PersonAndLinks[]

/**
 * Created by marcelwidmer on 02/07/16.
 * TODO refactore
 */
public class PersonAndLink {

    private final Person person;
    private final Link link;


    public PersonAndLink(Person person) {
        this.person = person;
        this.link = ControllerLinkBuilder.linkTo(methodOn(PersonController.class).getPerson(person.getId()))
                .withRel(person.getId().toString());
    }

    public Person getPerson(){
        return person;
    }
    public Link getLink(){
        return link;
    }
}
// end::PersonAndLinks[]


