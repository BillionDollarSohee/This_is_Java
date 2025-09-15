package org.jdbc;

/*

JDBC

1. Java 언어(APP)를 통해서 Oracle(소프트웨어) 연결해서 CRUD작업
2. Java App : Oracle , My-sql , MS-sql 등등 연결하고 작업(CRUD)
		2.1 각각의 제품에 맞는 드라이버를 가지고 있어야 합니다
		CASE 1: 삼성 노트북 >> HP 프린터 연결 >> HP프린터 사이트에서 드라이버 다운 >> 삼성 설치
		CASE 2: HP프린터 제조 회사는 ... 삼성, LG 회사마다 적용할 수 있는 드라이버를 별도 제작

각 언어에 맞는 드라이버를 다운로드 해서 제품에 맞게 설치 .... 접속 ...
Oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib)
Mysql (https://dev.mysql.com/downloads/connector/j/)

강사PC : D:\Duzon\DataBase\Connect Utils\OracleJDBC >> ojdbc6.jar

3. 드라이버를 참조 (현재 프로젝트에서 사용) >> Java Project -> 속성 -> build path ->
jar 파일 추가
	3.1 드라이버 사용 준비 완료 >> 메모리에 load 사용 ....

3.2 Class.forName("oracle.jdbc.OracleDriver")..... new 객체 생성 ....
    현재는 버전이 올라서 위 과정을 생략해도 동작한다.

4. JAVA CODE (CRUD) >> JDBC API 제공 받는다
4.1 import java.sql.* >> interface , class 제공

4.2 개발자는 interface 를 통해서 표준화된 DB 작업 수행
	POINT) why interface형태로 제공 >> JDBC API >> Oracle, Mysql , ....)

	//OracleConnection >> Connection (인터페이스) 구현
	//MysqlConnection >> Connection 구현
	//다형성 Connection 부모타입 : 유연한 프로그래밍 작성

>>다형성을 구현 (인터페이스 활용)
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement 등등

5. 작업순서
	5.1 DB연결 -> 명령생성 -> 명령실행 -> 처리 -> 자원해제

5.1 명령 : DDL  (create , alter , drop)
		  CRUD (insert , select , update , delete)

실행 : 쿼리문을 DB서버에게 전달
처리 : 결과를 받아서 화면 출력 , 또는 다른 프로그램에 전달 등등
자원해제 : 연결해제
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Oracle_Connection {
    public static void main(String[] args) throws Exception {
        // 1. 드라이버 로드 (최신 버전은 생략 가능)
        Class.forName("oracle.jdbc.OracleDriver");

        // 2. DB 연결
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "KOSA",
                "1004"
        );

        // 3. 연결 상태 확인
        System.out.println("DB 연결 상태 (닫힘 여부): " + conn.isClosed());
        // false → 연결 성공

        // 명령객체 얻어오기 (CRUD)
        Statement stmt = conn.createStatement();

        // 명령 만들기
        String sql = "select empno, ename, sal from emp";

        // 명령 실행 -> 쿼리를 네트워크로 대전의 DB서버로 보냄
        // DB서버에서 쿼리가 실행되고 그 결과에 접근에 접근해서 사용할 수 있는 객체를 리턴 받는다.
        ResultSet rs = stmt.executeQuery(sql);
        // 쿼리 -> 네트워크 -> DB -> DB에서 쿼리 실행하고 결과는 메모리에 생성
        // select 결과 집합은 연결이 지속되는한 데이터에 접근 read  rksmd

        // 읽기
//        while (rs.next()) {
//            System.out.println(rs.getInt("empno") + " / "
//                    + rs.getString("ename") + " / "
//                    + rs.getInt("sal"));
//        }

        // 컬럼명대신 컬럼 순서로도 가능하다.
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " / "
                    + rs.getString(2) + " / "
                    + rs.getInt(3));
        }

        // 자원해제 - 안하면 DB 터짐
        stmt.close();
        rs.close();
        conn.close();

        System.out.println("DB 연결 끊김 :" + conn.isClosed());


    }
}
