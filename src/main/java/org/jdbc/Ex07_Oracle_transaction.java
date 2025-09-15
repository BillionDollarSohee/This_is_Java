package org.jdbc;

import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
create table trans_A(
    num number,
    name varchar2(20)
);
Table TRANS_A이(가) 생성되었습니다.

create table trans_B(
    num number constraint pk_trans_B_num primary key,
    name varchar2(20)
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
public class Ex07_Oracle_transaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        conn = ConnectionHelper.getConnection(DBType.ORACLE);

        String sql1 = "insert into trans_A (num,name) values(100,'A')";
        String sql2 = "insert into trans_B (num,name) values(100,'B')";


        // 2개의 작업을 하나의 논리적인 단위로 묶어서 처리하기
        try {
            //JDBC auto commit을 꺼서 반드시 커밋이나 롤백을 해주어야 한다.
            conn.setAutoCommit(false);
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.executeUpdate(); // insert
            pstmt2.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            System.out.println("예외 발생 : rollback 시전");
            try {
                conn.rollback();
            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        } finally {
            ConnectionHelper.close(pstmt1);
            ConnectionHelper.close(pstmt2);
            ConnectionHelper.close(conn);
        }
    }
}
