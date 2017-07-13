package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.Aircraft;
import by.pvt.hermanovich.airline.exceptions.DAOExceptiion;
import java.sql.Connection;

/**
 * Description: The interface describes methods for working with <i>aircrafts</i> database table,
 * extending the capabilities of basic DAO interface.
 *
 * Created by Yauheni Hermanovich on 13.07.2017.
 */
public interface ImplAircraftDAO extends AbstractDAO<Aircraft> {

    /**
     * This method reads data from <i>aircrafts</i> database table, creates and returns Aircraft object
     * according to the entered aircraft code, called hull No.
     *
     * @param aicraftCode   - an entered aircraft code, called hull No.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - Aircraft object.
     */
    Aircraft getByCode(String aicraftCode, Connection connection) throws DAOExceptiion;

    /**
     * This method deletes an existing record (row) in a database table.
     *
     * @param aircraftCode      - aircraft code which will be used for deleting aircraft.
     * @param connection        - the current connection to a database. Transmitted from the service module to provide transactions.
     * @throws DAOExceptiion
     */
    void deleteAircraftByCode(String aircraftCode, Connection connection) throws DAOExceptiion;
}
