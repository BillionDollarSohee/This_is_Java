package org.memoMvc.dao;

/*
DB연결
CRUD 함수 생성 > memo
1. 전체조회  : select id, email, content from memo
2. 조건조회  : select id, email, content from memo where id=? //제약 id > pk
3. 삽입     : insert into memo(id,email,content) values(?,?,?)
4. 수정     : update memo set email=? , content=? where id=?
5. 삭제     : delete from memo where id=?
알파... LIKE 검색  where email like '%naver%'

자바로 함수를 생성하고 처리하는 것과 거의 똑같아요
ArrayList
HashMap
제너릭 ...
*/


import org.memoMvc.dto.Memo;
import org.memoMvc.utils.ConnectionHelper;
import org.memoMvc.utils.DBType;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemoDao {
    // 전체조회
    public List<Memo> getMemoList() throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT id, email, content FROM memo";

        List<Memo> memoList = new ArrayList<>();

        conn = ConnectionHelper.getConnection(DBType.ORACLE); // pool 전환
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Memo memo = new Memo();
            memo.setId(rs.getString("id"));
            memo.setEmail(rs.getString("email"));
            memo.setContent(rs.getString("content"));

            memoList.add(memo);
        }

        // 자원 해제
        ConnectionHelper.close(rs);
        ConnectionHelper.close(pstmt);
        ConnectionHelper.close(conn);


        return memoList;
    }


    // 조건조회 : id(PK) 기준으로 단일 Memo 조회
    public Memo getMemoById(String id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, email, content from memo where id=?";

        Memo memo = null;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id); // ? 바인딩
            rs = pstmt.executeQuery();

            if (rs.next()) {
                memo = new Memo();
                memo.setId(rs.getString("id"));
                memo.setEmail(rs.getString("email"));
                memo.setContent(rs.getString("content"));
            }

        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

        return memo;
    }


    // 삽입
    public int insertMemo(Memo memo) {
        return 0;
    }

    // 수정
    public int updateMemo(Memo memo) {
        return 0;
    }

    // 삭제
    public int deleteMemo(String id) {
        return 0;
    }
    
    // like검색
    public Memo idSearchByEmail(String email) {
        return null;
    }

    // ID가 있는지 여부 체크
    public boolean isCheckById(String id) {
        return false;
    }

}