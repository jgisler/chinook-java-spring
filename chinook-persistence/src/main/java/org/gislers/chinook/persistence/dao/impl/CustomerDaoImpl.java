package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.CustomerEntity;
import org.gislers.chinook.persistence.dao.CustomerDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class CustomerDaoImpl extends AbstractDaoImpl<CustomerEntity> implements CustomerDao {

    public CustomerDaoImpl() {
        setClazz( CustomerEntity.class );
    }
}
