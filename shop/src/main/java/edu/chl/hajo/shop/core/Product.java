package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.util.AbstractEntity;
import lombok.Getter;

/**
 * A Product
 * @author hajo
 */
public class Product extends AbstractEntity {

    @Getter
    private final String name;
    @Getter
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }
 
    @Override
    public String toString() {
        return "Product{" + "id=" + getId() + ", name=" + name + ", price=" + price + '}';
    }
}
