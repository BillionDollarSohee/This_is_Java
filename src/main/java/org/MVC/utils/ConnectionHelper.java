package org.MVC.utils;

import java.sql.*;

/*
DB 연결을 도와주는 클래스
우리 조원들이 매번 많이 사용할 코드라서 static으로 편하게 해주었다.
오라클을 연결하면 오라클 DB를 연결한
 */
public class ConnectionHelper {
    public static Connection getConnection(DBType dbType) {
        Connection conn = null;

        try {
            switch (dbType) {
                case ORACLE :
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:xe",
                            "KOSA",
                            "1004"
                    );
                    break;
                case MARIADB:
                    conn = DriverManager.getConnection(
                            "jdbc:mariadb://127.0.0.1:3306/mydb",
                            "root",
                            "1004"
                    );
                    break;
            }
        } catch (Exception e) {
            System.err.println("connection Factory : " + e.getMessage());
        }

        return conn;
    }

    // 오버 로딩
    public static Connection getConnection(DBType dbType, String id, String pwd) {
        Connection conn = null;

        try {
            switch (dbType) {
                case ORACLE :
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:xe",
                            id,
                            pwd
                    );
                    break;
                case MARIADB:
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@127.0.0.1:3306/shopdb",
                            id,
                            pwd
                    );
                    break;
            }
        } catch (Exception e) {
            System.err.println("connection Factory : " + e.getMessage());
        }

        return conn;
    }

    // 매번 클로즈 하는 것도 귀찮을테니까
    public static void close(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                // todo
            }
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                // todo
            }
        }
    }

    public static void close(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                // todo
            }
        }
    }

    public static void close(PreparedStatement pstmt) {
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                // todo
            }
        }
    }

}
