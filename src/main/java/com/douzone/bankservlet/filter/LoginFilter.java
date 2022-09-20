package com.douzone.bankservlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "LoginFilter", urlPatterns = "*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession(false);

        if(Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))){
            ((HttpServletResponse) response).sendRedirect("loginPage.jsp");
        }
        chain.doFilter(request, response);
    }
}
