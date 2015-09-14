package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
abstract class AbstractDaoImpl<T extends BaseEntity> {

    private Class<T> clazz;

    @PersistenceContext(unitName="chinook.jpa")
    EntityManager entityManager;

    final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return entityManager.find( clazz, id );
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(){
        return entityManager
                .createQuery("from " + clazz.getName())
                .getResultList();
    }

    public void create( T entity ){
        entityManager.persist( entity );
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        T t = update(entity);
        entityManager.remove( t );
    }

    public void deleteById( long entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }
}
