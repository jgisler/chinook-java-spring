package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.InvoiceEntity;
import org.gislers.chinook.entities.InvoiceLineEntity;
import org.gislers.chinook.persistence.dao.InvoiceLineDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class InvoiceLineDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private InvoiceLineDao dao;

    @Test
    public void testFindOne() throws Exception {
        InvoiceLineEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(new BigDecimal("0.99"), entity.getUnitPrice());

        InvoiceEntity invoiceEntity = entity.getInvoiceEntity();
        assertNotNull( invoiceEntity );
    }

    @Test
    public void testFindAll() throws Exception {
        List<InvoiceLineEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(2240, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        InvoiceLineEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( 1, entity.getQuantity() );

        entity.setQuantity(100);
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(100, entity.getQuantity());
    }

    @Test
    public void testDelete() throws Exception {
        InvoiceLineEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        InvoiceLineEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}