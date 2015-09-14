package org.gislers.chinook.service;

import org.gislers.chinook.service.dto.Artist;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public interface ArtistService {

    Artist findArtist(long artistId);
}
