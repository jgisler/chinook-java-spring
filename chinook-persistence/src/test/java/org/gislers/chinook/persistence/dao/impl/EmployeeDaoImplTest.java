package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.CustomerEntity;
import org.gislers.chinook.entities.EmployeeEntity;
import org.gislers.chinook.persistence.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class EmployeeDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private EmployeeDao dao;

    @Test
    public void testFindOne() throws Exception {
        EmployeeEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getEmployeeId());

        EmployeeEntity manager = entity.getManager();
        assertNull(manager);

        List<CustomerEntity> customerEntities = entity.getCustomerEntities();
        assertTrue(customerEntities.isEmpty());
    }

    @Test
    public void testFindAll() throws Exception {
        List<EmployeeEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(8, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        EmployeeEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Andrew", entity.getLastName() );

        entity.setLastName( "Jones" );
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Jones", entity.getLastName());
    }

    @Test
    public void testDelete() throws Exception {
        EmployeeEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        EmployeeEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}