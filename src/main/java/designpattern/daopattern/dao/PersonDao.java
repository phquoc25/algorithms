package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Person;

import java.sql.SQLException;
import java.util.Optional;

public interface PersonDao {
    Optional<Person> save(Person person) throws SQLException;
    Optional<Person> findById(Long id) throws SQLException;
    void delete(Long id) throws SQLException;
}
