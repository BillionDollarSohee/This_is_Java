<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= http"//java.sun.com/jsp/jstl/core"%>
<%
    /*
    EL & JSTL 는 WAS 즉 서버쪽 스크립트가 해석한다.
    <c:set 은 변수를 생성하고 값을 저장할 수 있다>
    <c:if test="조건">
    <c:choose> // else if 가 없어서 choose가 매우 유용하게 쓰인다.
    <c:forEach>
    <c:forTokens 문자열을 배열로 만들어서 자바의 split()과 유사>
    <c:out EL처럼 출력기능이 있지만 자주 안쓰임>
    <c:catch try-catch 예외처리>
    */
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3> JSTL & EL </h3>
    EL parameter : &{param.id} - ${param.pwd}<br>
    EL 의 장점은 예외가 발생하지 않는다.
    패스워드가 없어도 그냥 앞부분만 출력 될 뿐이다.


    <h3> 변수에 저장하고 싶으면 JSTL을 사용해야 한다.</h3>
    <c:set var="userid" value="${param.id}" />
    <c:set var="userpwd" value="${param.pwd}" />

    <h3>변수 값 출력</h3>
    id:${userid}<br>
    pwd:${userpwd}<br>

    <hr>
    <c:if test="${!empty userpwd}"> <!-- 비밀번호가 존재하면 -->
        <h3>not empty password</h3>
        <c:if test="${userpwd == 1004}">
            <h3>welcome admin</h3>
        </c:if>
    </c:if>

</body>
</html>