package io.ollg.store.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private String login = "admin";
    private String password = "qwerty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Boolean.TRUE.toString().toLowerCase().equals(req.getParameter("error"))){
            req.setAttribute("error", true);
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputLogin = req.getParameter("login");
        String inputPassword = req.getParameter("password");
        if(login.equals(inputLogin) && password.equals(inputPassword)){
            req.getSession().setAttribute("authenticated", true);
            resp.sendRedirect("./library");
        } else {
            resp.sendRedirect("./login?error=true");
        }
    }
}
