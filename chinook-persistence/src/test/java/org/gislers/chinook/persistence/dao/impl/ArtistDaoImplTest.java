package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.AlbumEntity;
import org.gislers.chinook.entities.ArtistEntity;
import org.gislers.chinook.persistence.dao.ArtistDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class ArtistDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private ArtistDao dao;

    @Test
    public void testFindOne() throws Exception {
        ArtistEntity artistEntity = dao.findOne(1);
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        List<AlbumEntity> albumsByArtist = artistEntity.getAlbumEntities();
        assertFalse( albumsByArtist.isEmpty() );
        assertEquals( 2, albumsByArtist.size() );
    }

    @Test
    public void testFindAll() throws Exception {
        List<ArtistEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        ArtistEntity artistEntity = dao.findOne(1);
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        artistEntity.setName("AC-DC");
        dao.update(artistEntity);

        artistEntity = dao.findOne(1);
        assertEquals( "AC-DC", artistEntity.getName() );
    }

    @Test
    public void testDelete() throws Exception {
        ArtistEntity artistEntity = dao.findOne(1);
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        dao.delete(artistEntity);

        artistEntity = dao.findOne(1);
        assertNull( artistEntity );
    }

    @Test
    public void testDeleteById() throws Exception {

        dao.deleteById(1);

        ArtistEntity artistEntity = dao.findOne(1);
        assertNull( artistEntity );
    }
}