package org.vavr.sample.dao;

import java.util.List;

/**
 * Created by aleksandra on 05.10.17.
 */
public interface BaseDao<T extends Object> {

    T findOne(Long id);

    T get(Long id) throws Exception;

    List<T> findAll();

    void save(T obj);
}
