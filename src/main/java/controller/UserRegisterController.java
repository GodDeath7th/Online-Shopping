package controller;

import entity.User;
import service.UserService;
import serviceImp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserRegisterController extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();
    private User user;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user.name");
        System.out.println(name);
        if(userService.isexist(name)){
            resp.getWriter().print(true);
        }else {
            resp.getWriter().print(false);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password  =req.getParameter("password");
        String phoneNum = req.getParameter("phoneNumber");
        User user = new User();
        UserServiceImpl userService = new UserServiceImpl();
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNum);
        userService.register(user);
        System.out.println("注册完成");
        req.getRequestDispatcher("Login.jsp").forward(req,resp);


    }

    public String register(){
        userService.register(user);
        return "register";

    }
    public UserService getUserService(){
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
