package org.gislers.chinook.service;

import org.gislers.chinook.service.dto.Artist;

import java.util.List;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public interface ArtistService {

    Artist findArtist(long artistId);
    List<Artist> getAllArtists();

}
