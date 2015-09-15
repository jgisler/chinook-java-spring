package org.gislers.chinook.service.beans;

import org.gislers.chinook.entities.AlbumEntity;
import org.gislers.chinook.entities.ArtistEntity;
import org.gislers.chinook.entities.TrackEntity;
import org.gislers.chinook.service.dto.Album;
import org.gislers.chinook.service.dto.Artist;
import org.gislers.chinook.service.dto.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:   jgisle
 * Created date: 9/14/15
 */
abstract class AbstractServiceBean {

    Artist buildArtist( ArtistEntity entity ) {
        Artist artist = new Artist();
        artist.setArtistId(entity.getArtistId());
        artist.setArtistName( entity.getName() );
        return artist;
    }

    Artist buildArtist( AlbumEntity albumEntity ) {
        return buildArtist( albumEntity.getArtistEntity() );
    }

    Album buildAlbum( AlbumEntity entity ) {
        Album album = new Album();
        album.setAlbumId(entity.getAlbumId());
        album.setAlbumTitle(entity.getTitle());
        album.getTracks().addAll( buildTrackList(entity) );
        return album;
    }

    List<Album> buildAlbumList( ArtistEntity artistEntity ) {
        List<AlbumEntity> albumEntities = artistEntity.getAlbumEntities();
        List<Album> albumList = new ArrayList<>(albumEntities.size());
        for( AlbumEntity albumEntity : albumEntities ) {
            albumList.add( buildAlbum(albumEntity) );
        }
        return albumList;
    }

    Track buildTrack( TrackEntity trackEntity ) {
        Track track = new Track();
        track.setTrackId( trackEntity.getTrackId() );
        track.setTrackTitle( trackEntity.getName() );
        track.setTrackDuration( trackEntity.getMilliseconds() );
        return track;
    }

    List<Track> buildTrackList( AlbumEntity albumEntity ) {
        List<TrackEntity> trackEntities = albumEntity.getTrackEntities();
        List<Track> tracks = new ArrayList<>(trackEntities.size());
        for( TrackEntity trackEntity : trackEntities ) {
            tracks.add( buildTrack(trackEntity) );
        }
        return tracks;
    }
}
