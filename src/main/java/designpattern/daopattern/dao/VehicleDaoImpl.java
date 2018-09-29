package designpattern.daopattern.dao;

import designpattern.daopattern.entity.Vehicle;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {
    private static final String TABLE = "vehicle";
    private static final String INSERT_STATEMENT = "INSERT INTO " + TABLE + " (" + Column.OWNER_ID + ", " + Column.MAKE + ", " + Column.MODEL + ") values (?, ?, ?)";
    private static final String DELETE_STATEMENT = "DELETE FROM " + TABLE + " where id=?";
    private static final String SELECT_BY_ID = "SELECT * from " + TABLE + " where id=?";
    private static final String UPDATE_STATEMENT = "UPDATE " + TABLE + " set " + Column.OWNER_ID + "=?, " + Column.MAKE + "=?, " + Column.MODEL + "=? where id=?";
    enum Column {
        ID,
        OWNER_ID,
        MAKE,
        MODEL
    }
    private Connection connection;

    public VehicleDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Vehicle> save(Vehicle vehicle) throws SQLException {
        Long id = vehicle.getId();
        if (id == null || !isExistingVehicle(id)) {
            return createVehicle(vehicle);
        } else {
            return updateVehicle(vehicle);
        }
    }

    private Optional<Vehicle> updateVehicle(Vehicle vehicle) throws SQLException {
        try (PreparedStatement updateStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
            updateStatement.setLong(1, vehicle.getOwnerId());
            updateStatement.setString(2, vehicle.getMake());
            updateStatement.setString(3, vehicle.getModel());
            updateStatement.setLong(4, vehicle.getId());
            int result = updateStatement.executeUpdate();
            if (result == 1) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    private Optional<Vehicle> createVehicle(Vehicle vehicle) throws SQLException {
        try (PreparedStatement insertStatement = connection.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setLong(1, vehicle.getOwnerId());
            insertStatement.setString(2, vehicle.getMake());
            insertStatement.setString(3, vehicle.getModel());
            int result = insertStatement.executeUpdate();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if (result == 1 && generatedKeys.next()) {
                vehicle.setId(generatedKeys.getLong(1));
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    private boolean isExistingVehicle(Long id) throws SQLException {
        try (PreparedStatement selectStatement = connection.prepareStatement(SELECT_BY_ID)) {
            selectStatement.setLong(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public Optional<Vehicle> findById(Long id) throws SQLException {
        try (PreparedStatement selectStatement = connection.prepareStatement(SELECT_BY_ID)) {
            selectStatement.setLong(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(transformToVehicle(resultSet));
            }
        }
        return Optional.empty();
    }

    private Vehicle transformToVehicle(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(resultSet.getLong(Column.ID.name()));
        vehicle.setOwnerId(resultSet.getLong(Column.OWNER_ID.name()));
        vehicle.setMake(resultSet.getString(Column.MAKE.name()));
        vehicle.setModel(resultSet.getString(Column.MODEL.name()));
        return vehicle;
    }

    @Override
    public void delete(Long id) throws SQLException {
        try (PreparedStatement deleteStatement = connection.prepareStatement(DELETE_STATEMENT)) {
            deleteStatement.setLong(1, id);
            deleteStatement.executeUpdate();
        }
    }
}
