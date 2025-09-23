<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri= http"//java.sun.com/jsp/jstl/core"%>
<%
    Emp emp = new Emp(2000, "kosauser")
    // 현재 페이지만 사용할지(request), 모든 페이지에서 사용할지에() 따라서
    request.serAttribute("e", emp);

    HashMap<String ,String> hp = new HashMap<>();
    hp.put("data", "1004");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>기존방식</h3>
    <%=emp%><br>
    <%=emp.getEmpno() %><br>
    <%=emp. getEname() %><br>

    <h3>EL</h3>
    EL() : 자바객체 출력 (자바객체에 직접 접근 불가)

    <h3>해결사 ESTL</h3>
    객체 접근 : 해결 -> request, session담아서 사용 : GOOD<br>
    EL: ${requestScope.e}<br>
    EL: ${e.empno}<br> <!-- 가능하긴하다. -->
    EL: ${requestScope.e.empno}<br>

    <h3> JSTL은 자바코드 없이 자바나 제어문을 서버에서 작동할 수 있다.</h3>
    <set var="m" value= "<%=emp%>" />
    EL을 통해서 출력하려면: ${m}<br>
    권장하지 않는 EL : ${e.getEmpno()}<br>

    EL출력 : ${m.empno}<br>
    EL출력 : ${m.Ename}<br>
    <hr>

    <h3>JSTL 변수 만들고 scope</h3>
    <c:set var="job" value="농구선수" scope="request" />
    당신의 직업은 : ${job}<br>
    include, forward를 사용하면 다른 페이지에서도 job 출력가능
    <hr>

    자바 API를 활용한 객체는 EL이 직접 접근 불가능하므로
    자바객체를 EL이 사용하고싶다면
    반드시 request 또는 session담아서 자유롭게 쓸 수 있다.

    <hr>
    <c:set var="vhp" value = "<%=hp%>" />
    hp객체 : &{vhp}<br>
    hp객체 : &{vhp.data}<br>

</body>
</html>