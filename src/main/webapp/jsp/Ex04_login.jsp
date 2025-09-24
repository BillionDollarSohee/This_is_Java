<%@ page import="경로.Emp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    /*
    1.한글처리
    2.데이터받기
    3.로직처리 (비즈니스) > DB작업

    내장객체(WAS 톰캣)
    1. request (클라이언트의 정보를 담고 있는 객체로 요청페이지당 1개 웹서버가 생성해서 메모리에 가지고 있다)
    2. response (웹버서의 응답객체)
    3. session (클라이언트마다 고유하게 생성되는 고유 객체: 접속자100명이면 100개 객체 생성
    4. application 전역자원: 모든세션(모든접속자가)이 공유하는 객체
    5. out (출력객체)

    내장객체는 JSP에서는 new 없이 그냥 사용가능하다 왜냐하면 미리 생성되어 있기 때문에.
    */

    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    1. 입력값 : <%=id %><br>
    2. 접속한 클라이언트 IP : <%= request.getRemoteAddr() %><br>
    3. 포트 : <%= request.getServerPort() %><br>
    4. 경로 : <%= request.getContextPath() %><br>
    <!--실제 경로는 C:\\Web\\WebApp\\a,jsp, 가상디렉토리 : 192.168.0.12/Web/a.jsp -->
</body>
</html>
