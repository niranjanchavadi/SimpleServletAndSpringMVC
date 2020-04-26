package com.loginservlet;


import com.loginservlet.utils.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phno = request.getParameter("contact");
        String password = request.getParameter("password");



        if(Validation.validateUserName(userName) &&
                Validation.validatePassword(password)&&Validation.validateEmail(email)
                &&Validation.validatePhoneNumber(phno)&&Validation.validateFirstName(first_name)
                &&Validation.validateLastName(last_name))
        {
            request.getSession().setAttribute("user", userName);
            request.getSession().setAttribute("pwd",password);
            request.getRequestDispatcher("SucessRegistration.jsp").forward(request, response);
        }
        else
        {
           request.getRequestDispatcher("Failureregistration.jsp").include(request, response);

        }
    }
}