package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Vehicle;

import java.util.Optional;

public interface VehicleDao {
    Optional<Vehicle> save(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    void delete(Long id);
}
