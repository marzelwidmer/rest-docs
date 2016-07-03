package ch.keepcalm.web.repository;

import ch.keepcalm.web.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Marcel Widmer on 20.06.2016.
 */
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
}
