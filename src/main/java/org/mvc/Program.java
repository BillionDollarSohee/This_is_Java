package org.mvc;

import org.mvc.dao.DeptDao;
import org.mvc.dto.Dept;

import java.util.List;

/*
Model (DTO(VO), DAO(DB연결 + 함수), SERVICE(요청처리))
View (Console)
Controller (main 함수에서)

학습 목적 (기본) :
1. DB와 연결할 수 있다.
2. CRUD 함수(DAO)를 만들 수 있다.
3. 기본 함수 + a(조건 검색, 문자열 검색) 할 수 있다.
4. 전체조회, 조건조회, 데이터 삽입, 삭제, 수정 쿼리문을 만들 수 있다.

 작업 순서 :
 1. 드라이버 로딩 (jar 파일 추가)
 2. 기타 라이브러리 추가 (오라클, 롬복 등)
 3. utils 복사
 4. DTO생성 (dept)


 */
public class Program {
    public static void main(String[] args) {

        DeptDao deptDao = new DeptDao();

        System.out.println("===[전체조회]===");
        List<Dept> deptList = deptDao.getDeptAllList();
        if (deptList != null) {
            deptPrint(deptList);
        }

        System.out.println("===[조건조회]===");
        Dept dept = deptDao.getDeptListByDeptno(10);
        if (dept != null) {
            deptPrint(dept);
        }

        System.out.println("===[데이터 삽입]===");
        int insertRow = deptDao.insertDept(new Dept(100,"IT","강남"));
        if (insertRow > 0) {
            System.out.println("INSERT ROW : " + insertRow);
        } else {
            System.out.println("INSERT FAIL");
        }

        System.out.println("방금 INSERT한 데이터 조회");
        deptList = deptDao.getDeptAllList();
        if (deptList != null) {
            deptPrint(deptList);
        }

        System.out.println("===[방금 INSERT한 데이터 수정]===");
        int updateRow = deptDao.updateDept(new Dept(100, "개발부", "판교"));
        if (updateRow > 0) {
            System.out.println("UPDATE ROW : " + updateRow);
        } else {
            System.out.println("UPDATE FAIL");
        }

        System.out.println("방금 UPDATE한 데이터 조회");
        dept = deptDao.getDeptListByDeptno(100);
        if (dept != null) {
            deptPrint(dept);
        }

        System.out.println("===[방금 UPDATE한 데이터 삭제]===");
        int deleteRow = deptDao.deleteDept(100);
        if (deleteRow > 0) {
            System.out.println("DELETE ROW : " + deleteRow);
        } else {
            System.out.println("DELETE FAIL");
        }

        System.out.println("방금 DELETE한 후 전체 조회");
        deptList = deptDao.getDeptAllList();
        if (deptList != null) {
            deptPrint(deptList);
        }
    }

    private static void deptPrint(List<Dept> list) {
        for (Dept d : list) {
            System.out.println(d.toString());
        }
    }

    private static void deptPrint(Dept dept) {
        System.out.println(dept.toString());
    }
}
