package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.PlaylistTrackEntity;
import org.gislers.chinook.persistence.dao.PlaylistTrackDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class PlaylistTrackDaoImpl extends AbstractDaoImpl<PlaylistTrackEntity> implements PlaylistTrackDao {

    public PlaylistTrackDaoImpl() {
        setClazz( PlaylistTrackEntity.class );
    }

}
