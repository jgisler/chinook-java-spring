package org.gislers.chinook.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public class Artist {

    private long artistId;
    private String artistName;
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum( Album album ) {
        albums.add( album );
    }
}
