package com.loginservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Verify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String un = request.getParameter("username");
        String pw = request.getParameter("password");
        String userName = request.getSession().getAttribute("user").toString();
        String password = request.getSession().getAttribute("pwd").toString();
        if (userName.equals(un) &&
                password.equals(pw)) {
            request.setAttribute("username", un);
            request.getRequestDispatcher("SuccessLogin.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("Failurelogin.jsp").include(request, response);
        }
    }

}