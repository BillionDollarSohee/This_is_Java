<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    String user_id = request.getParameter("user_id");
    String user_pwd = request.getParameter("user_pwd");

    String result = "fail";
    if("kosa".equals(user_id) && "1004".equals(user_pwd)){
        result = "success";
    }

    out.print(result);
%>