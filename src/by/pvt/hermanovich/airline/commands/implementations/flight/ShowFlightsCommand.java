package by.pvt.hermanovich.airline.commands.implementations.flight;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.FlightService;
import by.pvt.hermanovich.airline.entities.Flight;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Description: This class describes actions to show all flights from database table.
 *
 * Created by Yauheni Hermanovich on 21.07.2017.
 */
public class ShowFlightsCommand implements BasicCommand {
    private static final Logger logger = Logger.getLogger(ShowFlightsCommand.class);

    /**
     * The describes workflow of the actions to show all flights for the client on the client's page.
     * The method workflow has the following steps:
     *      - a map of search conditions with corresponding values is filled from request;
     *      -
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Flight> flightsList = null;
        HashMap<String, String> searchConditions = new HashMap<>();
        searchConditions = RequestParameterIdentifier.getFlightInfoFromRequest(searchConditions, request);
        try {
            flightsList = FlightService.getInstance().identifySearchContext(searchConditions);
            request.getSession().setAttribute(Parameters.FLIGHTS_LIST, flightsList);
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.FLIGHTS_PAGE_PATH);
        } catch (SQLException e) {
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}