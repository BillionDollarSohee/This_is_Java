<%@ page import="경로.Emp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    /*
    servlet - 열었다 닫았다 해야함 / html 코드를 그냥 쓸 수있다.
    out.print("<html>")
    ...
    out.print("<.html>")

    jsp - 스파게티 코드를 벗어남 / 단점 html을 문자열로 만들어야 함
    */

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>스파게티 코드 (UI)</h3>
    	<%
    		boolean b = true;
    		if(10 > 5){
    	%>
    		if(true)<font color="red"><%=b%></font>
    	<%
    		}else{
    			b = false;
    	%>
    		if(false)<font color="blue"><%=b%></font>
    	<%
    		}
    	%>
    	<h3>out객체 (서버코드 작업 : servlet 에서 화면... jsp 없던 시절에 servlet 있던 시절)</h3>

    <%
        boolean b2 = true;
        if(10 > 5) {
            out.print("if(true)<font color='red'>" + b2 + "</font>");
        } else {
            b2 = false;
            out.print("if(true)<font color='blue'>" + b2 + "</font>");
    %>
</body>
</html>