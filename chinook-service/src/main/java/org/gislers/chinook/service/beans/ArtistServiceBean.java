package org.gislers.chinook.service.beans;

import org.gislers.chinook.entities.ArtistEntity;
import org.gislers.chinook.persistence.dao.ArtistDao;
import org.gislers.chinook.service.ArtistService;
import org.gislers.chinook.service.dto.Artist;
import org.gislers.chinook.service.exceptions.ChinookServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim
 * Created on 9/13/15.
 */
@Service
public class ArtistServiceBean extends AbstractServiceBean implements ArtistService {

    @Autowired
    private ArtistDao artistDao;

    @Override
    public Artist findArtist(long artistId) {
        ArtistEntity artistEntity = artistDao.findOne(artistId);
        if( artistEntity == null ) {
            throw new ChinookServiceException("Artist not found");
        }

        Artist artist = buildArtist(artistEntity);
        artist.getAlbums().addAll( buildAlbumList(artistEntity) );
        return artist;
    }

    @Override
    public List<Artist> getAllArtists() {
        List<ArtistEntity> artistEntities = artistDao.findAll();
        List<Artist> artists = new ArrayList<>(artistEntities.size());
        for( ArtistEntity artistEntity : artistEntities ) {
            Artist artist = buildArtist( artistEntity );
            artist.getAlbums().addAll( buildAlbumList(artistEntity) );
            artists.add(artist);
        }
        return artists;
    }
}
