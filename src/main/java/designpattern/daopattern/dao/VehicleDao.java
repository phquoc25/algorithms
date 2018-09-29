package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Vehicle;

import java.sql.SQLException;
import java.util.Optional;

public interface VehicleDao {
    Optional<Vehicle> save(Vehicle vehicle) throws SQLException;
    Optional<Vehicle> findById(Long id) throws SQLException;
    void delete(Long id) throws SQLException;
}
