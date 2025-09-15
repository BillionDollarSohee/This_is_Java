package org.jdbc;

import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.SQLException;

public class Ex03_ConnectionHelper {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
        System.out.println(conn.isClosed());

        ConnectionHelper.close(conn);
        System.out.println("close : " + conn.isClosed());
    }
}
