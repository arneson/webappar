package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.util.AbstractEntity;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * A purchase order
 *
 * @author hajo
 */
public class PurchaseOrder extends AbstractEntity {
    // State of order
    public enum State {

        ACCEPTED,
        CANCELLED,
        INVOICED,
        SHIPPED,
    }
    @Getter
    private final Date date = new Date();
    @Getter
    private final List<OrderItem> items;
    @Getter
    private final Customer customer;
    @Getter @Setter
    private State state = State.ACCEPTED;

    public PurchaseOrder(Customer customer, List<OrderItem> items) {
        this.customer = customer;
        this.items = items;
    }

    public PurchaseOrder(Long id, Customer customer, List<OrderItem> items) {
        super(id);
        this.customer = customer;
        this.items = items;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "id=" + getId() + ", date=" + date
                + ", items=" + items + ", customer=" + customer
                + ", state=" + state + '}';
    }
}
