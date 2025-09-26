<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#btn').click(function(){
                $.ajax(
                    {
                        url: "/Practice/jquery/ajax/Ex09_Client_json.jsp",
                        //url:"http://192.168.4.153:8090/WebScript_Jquery_Ajax/TEST.jsp",
                        //http://localhost:8090/WebScript_Jquery_Ajax/TEST.jsp
                        type:"GET",
                        dataType:"json",
                        success:function(employees){
                            employees.forEach(emp => {
                                const row = `
                                  <tr>
                                    <td>${emp.empno}</td>
                                    <td>${emp.ename}</td>
                                    <td>${emp.sal}</td>
                                    <td>${emp.job}</td>
                                    <td>${emp.comm}</td>
                                  </tr>
                                `;
                                $('#empTable').append(row);
                              });
                        },
                        error:function(xhr){
                            console.log(xhr.status + "ERROR CODE");
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
<h3>EMP LIST</h3>
<button id="btn">emplist</button>
<hr>
<h2>사원 리스트</h2>
<table class="table table-bordered table-hover mt-3">
    <thead class="table-dark">
    <tr>
        <th>사번</th>
        <th>이름</th>
        <th>급여</th>
        <th>직무</th>
        <th>커미션</th>
    </tr>
    </thead>
    <tbody id="empTable">
    <!-- 데이터가 여기에 들어감 -->
    </tbody>
</table>
</body>
</html>