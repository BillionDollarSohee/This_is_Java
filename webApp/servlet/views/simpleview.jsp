<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple View</title>
</head>
<body>
    <h3>simple Controller forward 시킨 데이터</h3>
    결과 출력 (스크립틀릿) : <%= request.getAttribute("result") %>
    <hr>
    결과 출력 (EL) : ${requestScope.result}
</body>
</html>
