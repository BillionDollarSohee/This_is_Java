<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    table, tr, td { border: 2px solid black; border-collapse: collapse; }
</style>
</head>
<body>
    <table style="width: 700px">
        <tr>
            <td colspan="2">
                <jsp:include page="top.jsp" />
            </td>
        </tr>
        <tr>
            <td style="width: 200px">
                <jsp:include page="left.jsp" />
            </td>
            <td style="width:500px">
                사이트 소개를 합니다.
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <jsp:include page="bottom.jsp" />
            </td>
        </tr>
    </table>
</body>
</html>
