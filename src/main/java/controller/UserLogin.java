package controller;

import entity.User;
import serviceImp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class UserLogin extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");

        String password = req.getParameter("password");
        User u = new User();
        u.setName(name);
        u.setPassword(password);

        u = userService.login(u.getName(),u.getPassword());
        if(u==null){
            resp.sendRedirect("Login.jsp");
        }else {
            req.getSession().setAttribute("u", u);
            resp.sendRedirect("dashboard.jsp");
        }
    }

}
