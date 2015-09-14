package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.GenreEntity;
import org.gislers.chinook.entities.TrackEntity;
import org.gislers.chinook.persistence.dao.GenreDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class GenreDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private GenreDao dao;

    @Test
    public void testFindOne() throws Exception {
        GenreEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getGenreId());

        List<TrackEntity> trackEntities = entity.getTrackEntities();
        assertFalse(trackEntities.isEmpty());
    }

    @Test
    public void testFindAll() throws Exception {
        List<GenreEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
        assertEquals(25, entities.size());
    }

    @Test
    public void testUpdate() throws Exception {
        GenreEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals( "Rock", entity.getName() );

        entity.setName("Blues");
        dao.update(entity);

        entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals("Blues", entity.getName());
    }

    @Test
    public void testDelete() throws Exception {
        GenreEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.delete(entity);

        entity = dao.findOne(1);
        assertNull(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        GenreEntity entity = dao.findOne(1);
        assertNotNull(entity);

        dao.deleteById(1);

        entity = dao.findOne(1);
        assertNull(entity);
    }
}