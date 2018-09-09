package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Person;

import java.sql.*;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {
    private static final String INSERT_STATEMENT = "INSERT INTO person (" + Column.FIRST_NAME + ", " + Column.LAST_NAME + ", " + Column.AGE + ", " + Column.NB_OF_VEHICLES + ") values (?, ?, ?, ?)";
    private static final String DELETE_STATEMENT = "DELETE FROM person where id=?";
    private static final String SELECT_BY_ID = "SELECT * from person where id=?";
    private static final String UPDATE_STATEMENT = "UPDATE person set " + Column.FIRST_NAME + "=?, " + Column.LAST_NAME + "=?, " + Column.AGE + "=?, " + Column.NB_OF_VEHICLES + "=? where id=?";

    enum Column {
        ID,
        FIRST_NAME,
        LAST_NAME,
        AGE,
        NB_OF_VEHICLES
    }
    private Connection connection;

    public PersonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Person> save(Person person) throws SQLException {
        Long id = person.getId();
        if (id == null || !isExistingPerson(id)) {
            return createPerson(person);
        } else {
            return updatePerson(person);
        }
    }

    private boolean isExistingPerson(Long id) throws SQLException {
        try (PreparedStatement selectStatement = connection.prepareStatement(SELECT_BY_ID)) {
            selectStatement.setLong(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            return resultSet.next();
        }
    }

    private Optional<Person> createPerson(Person person) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getNbOfVehicle());
            int result = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (result == 1 && generatedKeys.next()) {
                person.setId(generatedKeys.getLong(1));
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    private Optional<Person> updatePerson(Person person) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getNbOfVehicle());
            preparedStatement.setLong(5, person.getId());
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> findById(Long id) throws SQLException {
        try (PreparedStatement selectStatement = connection.prepareStatement(SELECT_BY_ID)) {
            selectStatement.setLong(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(transformToPerson(resultSet));
            }
        }
        return Optional.empty();
    }

    private Person transformToPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong(Column.ID.name()));
        person.setFirstName(resultSet.getString(Column.FIRST_NAME.name()));
        person.setLastName(resultSet.getString(Column.LAST_NAME.name()));
        person.setAge(resultSet.getInt(Column.AGE.name()));
        person.setNbOfVehicle(resultSet.getInt(Column.NB_OF_VEHICLES.name()));
        return person;
    }

    @Override
    public void delete(Long id) throws SQLException {
        try (PreparedStatement deleteStatement = connection.prepareStatement(DELETE_STATEMENT)) {
            deleteStatement.setLong(1, id);
            deleteStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root");

            createPerson(connection);
//            deletePerson(connection, 1L);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createPerson(Connection connection) throws SQLException {
        PersonDao personDao = new PersonDaoImpl(connection);
        Person person = new Person();
        person.setId(5L);
        person.setFirstName("Ho Quoc");
        person.setLastName("PHAN");
        person.setAge(30);
        person.setNbOfVehicle(0);

        Optional<Person> personCreated = personDao.save(person);
        personCreated.ifPresent(person1 -> System.out.println(person1.toString()));
    }

    private static void deletePerson(Connection connection, Long id) throws SQLException {
        PersonDao personDao = new PersonDaoImpl(connection);
        personDao.delete(id);
    }
}
