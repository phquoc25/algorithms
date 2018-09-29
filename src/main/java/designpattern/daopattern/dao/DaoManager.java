package designpattern.daopattern.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoManager {
    interface DaoCommand {
        Object execute(DaoManager daoManager);
    }

    private Connection connection;

    private PersonDao personDao;
    private VehicleDao vehicleDao;

    public DaoManager(Connection connection) {
        this.connection = connection;
    }

    public PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDaoImpl(connection);
        }
        return personDao;
    }

    public VehicleDao getVehicleDao() {
        if (vehicleDao == null) {
            vehicleDao = new VehicleDaoImpl(connection);
        }
        return vehicleDao;
    }

    public Object executeAndClose(DaoCommand daoCommand) {
        try {
            return daoCommand.execute(this);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object transaction(DaoCommand daoCommand) throws SQLException {
        try {
            this.connection.setAutoCommit(false);
            Object result = daoCommand.execute(this);
            this.connection.commit();
            return result;
        } catch (Exception e) {
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            try {
                this.connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
