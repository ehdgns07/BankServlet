package com.douzone.bankservlet.controller;

import com.douzone.bankservlet.domain.Customer;
import com.douzone.bankservlet.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "Login", value = "/login")
public class LoginController extends HttpServlet {

    LoginService loginService = LoginService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        try {
            Customer customer = loginService.loginCheck(id, pwd);

            if(Objects.isNull(customer)){
                response.sendRedirect("/loginFail.jsp");
            }

            response.sendRedirect("/index.jsp");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
