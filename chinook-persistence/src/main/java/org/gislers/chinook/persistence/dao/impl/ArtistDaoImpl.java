package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.ArtistEntity;
import org.gislers.chinook.persistence.dao.ArtistDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class ArtistDaoImpl extends AbstractDaoImpl<ArtistEntity> implements ArtistDao {

    public ArtistDaoImpl() {
        setClazz( ArtistEntity.class );
    }
}
