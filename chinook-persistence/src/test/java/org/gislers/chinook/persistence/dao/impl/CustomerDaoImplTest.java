package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.CustomerEntity;
import org.gislers.chinook.entities.EmployeeEntity;
import org.gislers.chinook.entities.InvoiceEntity;
import org.gislers.chinook.persistence.dao.CustomerDao;
import org.gislers.chinook.persistence.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class CustomerDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private CustomerDao dao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindOne() throws Exception {
        CustomerEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getCustomerId());

        EmployeeEntity supportRep = entity.getSupportRep();
        assertEquals(3, supportRep.getEmployeeId());

        List<InvoiceEntity> invoiceEntities = entity.getInvoiceEntities();
        assertNotNull( invoiceEntities );
        assertEquals( 7, invoiceEntities.size() );
    }

    @Test
    public void testFindAll() throws Exception {
        List<CustomerEntity> customerEntities = dao.findAll();
        assertFalse( customerEntities.isEmpty() );
        assertEquals(59, customerEntities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        CustomerEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Gonçalves", entity.getLastName() );

        entity.setLastName( "Jones" );
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Jones", entity.getLastName());
    }

    @Test
    public void testDelete() throws Exception {
        CustomerEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        CustomerEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}