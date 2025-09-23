<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= http"//java.sun.com/jsp/jstl/core"%>
<%
    String id = request.getParameter("id");
    if(id.equals("hong")) {
%>
    <%=id%> <img src = "images/img3245.jpg" style = "width: 100px; height: 100ps" >
<%
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h3> EL & JSTP </h3>
    <c:if test="${param.id == 'hong'}">
        ${param.id}<img src = "images/img3245.jpg" style = "width: 100px; height: 100ps" >
    </c:if>

    <c:if test="${param.age > 20}"> var = "result">
        param.value : ${param.age}<br>
    </c:if>
    if문의 var변수는 result : ${result}<br>

</body>
</html>