package org.jdbc;

import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex06_Oracle_PreparedStatement {
    public static void main(String[] args) {
        // insert into dmlemp(empno, ename, deptno), values(?,?,?)
        // update dmlemp set ename =?, sal=?, job=?, deptno=? where empno=?

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);

            String sql = "update dmlemp set ename =?, sal=?, job=?, deptno=? where empno=?";
            pstmt = conn.prepareStatement(sql); // 미리 컴파일

            // DB가 가지고 있는 쿼리에 파라미터만 만들어보낸다.
            pstmt.setString(1, "아무개");
            pstmt.setInt(2, 5555);
            pstmt.setString(3, "IT");
            pstmt.setInt(4, 40);
            pstmt.setInt(5, 9999);

            int row = pstmt.executeUpdate();

            if (row > 0) {
                System.out.println("정상 실행");
            } else {
                System.out.println("정상 실행되었지만 반영된 결과가 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println("예외가 생겼습니다." + e.getMessage());
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

    }
}
