<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--예외 상황이 발생하더라도 특정 페이지를 보여주도록 하기
예외처리 방법 1. 해당 페이지에 설정하기
예외처리 방법 2. 전역적인 방법 (웹 사이트 전체) -> web.xml
2-1. 상태코드별로 처리 (500서버, 404요청, 403접근권한...)
2-2. 상세하게 예외 객체 별로 (null, indexoutof...)
2-3. 실제로는 ...

p.s. 에러 처리는 최종 배포 이전 시점에 적용해야 한다.
코드 작업시에는 봐야하므로
-->
<%@ page errorPage = "/error/commonError.jsp" %>

<error-page>
    <error-code>404</error-code>
    <location>/error/404.jsp</location>
</error-page>

<error-page>
    <error-code>500</error-code>
    <location>/error/500.jsp</location>
</error-page>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    int data = 0/0;
%>
</body>
</html>