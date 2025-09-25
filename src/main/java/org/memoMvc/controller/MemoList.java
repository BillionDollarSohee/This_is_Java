package org.memoMvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.memoMvc.dao.MemoDao;
import org.memoMvc.dto.Memo;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

public class MemoList extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public MemoList() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("목록보기");

        MemoDao memoDao = new MemoDao();

        try {
            List<Memo> memoList = memoDao.getMemoList();
            request.setAttribute("memoList", memoList); // 데이터 저장

            // 뷰 지정
            RequestDispatcher dis = request.getRequestDispatcher("/memoMvc/memoList.jsp");
            dis.forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // 에러 페이지로 포워드
            RequestDispatcher dis = request.getRequestDispatcher("/views/error.jsp");
            dis.forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

}
