package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.PlaylistTrackEntity;
import org.gislers.chinook.persistence.dao.PlaylistTrackDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class PlaylistTrackDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private PlaylistTrackDao dao;

    @Test
    public void testFindOne() throws Exception {
        PlaylistTrackEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Band Members Discuss Tracks from \"Revelations\"", entity.getTrackEntity().getName());
    }

    @Test
    public void testFindAll() throws Exception {
        List<PlaylistTrackEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(8715, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        PlaylistTrackEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Band Members Discuss Tracks from \"Revelations\"", entity.getTrackEntity().getName() );

        entity.getTrackEntity().setName("Compact Disc");
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Compact Disc", entity.getTrackEntity().getName());
    }

    @Test
    public void testDelete() throws Exception {
        PlaylistTrackEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        PlaylistTrackEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}