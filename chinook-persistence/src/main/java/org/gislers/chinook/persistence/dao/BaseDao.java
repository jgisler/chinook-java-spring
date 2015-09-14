package org.gislers.chinook.persistence.dao;

import org.gislers.chinook.entities.BaseEntity;

import java.util.List;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
public interface BaseDao<T extends BaseEntity> {

    T findOne(long id);

    List<T> findAll();

    void create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long entityId);
}
