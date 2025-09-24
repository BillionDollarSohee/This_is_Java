<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
// JSP 페이지는
// request 객체, response 객체 내장 (사용가능)

/*
1. 한글처리 (꿿뛝 처럼 한글깨짐 방지)
2. 데이터 받기
3. 로직 수행
4. 결과 응답하기

1. 전송된 데이터 받기
1.1 Tomcat (내장객체) : ,request  자동 생성된 객체
1.2 HttpServletRequest request = new Http... (요청된 페이지 마다 자동생성)
1.3 클라이언트 서버 (요쳥사항) -> 요청 페이지당 한개의 request 자동생성
1.4 request 객체 (입력데이터, IP, 브라우저 정보)
1.5 request에서 필요한 정보만 꺼내오면 된다.
*/

    request.setCharacterEncoding("UTF-8");
    String uid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");

    // hobby 여러개 데이터 (배열)
    String[] hobbys = request.getParameterValues("hobby");

    // 로직처리
    // DB연결 DTO객체 담기 등

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    서버에서 클라이언트 응답<br>
    ID:<%=uid%><br>
    PWD:<%=pwd%><br>

    <%
        for(String str : hobbys) {
    %>
        <b>hobby<%=str%></b><br>
    <%
        }
    %>
</body>
</html>