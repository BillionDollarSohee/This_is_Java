<%@ page import="java.util.List" %>
<%@ page import="DAO.DeptDao" %>
<%@ page import="DAO.Dept" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // servlet에서 하는 역할을 JSP에서 직접 해보는 예제
    DeptDao dao = new DeptDao();
    List<Dept> deptList = dao.getDeptList(); // 결과 가져오기
    request.setAttribute("list", deptList); // JSTL로 출력 가능하게 request에 담기
%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container">
    <table>
        <thead>
           <tr>
		      <th>deptno</th>
		      <th>dname</th>
		      <th>loc</th>
	       </tr>
        </thead>
        <tbody>
            <c:forEach var = "dept" items = "${requestScope.list}">
			    <tr>
			        <td>${dept.deptno}</td>
			        <td>${dept.dname}</td>
			        <td>${dept.loc}</td>
			    </tr>
			</c:forEach>
	    </tbody>
	 </table>
   </div>

</body>
<style>
    .container {
       width: 100vw;
       height: 100vh;
       display: flex;
       align-items : center;
       justify-content: center;

    }

	table {
	  border-collapse: collapse;
	  width: 50vw;
	}

	th, td {
	  padding-top : 2vh;
	  padding-bottom: 2vh;
	  text-align: center;
	}

	tbody > th, td {
	  border-bottom: 1px solid #444444;
	}

	thead {
	  background-color: #D5DEDC;
	  color: #5F7065;
	}
</style>
</html>
