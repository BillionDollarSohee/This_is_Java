<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String data = request.getParameter("name");
    String data2 = data.toLowerCase(); // null을 소문자로 예외발생
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    전달받은 내용 <%=data2%>
</body>
</html>