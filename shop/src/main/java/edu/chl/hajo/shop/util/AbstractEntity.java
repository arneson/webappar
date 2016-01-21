package edu.chl.hajo.shop.util;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 Base class for all entities (later to be stored in database),
 Product, Order, etc

 @author hajo
 */
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntity implements IEntity<Long>, Serializable {

    @Getter
    private final Long id;
    private static int counter = 1;

    protected AbstractEntity() {
        // This is for now, later we have to decide on primary key
        this.id = new Long(counter++);
    }

    protected AbstractEntity(Long id) {
        this.id = id;
    }

}
