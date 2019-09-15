package controller;

import entity.Categroy;
import serviceImp.CategoryServiceImp;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet("/getCategory")
public class ItemsAdd extends HttpServlet {

    private String itemId;
    private CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
    private List<Categroy> categories;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemId = Util.getItemNO();
        categories = categoryServiceImp.getCategory();
        req.getSession().setAttribute("ItemId",itemId);
        req.getSession().setAttribute("list",categories);
        resp.sendRedirect("item_add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
