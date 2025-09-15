package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/*
JDBC
DB서버에 요청하는 작업은 크게 2가지로 나뉜다.

1. select(조회) -> 결과 집합 (result Set) -> read

2. Insert, update, delect(조작) -> 결과집합이 없음 = resultSet 필요없음
2.1. 반영된 결과 return (반영된 행의 수 정도는 리턴해줄게.)
update .. where daptno = 10 -> return 10
리턴되는 값이 0보다 크면 반영이 되었다는 뜻으로 볼 수 있음.

자바코드로 CRUD를 만들면 된다,
1. Oracle에 sqlPlus나 sqlDeveloper와 같은 툴에서 DML작업을 하면
   반드시 commit과 rollback를 강제해야했었는데
2. JDBC API로 DML 작업을 하면 무조건 오토커밋이 된다.
원치않는다면 옵션으로 auto commit 안하는 것을 설정할 수 있지만
코드로 commit, rollback 명시해야만 한다.

begin
    A계좌 인출 (update)
    B계좌 이체 (update)
end
하나의 논리적인 작업 단위 (트랜잭션 : transaction)
성공 아니면 실패

만약 트랜잭션 작업을 오토커밋 작업을 false로 한다면
반드시 무조건 예외없이 commit, rollback을 강제해야 락으로 인한 서버가 죽는것을 방지할 수 있다.
 */
public class Ex02_Oracle_DML_INSERT {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 드라이버 로딩 생략하고 연결 객체 생성
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "KOSA",
                    "1004"
            );

            // 명령 객체 생성
            stmt = conn.createStatement();

            // 고대의 무식한 방법..
//            int empno = 7788;
//            String ename = "김유신";
//            int deptno = 0;
// SQL 예외 발생 : ORA-00001: unique constraint (KOSA.PK_DMLEMP_EMPNO) violated
// if문 타지 않는다.

            int empno = 9999;
            String ename = "김유신";
            int deptno = 20;


            String sql = "insert into dmlemp (empno, ename, deptno) "
                    + "values(" + empno + ",'" + ename + "', " + deptno + ")";
            int resultRow = stmt.executeUpdate(sql);

            // 오토커밋중
            if (resultRow > 0) {
                System.out.println("반영된 행의 수 : " + resultRow);
            } else {
                System.out.println("반영된 행이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("SQL 예외 발생 : " + e.getMessage());
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }
}

