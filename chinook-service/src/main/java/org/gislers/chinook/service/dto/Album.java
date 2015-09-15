package org.gislers.chinook.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public class Album {

    private long albumId;
    private String albumTitle;
    private Artist artist;
    private List<Track> tracks = new ArrayList<>();

    public Album() {
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack( Track track ) {
        this.tracks.add( track );
    }
}
