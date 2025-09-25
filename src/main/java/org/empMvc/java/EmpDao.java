package org.empMvc.java;

import org.empMvc.java.utils.ConnectionPoolHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    // 삽입 (hiredate는 DB sysdate 사용)
    public int insertEmp(Emp emp) throws SQLException {
        String sql = "INSERT INTO Emp(empno, ename, job, mgr, hiredate, comm, deptno, sal) "
                + "VALUES(?,?,?,?, SYSDATE, ?,?,?)";

        try (Connection conn = ConnectionPoolHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getEname());
            pstmt.setString(3, emp.getJob());
            pstmt.setInt(4, emp.getMgr());
            pstmt.setInt(5, emp.getComm());
            pstmt.setInt(6, emp.getDeptno());
            pstmt.setInt(7, emp.getSal());

            return pstmt.executeUpdate();
        }
    }

    // 수정
    public int updateEmp(Emp emp) throws SQLException {
        String sql = "UPDATE Emp SET ename=?, job=?, mgr=?, sal=?, comm=?, deptno=? WHERE empno=?";

        try (Connection conn = ConnectionPoolHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getEname());
            pstmt.setString(2, emp.getJob());
            pstmt.setInt(3, emp.getMgr());
            pstmt.setInt(4, emp.getSal());
            pstmt.setInt(5, emp.getComm());
            pstmt.setInt(6, emp.getDeptno());
            pstmt.setInt(7, emp.getEmpno());

            return pstmt.executeUpdate();
        }
    }

    // 단일 조회
    public Emp getEmpListById(int id) throws SQLException {
        String sql = "SELECT empno, ename, job, mgr, hiredate, comm, deptno, sal FROM Emp WHERE empno=?";

        try (Connection conn = ConnectionPoolHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Emp emp = new Emp();
                    emp.setEmpno(rs.getInt("empno"));
                    emp.setEname(rs.getString("ename"));
                    emp.setJob(rs.getString("job"));
                    emp.setMgr(rs.getInt("mgr"));
                    emp.setHiredate(rs.getDate("hiredate"));
                    emp.setComm(rs.getInt("comm"));
                    emp.setDeptno(rs.getInt("deptno"));
                    emp.setSal(rs.getInt("sal"));
                    return emp;
                }
            }
        }
        return null; // 조회 결과 없음
    }

    // 전체 조회
    public List<Emp> getEmpList() throws SQLException {
        String sql = "SELECT empno, ename, job, mgr, hiredate, comm, deptno, sal FROM Emp";
        List<Emp> empList = new ArrayList<>();

        try (Connection conn = ConnectionPoolHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setComm(rs.getInt("comm"));
                emp.setDeptno(rs.getInt("deptno"));
                emp.setSal(rs.getInt("sal"));
                empList.add(emp);
            }
        }

        return empList;
    }

    // 삭제
    public int deleteEmp(int empno) throws SQLException {
        String sql = "DELETE FROM Emp WHERE empno=?";

        try (Connection conn = ConnectionPoolHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, empno);
            return pstmt.executeUpdate();
        }
    }
}
