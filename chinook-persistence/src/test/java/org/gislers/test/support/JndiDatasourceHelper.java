package org.gislers.test.support;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
public class JndiDatasourceHelper {

    private static final String DS_NAME="ChinookDS";

    public static void setUpJndiDatasource() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc."+DS_NAME);
            // rebind for alias if needed
            ctx.rebind("java:/comp/env/jdbc/" + DS_NAME, ds);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
