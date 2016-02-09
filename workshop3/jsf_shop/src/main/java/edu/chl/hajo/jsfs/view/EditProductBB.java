package edu.chl.hajo.jsfs.view;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by simonarneson on 2016-02-09.
 */
@Named("editProduct")
@RequestScoped
public class EditProductBB {

    @Setter
    @Getter
    @Size(min = 4, max = 20, message = "{product.name}")
    private String name;
    @Setter
    @Getter
    // Hopeless to validate numbers (?!?!) because, user possibly enters non-digits
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "{product.price}")
    private String price;
    @Setter
    @Getter
    private String id;

    @Override
    public String toString() {
        return "EditProductBB{" + "name=" + name + ", name=" + name + ", price=" + price + '}';
    }
}
