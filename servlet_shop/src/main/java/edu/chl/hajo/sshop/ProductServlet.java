package edu.chl.hajo.sshop;

import edu.chl.hajo.shop.core.IShop;
import edu.chl.hajo.shop.core.Product;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
        String[] parts = req.getPathInfo().substring(1).split("/");
        switch (req.getMethod()){
            case "GET":
                // ------- Read and navigate --------
                // This is GET

                // Possible useful lines below
                String partial = "?partial=products/";
                switch (parts[0]) {
                    case "list":
                        int currPage = 0;
                        if(parts.length>1){
                            try {
                                currPage = Integer.parseInt(parts[1]);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                break;
                            }
                        }
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
                        }
                        break;
                    case "add":
                        partial = partial + "addProduct";
                        break;
                    case "del":
                        if(parts.length>1){
                            try {
                                long productId = Long.parseLong(parts[1]);
                                Product product = shop.getProductCatalogue().find(productId);
                                req.setAttribute("product",product);
                                partial = partial + "delProduct";
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                        break;
                    default:
                        partial = "?partial=error";

                }
                req.getRequestDispatcher(Router.TEMPLATE + partial).forward(req, resp);
                break;
            default:
                switch (parts[0]) {
                    case "add":
                        try {
                            String name = req.getParameter("name");
                            Double price = Double.parseDouble(req.getParameter("price"));
                            Product p = new Product(name,price);
                            shop.getProductCatalogue().create(p);
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                        }
                        break;
                    case "edit":
                        Logger.getGlobal().log(Level.INFO,"EDIT");
                        try {
                            String name = req.getParameter("name");
                            Long productId = Long.parseLong(req.getParameter("id"));
                            Double price = Double.parseDouble(req.getParameter("price"));
                            Product p = new Product(productId,name,price);
                            shop.getProductCatalogue().update(p);
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                        }
                        break;
                    case "del":
                        Logger.getGlobal().log(Level.INFO,req.getParameterNames().toString());
                        try {
                            Long productId = Long.parseLong(req.getParameter("id"));
                            shop.getProductCatalogue().delete(productId);
                        }catch(NumberFormatException e){
                            e.printStackTrace();
                        }
                        break;
                }
                resp.sendRedirect("/products/list/"+req.getSession().getAttribute(Keys.CURRENT_PAGE.toString()));
                break;
            
        }
    }
}
