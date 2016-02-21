package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.persistence.AbstractDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * All orders 
 *
 * @author hajo
 */
@Stateless
public class OrderBook extends AbstractDAO<PurchaseOrder, Long> implements IOrderBook{
    
    @PersistenceContext
    private EntityManager em;
    
    public OrderBook() {
        super(PurchaseOrder.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<PurchaseOrder> getByCustomer(Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
