package org.empMvc.java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("*.do")
public class EmpController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public EmpController() { super(); }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String urlCommand = requestURI.substring(contextPath.length());

        System.out.println(urlCommand);

        String viewPage = "";
        EmpDao empDao = new EmpDao();

        try {
            if (urlCommand.equals("/emp.do")) {
                viewPage = "/emp_insert.jsp";

            } else if (urlCommand.equals("/empinsert.do")) {
                request.setCharacterEncoding("UTF-8");

                int empno = Integer.parseInt(request.getParameter("empno"));
                String ename = request.getParameter("ename");
                String job   = request.getParameter("job");
                int mgr    = Integer.parseInt(request.getParameter("mgr"));
                int comm   = Integer.parseInt(request.getParameter("comm"));
                int deptno = Integer.parseInt(request.getParameter("deptno"));
                int sal    = Integer.parseInt(request.getParameter("sal"));

                Emp emp = new Emp(empno, ename, job, mgr, new Date(), comm, deptno, sal);
                empDao.insertEmp(emp);

                request.setAttribute("empdetail", emp);
                viewPage = "/emp_detail.jsp";

            } else if(urlCommand.equals("/empupdate.do")) {
                int empno = Integer.parseInt(request.getParameter("empno"));
                Emp empDetail = empDao.getEmpListById(empno);
                request.setAttribute("empdetail", empDetail);
                viewPage = "/emp_update.jsp";

            } else if (urlCommand.equals("/empupdateok.do")) {
                int empno = Integer.parseInt(request.getParameter("empno"));
                String ename = request.getParameter("ename");
                String job = request.getParameter("job");
                int mgr = Integer.parseInt(request.getParameter("mgr"));
                int sal = Integer.parseInt(request.getParameter("sal"));
                int comm = Integer.parseInt(request.getParameter("comm"));
                int deptno = Integer.parseInt(request.getParameter("deptno"));

                Emp emp = new Emp(empno, ename, job, mgr, new Date(), comm, deptno, sal);
                empDao.updateEmp(emp);

                request.setAttribute("empdetail", emp);
                viewPage = "/emp_detail.jsp";

            } else if(urlCommand.equals("/emplist.do")){
                List<Emp> empList = empDao.getEmpList();
                request.setAttribute("empList", empList);
                viewPage = "/emp_list.jsp";

            } else if(urlCommand.equals("/empdetail.do")) {
                int empno = Integer.parseInt(request.getParameter("empno"));
                Emp emp = empDao.getEmpListById(empno);
                request.setAttribute("empdetail", emp);
                viewPage = "/emp_detail.jsp";

            } else if(urlCommand.equals("/empdelete.do")) {
                int empno = Integer.parseInt(request.getParameter("empno"));

                int row = empDao.deleteEmp(empno);
                if(row > 0) {
                    response.sendRedirect(request.getContextPath() + "/emplist.do");
                    return;
                } else {
                    response.sendRedirect(request.getContextPath() + "/empdetail.do?empno=" + empno);
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/emplist.do");
            return;
        }

        if (!viewPage.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher(viewPage);
            dis.forward(request, response);
        }
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
