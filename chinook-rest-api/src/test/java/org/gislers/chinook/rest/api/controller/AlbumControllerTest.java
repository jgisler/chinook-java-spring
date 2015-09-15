package org.gislers.chinook.rest.api.controller;

import org.gislers.chinook.service.dto.Album;
import org.gislers.chinook.service.dto.Artist;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by:   jgisle
 * Created date: 9/15/15
 */
public class AlbumControllerTest extends BaseControllerTest {

    @Autowired
    private AlbumController albumController;

    @Test
    public void testGetAlbumById() throws Exception {
        ResponseEntity<Album> responseEntity = albumController.getAlbumById(1);
        assertNotNull(responseEntity);

        Album album = responseEntity.getBody();
        assertEquals(1, album.getAlbumId());
        assertEquals("For Those About To Rock We Salute You", album.getAlbumTitle());

        Artist artist = album.getArtist();
        assertNotNull( artist );
        assertEquals(1, artist.getArtistId());
        assertEquals("AC/DC", artist.getArtistName());
    }
}