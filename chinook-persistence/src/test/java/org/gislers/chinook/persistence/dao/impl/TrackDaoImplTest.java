package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.TrackEntity;
import org.gislers.chinook.persistence.dao.TrackDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class TrackDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private TrackDao dao;

    @Test
    public void testFindOne() throws Exception {
        TrackEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("For Those About To Rock (We Salute You)", entity.getName());
    }

    @Test
    public void testFindAll() throws Exception {
        List<TrackEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(3503, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        TrackEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("For Those About To Rock (We Salute You)", entity.getName());

        entity.setName("Compact Disc");
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Compact Disc", entity.getName());
    }

    @Test
    public void testDelete() throws Exception {
        TrackEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        TrackEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}