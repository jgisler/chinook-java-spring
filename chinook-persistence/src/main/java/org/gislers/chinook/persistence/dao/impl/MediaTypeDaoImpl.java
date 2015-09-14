package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.MediaTypeEntity;
import org.gislers.chinook.persistence.dao.MediaTypeDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class MediaTypeDaoImpl extends AbstractDaoImpl<MediaTypeEntity> implements MediaTypeDao {

    public MediaTypeDaoImpl() {
        setClazz( MediaTypeEntity.class );
    }

}
