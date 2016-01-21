package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.util.AbstractEntityContainer;
import java.util.ArrayList;
import java.util.List;

/**
 All customers

 @author hajo
 */
public final class CustomerRegistry extends AbstractEntityContainer<Customer, Long>
        implements ICustomerRegistry {

    public static ICustomerRegistry newInstance() {
        return new CustomerRegistry();
    }

    private CustomerRegistry() {
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<>();
        findRange(0, count()).stream()
                .filter((c) -> {
                    return c.getFname().equals(name)
                    || c.getLname().equals(name);
                })
                .forEach((c) -> {
                    found.add(c);
                });
        return found;
    }
}
