<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!--
    JSP: include
    - 현재 페이지에 공통의 페이지를 불러와 삽입할 때 사용
    - 예: <jsp:include page="header.jsp" />
-->

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>SITE MAIN PAGE</title>
</head>
<body>
    <b>SITE MAIN PAGE 상단</b>
    <br>
        <jsp:include page="Ex10_sub.jsp" />
    <br>

    <!-- 여기서 다른 JSP를 include 할 수 있음 -->
    <%-- <jsp:include page="header.jsp" /> --%>

    <b>SITE MAIN 메뉴</b>
    <br><br>

    <b>하단 공통 영역</b>
    <%-- <jsp:include page="footer.jsp" /> --%>
</body>
</html>