package controller;

import entity.User;
import serviceImp.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig
public class UserAvatar extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = new User();
        u = (User)req.getSession().getAttribute("u");
        int userId = u.getId();
        System.out.println(userId);
        String str = "";
        try {
            Part part = req.getPart("file");

            String name = part.getHeader("content-disposition");
            String root = this.getServletContext().getRealPath("/");
            str = name.substring(name.lastIndexOf("."),name.length()-1);
            System.out.println(str);
            String filename = userId+str;
            part.write(root+File.separator+filename);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("info","upload failed");
            System.out.println("fail");
        }
        userService.updateAvatar(userId,userId+str);
        ((User) req.getSession().getAttribute("u")).setAvatar(userId+str);
        resp.sendRedirect("UserManage.jsp");
    }
}
