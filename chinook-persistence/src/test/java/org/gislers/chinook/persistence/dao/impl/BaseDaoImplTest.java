package org.gislers.chinook.persistence.dao.impl;

import org.gislers.chinook.persistence.config.PersistenceConfig;
import org.gislers.chinook.persistence.test.support.JndiDatasourceHelper;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by:   jgisle
 * Created date: 9/11/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PersistenceConfig.class)
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
})
@Transactional
public abstract class BaseDaoImplTest {

    @BeforeClass
    public static void beforeClass() {
        JndiDatasourceHelper.setUpJndiDatasource();
    }
}
