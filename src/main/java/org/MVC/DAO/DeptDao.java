package org.MVC.DAO;

import org.MVC.DTO.Dept;
import org.jdbc.utils.ConnectionHelper;
import org.jdbc.utils.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* CRUD
1. select Deptno, dname, loc from dept
2. select Deptno, dname, loc from dept whewe deptno =?
3. insert into dept(daptno, dname, loc) values(?,?,?)
4. update dept set dname=?, loc=?, where deptno=?
5. delete from dept where deptno=?

 */
public class DeptDao {

    public List<Dept> getDeptAllList(){

        List<Dept> deptList = new ArrayList<Dept>();
        //deptList.add(new Dept());

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            String sql="select deptno , dname, loc from dept";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();


            while(rs.next()) {
                //한건의 데이터  DTO 객체 하나 POINT
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                //List 추가
                deptList.add(dept); //데이터 4건 (4개의 객체가 추가)

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }


        return deptList;
    }

    //2. select deptno , dname, loc from dept where deptno=?
    public Dept getDeptListByDeptno(int deptno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null; //데이터 한건

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            String sql = "select deptno , dname, loc from dept where deptno=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                //한건 데이터 DTO 객체
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno")); //rs.getInt(1)
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

        return dept;
    }

    //insert into dept(deptno,dname,loc) values(?,?,?)
    public int insertDept(Dept dept) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rowcount = 0;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            String sql="insert into dept(deptno,dname,loc) values(?,?,?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, dept.getDeptno());
            pstmt.setString(2, dept.getDname());
            pstmt.setString(3, dept.getLoc());

            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return rowcount;
    }

    //update dept set dname=? , loc=? where deptno=?
    public int updateDept(Dept dept) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rowcount = 0;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            String sql="update dept set dname=? , loc=? where deptno=?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dept.getDname());
            pstmt.setString(2, dept.getLoc());
            pstmt.setInt(3, dept.getDeptno());

            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return rowcount;
    }

    //delete from dept where deptno=?
    public int deleteDept(int deptno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rowcount = 0;

        try {
            conn = ConnectionHelper.getConnection(DBType.ORACLE);
            String sql="delete from dept where deptno=?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, deptno);

            rowcount = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return rowcount;
    }

}
