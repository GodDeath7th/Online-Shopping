package controller;

import entity.Categroy;
import serviceImp.CategoryServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


@WebServlet("/addCategory")
public class AddCategroy extends HttpServlet {
    private CategoryServiceImp categoryServiceImp =new CategoryServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getSession().setAttribute("list",categoryServiceImp.getCategory());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("category_name");
        Categroy category = new Categroy();
        category.setName(name);
        categoryServiceImp.addCategory(category);
    }
}
