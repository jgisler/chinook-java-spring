package org.gislers.chinook.service.beans;

import org.gislers.chinook.service.ArtistService;
import org.gislers.chinook.service.dto.Artist;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by:   jgisle
 * Created date: 9/14/15
 */
public class ArtistServiceBeanTest extends BaseServiceTest {

    @Autowired
    private ArtistService artistService;

    @Test
    public void testFindArtist() throws Exception {
        Artist artist = artistService.findArtist( 1 );
        assertNotNull( artist );
        assertEquals(1, artist.getArtistId());
        assertEquals("AC/DC", artist.getArtistName());
        assertEquals(2, artist.getAlbums().size());
    }
}