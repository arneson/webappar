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
@Named("deleteProduct")
@RequestScoped
public class DeleteProductBB {


    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String price;
    @Setter
    @Getter
    private String id;

    @Override
    public String toString() {
        return "DeleteProductBB{" + "id=" + id +'}';
    }
}