package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.Airport;
import by.pvt.hermanovich.airline.exceptions.DAOExceptiion;

import java.sql.Connection;

/**
 * Description: The interface describes methods for working with <i>airports</i> database table,
 * extending the capabilities of basic DAO interface.
 *
 * Created by Yauheni Hermanovich on 13.07.2017.
 */
public interface ImplAirportDAO extends AbstractDAO<Airport> {

    /**
     * This method reads data from <i>airportss</i> database table, creates and returns Airport object
     * according to the entered airport code.
     *
     * @param airportCode        - an entered airport code.
     * @param connection         - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return                   - Airport object.
     */
    Airport getByCode(String airportCode, Connection connection) throws DAOExceptiion;

    /**
     * This method deletes an existing airport in a database table according to the airport code.
     *
     * @param airportCode        - an entered airport code.
     * @param connection         - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void deleteByCode(String airportCode, Connection connection) throws DAOExceptiion;
}
