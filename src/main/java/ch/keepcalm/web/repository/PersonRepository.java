package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hkesq on 20.06.2016.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
