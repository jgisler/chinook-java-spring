package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.GenreEntity;
import org.gislers.chinook.persistence.dao.GenreDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class GenreDaoImpl extends AbstractDaoImpl<GenreEntity> implements GenreDao {

    public GenreDaoImpl() {
        setClazz( GenreEntity.class );
    }

}
