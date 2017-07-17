package by.pvt.hermanovich.airline.dao;

import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.exceptions.DAOException;

import java.sql.Connection;

/**
 * Description: This interface describes methods for working with <i>luggage</i> database table,
 * extending the capabilities of basic DAO interface.
 *
 * Created by Yauheni Hermanovich on 13.07.2017.
 */
public interface ImplLuggageDAO extends AbstractDAO<Luggage> {

    /**
     * This method reads data from <i>users</i> database table, creates and returns User object according to the entered id.
     *
     * @param luggageType   - entered <i>type of the luggage</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - Luggage object.
     */
    Luggage getByType(String luggageType, Connection connection) throws DAOException;

    /**
     * This method deletes an existing record (row) in a database table.
     *
     * @param id            - entered <i>id</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     */
    void deleteById(int id, Connection connection) throws DAOException;

    /**
     * This method check the uniqueness of the user.
     *
     * @param luggageType   - entered <i>type of the luggage</i>.
     * @param connection    - the current connection to a database. Transmitted from the service module to provide transactions.
     * @return              - boolean value of the condition:
     *                          returns "false" if the incoming data correspond to the record of the database table;
     *                          returns "true" if the incoming data do not correspond to the record of the database table.
     * @throws DAOException
     */
    boolean checkUniqueLuggage(String luggageType, Connection connection) throws DAOException;
}
