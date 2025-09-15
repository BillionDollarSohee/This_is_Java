package org.jdbc;

import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
CREATE TABLE trans_A (
    num INT,
    name VARCHAR(20)
);

CREATE TABLE trans_B (
    num INT PRIMARY KEY,
    name VARCHAR(20)
);
Table TRANS_B이(가) 생성되었습니다.

JDBC >> DML >> auto commit >> 실반영

JDBC >> autocommit >> 변경(false) >> 개발자 직접 (commit , rollback) >> 주의 (반드시... commit , rollback 강제)

은행업무 : A계좌 B계좌 이체
쇼핑몰 포인트 : 게시글을 쓰면 회원에게 포인트 부여 (insert , update)
쇼핑몰 결제 처리 : 카드결제, 카드사 벤더 승인 둘다 되면 카트의 물건 구매 (update , .....)

OLTP 환경 (실시간 데이터 처리) > Back End (트랜잭션 구현 필수.....)

트랜잭션 직접 제어하기
*/
public class Ex07_MariaDB_transaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        conn = ConnectionHelper.getConnection(DBType.MARIADB);

        String sql1 = "INSERT INTO trans_A (name) VALUES ('A')";
        String sql2 = "INSERT INTO trans_B (name) VALUES ('B')";

        try {
            // Auto commit 끄기 (개발자가 직접 commit/rollback)
            conn.setAutoCommit(false);

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.executeUpdate(); // 첫 번째 insert
            pstmt2.executeUpdate(); // 두 번째 insert

            conn.commit(); // 둘 다 성공해야 commit
            System.out.println("트랜잭션 성공: commit 완료");
        } catch (Exception e) {
            System.out.println("예외 발생 : rollback 실행");
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace(); // 원인 확인
        } finally {
            ConnectionHelper.close(pstmt1);
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(conn);
        }
    }
}