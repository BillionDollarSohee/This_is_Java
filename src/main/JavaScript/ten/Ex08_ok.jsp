<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// java 코드
	String id = request.getParameter("txtuserid");
	String pwd = request.getParameter("txtpwd");
	
	// 필요에 검증... db 연결 
%>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    서버확인<br>
    당신이 입력한 ID: <%= id%><br>
    당신이 입력한 PWD: <%= pwd%><br>
</body>
</html>