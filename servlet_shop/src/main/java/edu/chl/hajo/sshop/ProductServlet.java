package edu.chl.hajo.sshop;

import edu.chl.hajo.shop.core.IShop;
import edu.chl.hajo.shop.core.Product;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to handle Product pages
 * This is a front controller for the product parts of application
 *
 * @author hajo
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products/*"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IShop shop = (IShop) getServletContext().getAttribute(Keys.SHOP.toString());

        // ----------- Write and navigate ----------
        // This is POST
        String action = req.getParameter("action");
        if (action != null) {
            
            // TODO Change application state
            // and then navigate (also PRG)
        
            
            
        } else {

            // ------- Read and navigate --------
            // This is GET
            
            // Possible useful lines below 
            String[] parts = req.getPathInfo().substring(1).split("/");
            String partial = "?partial=products/";
            Product p;
            switch (parts[0]) {
                
                // TODO more cases    
                    
                    
                case "list":
                    int currPage = 0;
                    if(parts.length>1){
                        try {
                            currPage = Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            //break;
                        }
                    }
                    // TODO
                    HttpSession session = req.getSession();
                    session.setAttribute(Keys.CURRENT_PAGE.toString(), currPage);
                    int pageSize = (int) session.getAttribute(Keys.PAGE_SIZE.toString());
                    List<Product> ps = shop.getProductCatalogue().findRange(currPage * pageSize, pageSize);
                    int totNrOfProducts = shop.getProductCatalogue().count();
                    req.setAttribute(Keys.PRODUCT_LIST.toString(),ps);
                    req.setAttribute(Keys.COUNT.toString(),totNrOfProducts);
                    partial = partial + "listProducts";
                    break;
                case "edit":
                    if(parts.length>1){
                        try {
                            long productId = Long.parseLong(parts[1]);
                            Product product = shop.getProductCatalogue().find(productId);
                            req.setAttribute("product",product);
                            partial = partial + "editProduct";
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            break;
                        }
                    }else{
                        break;
                    }
                    break;
                case "new":
                    partial = partial + "addProduct";
                    break;
                case "del":
                    break;
                default:
                    partial = "?partial=error";

            }
            req.getRequestDispatcher(Router.TEMPLATE + partial).forward(req, resp);
        }
    }
}
