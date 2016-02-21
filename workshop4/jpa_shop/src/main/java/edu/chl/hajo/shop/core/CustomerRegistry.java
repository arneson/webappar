package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.persistence.AbstractDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All customers 
 *
 * @author hajo
 */
@Stateless
public class CustomerRegistry extends AbstractDAO<Customer, Long> implements ICustomerRegistry{
    
    @PersistenceContext
    private EntityManager em;
    
    public CustomerRegistry(){
        super(Customer.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Customer> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
