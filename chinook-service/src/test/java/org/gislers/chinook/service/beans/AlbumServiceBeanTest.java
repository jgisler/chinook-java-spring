package org.gislers.chinook.service.beans;

import org.gislers.chinook.service.AlbumService;
import org.gislers.chinook.service.dto.Album;
import org.gislers.chinook.service.dto.Artist;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by:   jgisle
 * Created date: 9/14/15
 */
public class AlbumServiceBeanTest extends BaseServiceTest {

    @Autowired
    private AlbumService albumService;

    @Test
    public void testFindAlbum() throws Exception {
        Album album = albumService.findAlbum( 1 );
        assertNotNull(album);
        assertEquals(1, album.getAlbumId());
        assertEquals("For Those About To Rock We Salute You", album.getAlbumTitle());

        Artist artist = album.getArtist();
        assertNotNull(artist);
        assertEquals(1, artist.getArtistId());
        assertEquals("AC/DC", artist.getArtistName());
    }
}