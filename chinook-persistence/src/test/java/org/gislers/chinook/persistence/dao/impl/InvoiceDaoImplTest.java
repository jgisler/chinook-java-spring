package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.InvoiceEntity;
import org.gislers.chinook.entities.InvoiceLineEntity;
import org.gislers.chinook.persistence.dao.InvoiceDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class InvoiceDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private InvoiceDao dao;

    @Test
    public void testFindOne() throws Exception {
        InvoiceEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(new BigDecimal("1.98"), entity.getTotal());

        List<InvoiceLineEntity> invoiceLineEntities = entity.getInvoiceLineEntities();
        assertFalse(invoiceLineEntities.isEmpty());
    }

    @Test
    public void testFindAll() throws Exception {
        List<InvoiceEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(412, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        InvoiceEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Germany", entity.getBillingCountry() );

        entity.setBillingCountry("Mexico");
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Mexico", entity.getBillingCountry());
    }

    @Test
    public void testDelete() throws Exception {
        InvoiceEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        InvoiceEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}