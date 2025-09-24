package org.memoMvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.memoMvc.dao.MemoDao;

import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;

public class MemoList extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public MemoList() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        System.out.println("목록보기");

        // 요청에 따른판단이 필요없다.

        // 목록보기
        MemoDao memoDao = new MemoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
