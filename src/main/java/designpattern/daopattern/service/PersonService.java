package designpattern.daopattern.service;

import designpattern.daopattern.entity.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> create(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> update(Person person);
    void delete(Long id);
}
