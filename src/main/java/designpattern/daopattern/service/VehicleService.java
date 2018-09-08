package designpattern.daopattern.service;

import designpattern.daopattern.entity.Person;
import designpattern.daopattern.entity.Vehicle;

import java.util.Optional;

public interface VehicleService {
    Optional<Vehicle> create(Vehicle vehicle);
    Optional<Vehicle> findById(Long id);
    Optional<Vehicle> update(Vehicle vehicle);
    void delete(Long id);
}
