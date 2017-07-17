package by.pvt.hermanovich.airline.commands.implementations.luggage;

import by.pvt.hermanovich.airline.commands.BasicCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class describes operation of deleting a luggage.
 *
 * Created by Yauheni Hermanovich on 17.07.2017.
 */
public class DeleteLuggage implements BasicCommand {

    /**
     * This method describes delete luggage logic.
     *
     * @param request - request which will be processed.
     * @return - a page which user will be directed to.
     */
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}