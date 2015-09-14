package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.EmployeeEntity;
import org.gislers.chinook.persistence.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<EmployeeEntity> implements EmployeeDao {

    public EmployeeDaoImpl() {
        setClazz( EmployeeEntity.class );
    }

}
