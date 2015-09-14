package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.PlaylistEntity;
import org.gislers.chinook.persistence.dao.PlaylistDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class PlaylistDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private PlaylistDao dao;

    @Test
    public void testFindOne() throws Exception {
        PlaylistEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Music", entity.getName());
    }

    @Test
    public void testFindAll() throws Exception {
        List<PlaylistEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(18, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        PlaylistEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Music", entity.getName() );

        entity.setName("Compact Disc");
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Compact Disc", entity.getName());
    }

    @Test
    public void testDelete() throws Exception {
        PlaylistEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        PlaylistEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}