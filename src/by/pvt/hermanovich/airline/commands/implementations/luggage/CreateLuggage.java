package by.pvt.hermanovich.airline.commands.implementations.luggage;

import by.pvt.hermanovich.airline.commands.BasicCommand;
import by.pvt.hermanovich.airline.constants.MessageConstants;
import by.pvt.hermanovich.airline.constants.Parameters;
import by.pvt.hermanovich.airline.constants.PathPageConstants;
import by.pvt.hermanovich.airline.dao.services.LuggageService;
import by.pvt.hermanovich.airline.entities.Luggage;
import by.pvt.hermanovich.airline.managers.ConfigManagerPages;
import by.pvt.hermanovich.airline.utils.controllerUtils.RequestParameterIdentifier;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Description: This class describes operation of creation a luggage.
 *
 * Created by Yauheni Hermanovich on 17.07.2017.
 */
public class CreateLuggage implements BasicCommand {
    private final static Logger logger = Logger.getLogger(CreateLuggage.class);

    /**
     * This method describes create luggage logic.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Luggage luggage = RequestParameterIdentifier.getLuggageFromRequest(request);
        try {
            if (LuggageService.getInstance().isUniqueLuggage(luggage)) {
                LuggageService.getInstance().addLuggage(luggage);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.SUCCESS_ADD_LUGGAGE);
                page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE_PATH);
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.UNIQUE_LUGGAGE_ERROR);
                page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ADMIN_PAGE_PATH);
            }
        } catch (SQLException e) {
            request.setAttribute(Parameters.ERROR_DATABASE, MessageConstants.DATABASE_ACCESS_ERROR);
            page = ConfigManagerPages.getInstance().getProperty(PathPageConstants.ERROR_PAGE_PATH);
            logger.error(MessageConstants.DATABASE_ACCESS_ERROR);
        }
        return page;
    }
}
