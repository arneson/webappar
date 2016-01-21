package edu.chl.hajo.sshop;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtering out basic parts of application
 *
 *       NOTHING TO DO HERE! 
 *
 * @author hajo
 */
@WebFilter(filterName = "Router", urlPatterns = {"/*"})
public class Router implements Filter {

    // Leading "/" very important (from context root)
    public static final String TEMPLATE = "/WEB-INF/app/template.jsp";
    private static final Logger LOG = Logger.getLogger(Router.class.getSimpleName());
    private static final String RESOURCES
            = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|css))$)";
    private Pattern resources;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        resources = Pattern.compile(RESOURCES);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletRequest r = (HttpServletRequest) req;

        // Some info
        LOG.log(Level.INFO, "URL={0}", r.getRequestURL());
        LOG.log(Level.INFO, "URI={0}", r.getRequestURI());
        LOG.log(Level.INFO, "SERVLET PATH={0}", r.getServletPath());
        LOG.log(Level.INFO, "PATH INFO={0}", r.getPathInfo());
        LOG.log(Level.INFO, "QUERY={0}", r.getQueryString());
        LOG.log(Level.INFO, "--------------------------");

        String uri = r.getRequestURI();
        String path = r.getServletPath();
        try {
            // Pass through resources
            if (resources.matcher(uri).matches()) {
                chain.doFilter(req, res);
            } else if (path.equals("/") || path.equals("/home")) {
                req.getRequestDispatcher(TEMPLATE + "?partial=home").forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
        } catch (IOException | ServletException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            try {
                req.setAttribute("error", ex.getMessage());
                req.getRequestDispatcher(TEMPLATE + "?partial=error").forward(req, res);
            } catch (ServletException | IOException ex1) {
                LOG.log(Level.SEVERE, ex1.getMessage());
            }
        }
    }

    @Override
    public void destroy() {
    }

}
