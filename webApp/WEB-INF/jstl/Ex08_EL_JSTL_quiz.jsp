<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex08_EL_JSTL_Quiz.jsp" method="post">
		JAVA:  <input type="checkbox" name="hobby" value="java"><br>
		JSP:   <input type="checkbox" name="hobby" value="jsp"><br>
		ORACLE:<input type="checkbox" name="hobby" value="oracle"><br>
		MYSQL: <input type="checkbox" name="hobby" value="mysql"><br>
		<input type="submit" value="전송하기">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//list.do?id=hong&pwd=1004
	//list.do?id=hong&pwd=1004&hobby=농구&hobby=축구 ....

	String[] hobbys = request.getParameterValues("hobby"); //배열이 만들어진다

	//EL   ${param.id} , ${param.pwd} , ${paramValues.hobby}

	//http://localhost:8090/Ex08_EL_JSTL_quiz.jsp?id=hong&pwd=1004&hobby=농구&hobby=축구



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>다중값 처리</h3>

    <c:choose>
        <c:when test="${not empty paramValues.hobby}">
            당신의 선택은
            <ul>
                <c:forEach var="hobby" items="${paramValues.hobby}" varStatus="status">
                    <li>${hobby} - index: ${status.index} - count: ${status.count}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            선택한 취미가 없습니다.
        </c:otherwise>
    </c:choose>
</body>
</html>