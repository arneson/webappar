package edu.chl.hajo.shop.core;

import lombok.Getter;

/**
 An Address
 Will be part of Customer) will not live independently

 @author hajo
 */
public class Address {

    @Getter
    private final String street;
    @Getter
    private final int nbr;
    @Getter
    private final String town;

    public Address(String street, int nbr, String town) {
        this.street = street;
        this.nbr = nbr;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", nbr=" + nbr + ", town=" + town + '}';
    }

}
