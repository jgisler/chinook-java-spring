package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.entities.InvoiceEntity;
import org.gislers.chinook.persistence.dao.InvoiceDao;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

/**
 * Created by:   jgisle
 * Created date: 9/10/15
 */
@Named
@Repository
public class InvoiceDaoImpl extends AbstractDaoImpl<InvoiceEntity> implements InvoiceDao {

    public InvoiceDaoImpl() {
        setClazz( InvoiceEntity.class );
    }

}
