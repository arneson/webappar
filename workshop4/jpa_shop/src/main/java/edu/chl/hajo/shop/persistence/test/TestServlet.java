package edu.chl.hajo.shop.persistence.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import edu.chl.hajo.shop.core.Address;
import edu.chl.hajo.shop.core.Cart;
import edu.chl.hajo.shop.core.Customer;
import edu.chl.hajo.shop.core.CustomerRegistry;
import edu.chl.hajo.shop.core.OrderBook;
import edu.chl.hajo.shop.core.OrderItem;
import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.ProductCatalogue;
import edu.chl.hajo.shop.core.PurchaseOrder;
import edu.chl.hajo.shop.core.Shop;

/**
 * If we would like to do ocular inspection of tables use this 
 * (if using Arquillian we can't inspect tables)
 *
 * @author hajo
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(TestServlet.class.getName());
    
    @Inject
    EntityManager em;
    @Inject
    Shop library;
    @Inject
    Product pubList;
    @Inject
    Cart authReg;
    @Inject
    ProductCatalogue cat;
    @Inject
    UserTransaction utx;  // This is non-EJB container environment must handle transactions

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        } catch (Exception ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        out.print("<h1> TestServlet finished </h1><p>Check tables in JavaDB</p>");
    }

   

}
