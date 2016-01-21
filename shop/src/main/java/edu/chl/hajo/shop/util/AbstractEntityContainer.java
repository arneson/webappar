package edu.chl.hajo.shop.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A container for entities, base class for OrderBook, ProductCatalogue,
 * CustomerRegistry The fundamental common operations are implemented here
 * (Create, Read, Update, Delete = CRUD).
 *
 * @author hajo
 * @param <T> Type stored in container
 * @param <K> Type for key of stored type
 */
public abstract class AbstractEntityContainer<T extends IEntity<K>, K>
        implements IEntityContainer<T, K> {

    // Emulate a database
    private final List<T> elems = Collections.synchronizedList(new ArrayList<T>());

    @Override
    public void create(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Nulls not allowed");
        }
        elems.add(t);
    }

    @Override
    public void delete(K id) {
        T t = find(id);
        if (t != null) {
            elems.remove(t);
        }
    }

    @Override
    public void update(T t) {
        T old = find(t.getId());
        if (old != null) {
            int index = elems.indexOf(old);
            elems.set(index, t);  // Overwrite
        } else {
            elems.add(t);
        }
    }

    @Override
    public T find(K id) {
        for (T t : elems) {
            if (t.getId().equals(id)) { // NOTE: equals, not ==
                return t;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return elems;
    }

    @Override
    public List<T> findRange(int first, int n) {
        // Out of range, empty list
        if (first < 0 || elems.size() - 1 < first) {
            return new ArrayList<>();
        }
        if (first + n < elems.size()) {
            return elems.subList(first, first + n);
        } else {
            return elems.subList(first, elems.size());
        }
    }

    @Override
    public int count() {
        return elems.size();
    }
}
