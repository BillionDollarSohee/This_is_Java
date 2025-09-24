package servlet.memo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memoServlet")
public class MemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemoServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.한글처리
        //2.데이터 받기
        //3.DB연결
        //4.Insert 실행
        //5.응답구성

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String memo = request.getParameter("memo");

        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn =null;
            PreparedStatement pstmt = null;
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosa","1004");

            String sql="insert into memo(id,email,content) values(?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, email);
            pstmt.setString(3, memo);

            int n = pstmt.executeUpdate();

            if(n>0){
                out.print("<script>");
                out.print("alert('등록성공..');");
                // 절대 경로로 수정
                out.print("location.href='/This_is_Java/memoList';");
                out.print("</script>");
            }else{
                out.print("<script>");
                out.print("alert('등록실패..');");
                // 절대 경로로 수정
                out.print("location.href='/This_is_Java/jsp/servlet/memo/Memo.html';");
                out.print("</script>");
            }

            if(pstmt != null) pstmt.close();
            if(conn != null)  conn.close();
        }catch(Exception e){
            out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}