<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // EL은 자바코드가 아니고 출력 용도 스크립트 언어라서
    // 여전히 자바는 스파게티에 넣어야한다.
%>
<%
	//*************자바코드영역**********
    data today = new Date();
    request.setAttribute("day", today);
    session.setAttribute("day2", today);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>EL 화면 출력 (서버쪽 자원 접근해서 출력)</h3>
    EL: ${requestScope.day}<br>
    EL: ${day}<br>
    <!-- 객체를 명시하지 않아도 가능하지만 가독성이 떨어져서 되도록 사용 x-->

    EL: ${sessionScope.day2}<br>

</body>
</html>