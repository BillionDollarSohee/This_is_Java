package org.jdbc;

import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex05_Oracle_PreparedStatement {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            // ? 가 파라미터 값이며 쿼리문을 먼저 작성하여야 한다.
            String sql = "select empno, ename from emp where deptno = ?";
            // where deptno = 10 or where deptno = 20
            // where empno = ? and job ? and sal = ?

            // DB서버에 쿼리를 컴파일해서 준비시키는 과정 (아직 실행 안됨)
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 10);
            rs = pstmt.executeQuery(); // 파라미터만 전송

            // 여기서부터 공식인 로직 결과는 0개 or 1개 or 여러개
            if (rs.next()) { // 1개 또는 여러건
                do {
                    System.out.println(rs.getInt(1) + " / " + rs.getString(2));
                } while (rs.next());
            } else {
                System.out.println("조회된 데이터가 없습니다.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
    }
}
