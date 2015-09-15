package org.gislers.chinook.service.beans;

import org.gislers.chinook.entities.AlbumEntity;
import org.gislers.chinook.persistence.dao.AlbumDao;
import org.gislers.chinook.service.AlbumService;
import org.gislers.chinook.service.dto.Album;
import org.gislers.chinook.service.exceptions.ChinookServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jim
 * Created on 9/13/15.
 */
@Service
@Transactional
public class AlbumServiceBean extends AbstractServiceBean implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public Album findAlbum(long albumId) {
        AlbumEntity albumEntity = albumDao.findOne( albumId );
        if( albumEntity == null ) {
            throw new ChinookServiceException("Album not found");
        }

        Album album = buildAlbum( albumEntity );
        album.setArtist( buildArtist(albumEntity) );
        return album;
    }
}
