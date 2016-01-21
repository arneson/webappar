package edu.chl.hajo.sshop;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 Servlet to handle order pages
 This is a front controller for the product parts of application


  NOTHING TO DO HERE!

 @author hajo
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/orders/*"})
public class OrderServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(OrderServlet.class.getSimpleName());

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
                                    throws ServletException, IOException {
        String path = Router.TEMPLATE + "?partial=orders/listOrders";
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
