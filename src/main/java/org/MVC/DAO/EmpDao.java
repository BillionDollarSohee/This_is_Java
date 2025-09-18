package org.MVC.DAO;

/* CRUD
1. select empno, ename, mgr, hiredate, sal,comm, deptno from emp
2. select empno, ename, mgr, hiredate, sal,comm, deptno from emp where empno =?
3. insert into emp(empno, ename, mgr, hiredate, sal,comm, deptno) values(?,?,?,?,?,?,?)
4. update emp set empno=?, ename=?,mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?
5. delete from emp where empno=?
6. Like 검색  >> 이름 검색  >> 부서번호 , 부서이름도 같이 출력
select e.ename, e.deptno, d.dname
from emp e
left join dept d on e.deptno = d.deptno
where e.ename like ?
 */

import org.MVC.DTO.Emp;
import org.MVC.DTO.EmpDept;
import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {

    // 전체 조회
    public List<Emp> getEmpAllList() {
        List<Emp> empList = new ArrayList<>();

        String sql = "select empno, ename, mgr, hiredate, sal, comm, deptno from emp";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHiredate(rs.getObject("hiredate", LocalDateTime.class));
                emp.setSal(rs.getInt("sal"));
                emp.setComm(rs.getObject("comm", Integer.class));
                emp.setDeptno(rs.getInt("deptno"));

                empList.add(emp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return empList;
    }

    // empno 기준 조회
    public Emp getEmpListByEmpno(int empno) {
        Emp emp = null;
        String sql = "select empno, ename, mgr, hiredate, sal, comm, deptno from emp where empno = ?";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, empno);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    emp = new Emp();
                    emp.setEmpno(rs.getInt("empno"));
                    emp.setEname(rs.getString("ename"));
                    emp.setMgr(rs.getInt("mgr"));
                    emp.setHiredate(rs.getObject("hiredate", LocalDateTime.class));
                    emp.setSal(rs.getInt("sal"));
                    emp.setComm(rs.getObject("comm", Integer.class));
                    emp.setDeptno(rs.getInt("deptno"));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    // insert
    public int insertEmp(Emp emp) {
        int rowcount = 0;
        String sql = "insert into emp(empno, ename, mgr, hiredate, sal, comm, deptno) values(?,?,?,sysdate,?,?,?)";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getEname());
            pstmt.setInt(3, emp.getMgr());
            pstmt.setTimestamp(4, Timestamp.valueOf(emp.getHiredate()));
            pstmt.setInt(5, emp.getSal());
            pstmt.setInt(6, emp.getComm());
            pstmt.setInt(7, emp.getDeptno());

            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowcount;
    }

    // update
    public int updateEmp(Emp emp) {
        int rowcount = 0;
        String sql = "update emp set empno=?, ename=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getEname());
            pstmt.setInt(3, emp.getMgr());
            pstmt.setTimestamp(4, Timestamp.valueOf(emp.getHiredate()));
            pstmt.setInt(5, emp.getSal());
            pstmt.setInt(6, emp.getComm());
            pstmt.setInt(7, emp.getDeptno());
            pstmt.setInt(8, emp.getEmpno()); // WHERE 절 파라미터 추가 ✅

            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowcount;
    }

    // delete
    public int deleteEmp(int empno) {
        int rowcount = 0;
        String sql = "delete from emp where empno=?";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, empno);
            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowcount;
    }


    // 사원이름으로 Emp+Dept 조회
    public List<EmpDept> selectEmpWithDeptByName(String name) {
        List<EmpDept> list = new ArrayList<>();

        String sql = "select e.ename, e.deptno, d.dname " +
                "from emp e " +
                "left join dept d on e.deptno = d.deptno " +
                "where e.ename like ?";

        try (Connection conn = ConnectionHelper.getConnection(DBType.ORACLE);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    EmpDept dto = new EmpDept();
                    dto.setEname(rs.getString("ename"));
                    dto.setDeptno(rs.getInt("deptno"));
                    dto.setDname(rs.getString("dname"));
                    list.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
