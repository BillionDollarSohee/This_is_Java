package servlet.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/simpleController")   // http://localhost:8080/프로젝트명/simpleController
public class SimpleController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화 담당");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("클라이언트의 요청이 GET 자동실행 함수");

        request.setCharacterEncoding("UTF-8");

        String type = request.getParameter("type");

        Object resultObj;
        if (type == null || type.equals("greeting")) {
            resultObj = "Hello world";
        } else if (type.equals("date")) {
            resultObj = new Date();
        } else {
            resultObj = "invalid String type";
        }

        // request scope에 데이터 저장
        request.setAttribute("result", resultObj);

        // 뷰 지정
        RequestDispatcher dis = request.getRequestDispatcher("/views/Simpleview.jsp");
        dis.forward(request, response);

        // JSP (요청 발생) → Web.xml (URL → 서블릿 연결) → SimpleController (로직 + 데이터 저장 + 뷰 지정) → JSP(View)로 forward
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
