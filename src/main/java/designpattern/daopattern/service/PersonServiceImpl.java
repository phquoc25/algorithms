package designpattern.daopattern.service;

import designpattern.daopattern.entity.Person;

import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    @Override
    public Optional<Person> create(Person person) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> update(Person person) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
