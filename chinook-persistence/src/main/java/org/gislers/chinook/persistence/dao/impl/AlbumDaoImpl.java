package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.AlbumEntity;
import org.gislers.chinook.persistence.dao.AlbumDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class AlbumDaoImpl extends AbstractDaoImpl<AlbumEntity> implements AlbumDao {

    public AlbumDaoImpl() {
        setClazz( AlbumEntity.class );
    }
}
