package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Person;

import java.util.Optional;

public interface PersonDao {
    Optional<Person> save(Person person);
    Optional<Person> findById(Long id);
    void delete(Long id);
}
