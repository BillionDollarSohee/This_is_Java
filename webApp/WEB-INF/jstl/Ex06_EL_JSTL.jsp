<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 0 ~ 10까지 누적합 -->
    <c:forEach var="i" begin="0" end="10">
        <c:set var="sum" value="${sum+i}" />
        ${i}<br>
    </c:forEach>
    sum: 누적 ${sum}<br>

    <!-- 3단 출력 -->
    <ul>
        <c:forEach var="i" begin="1" end="9">
            <li> 3 * ${i} = ${3*i} </li>
        </c:forEach>
    </ul>

    <h3>forEach + choose</h3>

    <!-- 2단 ~ 9단 구구단 -->
    <c:forEach var="i" begin="2" end="9">
        <c:forEach var="j" begin="0" end="9">
            <c:choose>
                <c:when test="${j == 0}">
                    ${i}단<br>
                </c:when>
                <c:otherwise>
                    ${i} * ${j} = ${i*j}&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <br>
    </c:forEach>

    <%--
    자바 기본 자료형 배열에는 EL 접근 불가능하다.
    int[] arr = new int[]{10,20,30,40,50};
    for (int i : arr) {
        out.print("출력값 <b><i>" + i + "</i></b>");
    }

    그러므로 배열, 해시맵 같은 객체를 request에 담아서 접근해야 한다.
    request.setAttribute("iarr", arr);
    --%>

    <!-- iarr 속성에 배열이 담겨 있을 경우 출력 -->
    <c:forEach var="arr" items="${iarr}">
        배열값 : ${arr}<br>
    </c:forEach>

    <h3> 권장사항이 아니지만 가능한 것 </h3>
    <%
        // 배열 생성 후 request에 저장
        int[] arr = new int[]{100, 200, 300};
        request.setAttribute("arr2", arr);
    %>
    <c:forEach var="num" items="${arr2}">
        값 : ${num}<br>
    </c:forEach>

</body>
</html>