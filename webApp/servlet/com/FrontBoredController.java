package servlet.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/Board")  // http://localhost:8080/프로젝트명/Board
public class FrontBoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FrontBoardController() {
        super();
        System.out.println("FrontBoardController 생성자 함수 실행 : 초기화 담당");
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet, doPost의 논리가 동일하다면 여기서 모두 처리
        request.setCharacterEncoding("UTF-8");

        String cmd = request.getParameter("cmd");

        String viewPage;
        if (cmd == null) {
            viewPage = "/views/error.jsp";
        } else if (cmd.equals("boardlist")) {
            viewPage = "/views/boardList.jsp";
        } else if (cmd.equals("boardwrite")) {
            viewPage = "/views/boardWrite.jsp";
        } else if (cmd.equals("login")) {
            viewPage = "/views/login.jsp";
        } else {
            viewPage = "/views/error.jsp";
        }

        // request.setAttribute("list", list); // DAO 호출 결과 담는 자리

        RequestDispatcher dis = request.getRequestDispatcher(viewPage);
        dis.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }
}
