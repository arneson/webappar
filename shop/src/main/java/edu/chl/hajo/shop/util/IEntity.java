package edu.chl.hajo.shop.util;

import java.io.Serializable;

/**
 * Contract for entity classes. 
 * All entity classes must have a unique id
 * (later we decide on primary key)
 * Also they all must be serializable
 * 
 * @author hajo
 * @param <K> type for key 
 */
public interface IEntity<K> extends Serializable  {
    public K getId();
}
