package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.util.AbstractEntity;
import lombok.Getter;

/**
 * A Customer
 *
 * @author hajo
 */
public class Customer extends AbstractEntity {

    @Getter
    private final transient Cart cart = new Cart();
    @Getter
    private final Address address;
    @Getter
    private final String fname;
    @Getter
    private final String lname;
    @Getter
    private final String email;

    public Customer(Address address, String fname,
            String lname, String email) {
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;

    }

    public Customer(Long id, Address address, String fname,
            String lname, String email) {
        super(id);
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + getId() + ", address=" + address + ", "
                + "fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }
}
