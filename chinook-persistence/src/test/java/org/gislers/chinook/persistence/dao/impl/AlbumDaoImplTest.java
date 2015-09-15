package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.AlbumEntity;
import org.gislers.chinook.entities.ArtistEntity;
import org.gislers.chinook.entities.TrackEntity;
import org.gislers.chinook.persistence.dao.AlbumDao;
import org.gislers.chinook.persistence.dao.ArtistDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
public class AlbumDaoImplTest extends BaseDaoImplTest {

    @Autowired
    private AlbumDao dao;

    @Autowired
    private ArtistDao artistDao;

    @Test
    public void testFindOne() throws Exception {
        AlbumEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getAlbumId());
        assertEquals("For Those About To Rock We Salute You", entity.getTitle());

        ArtistEntity artistEntity = entity.getArtistEntity();
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        List<TrackEntity> trackEntities = entity.getTrackEntities();
        assertFalse( trackEntities.isEmpty() );
        assertEquals( 10, trackEntities.size() );
    }

    @Test
    public void testFindAll() throws Exception {
        List<AlbumEntity> entities = dao.findAll();
        assertFalse(entities.isEmpty());
    }

    @Test
    public void testCreate() throws Exception {

        // Find an existing Artist
        ArtistEntity artistEntity = artistDao.findOne( 1 );
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        // Create Album entity
        AlbumEntity newEntity = new AlbumEntity();
        newEntity.setTitle("Who Made Who");
        newEntity.setArtistEntity(artistEntity);

        dao.create(newEntity);
        assertNotNull(newEntity.getAlbumId());

        // Fetch created entity
        AlbumEntity entity = dao.findOne( newEntity.getAlbumId() );
        assertNotNull(entity);
        assertEquals("Who Made Who", entity.getTitle());
        assertEquals(artistEntity, entity.getArtistEntity());
    }

    @Test
    public void testUpdate() throws Exception {
        AlbumEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getAlbumId());
        assertEquals("For Those About To Rock We Salute You", entity.getTitle());

        entity.setTitle("For Those About To Rock, We Salute You");

        entity = dao.findOne( entity.getAlbumId() );
        assertEquals("For Those About To Rock, We Salute You", entity.getTitle() );

        entity.setTitle("For Those About To Rock We Salute You" );
        AlbumEntity originalEntity = dao.update( entity );
        assertEquals( "For Those About To Rock We Salute You", originalEntity.getTitle() );

        AlbumEntity revertedEntity = dao.findOne(entity.getAlbumId());
        assertEquals( "For Those About To Rock We Salute You", revertedEntity.getTitle() );
    }

    @Test
    public void testDelete() throws Exception {

        // Find an existing Artist
        ArtistEntity artistEntity = artistDao.findOne( 1 );
        assertNotNull(artistEntity);
        assertEquals(1, artistEntity.getArtistId());
        assertEquals("AC/DC", artistEntity.getName());

        // Create Album entity
        AlbumEntity newEntity = new AlbumEntity();
        newEntity.setTitle("Back In Black");
        newEntity.setArtistEntity(artistEntity);

        dao.create(newEntity);
        assertNotNull(newEntity.getAlbumId());

        // Fetch created entity
        AlbumEntity foundEntity = dao.findOne( newEntity.getAlbumId() );
        assertNotNull( foundEntity );
        assertEquals("Back In Black", foundEntity.getTitle());
        assertEquals( artistEntity, foundEntity.getArtistEntity() );

        // Delete the new record
        dao.delete(foundEntity);

        // Make sure its gone
        foundEntity = dao.findOne( newEntity.getAlbumId() );
        assertNull(foundEntity);
    }

    @Test
    public void testDeleteById() throws Exception {
        AlbumEntity entity = dao.findOne(1);
        assertNotNull(entity);
        assertEquals(1, entity.getAlbumId());
        assertEquals("For Those About To Rock We Salute You", entity.getTitle());

        dao.deleteById( 1 );

        entity = dao.findOne( 1 );
        assertNull( entity );
    }
}