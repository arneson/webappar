package edu.chl.hajo.shop.core;

import edu.chl.hajo.shop.util.AbstractEntityContainer;
import java.util.ArrayList;
import java.util.List;

/**
 All products

 @author hajo
 */
public final class ProductCatalogue extends AbstractEntityContainer<Product, Long>
        implements IProductCatalogue {

    private ProductCatalogue() {
    }

    public static IProductCatalogue newInstance() {
        return new ProductCatalogue();
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        findRange(0, count()).stream()
                .filter((p) -> (p.getName().equals(name)))
                .forEach((p) -> {
                    found.add(p);
                });
        return found;
    }
}
