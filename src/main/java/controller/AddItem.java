package controller;

import entity.Items;
import serviceImp.ItemAddServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addItems")
public class AddItem extends HttpServlet {
    private Items items;
    ItemAddServiceImpl itemAddService = new ItemAddServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        items = new Items();
        String name = req.getParameter("itemName");
        String itemCategory = req.getParameter("item_category");
        String itemId = req.getParameter("item_id");
        String priceStr = req.getParameter("price");
        Float price = Float.valueOf(priceStr);
        String stockStr = req.getParameter("stock");
        Integer stock = Integer.valueOf(stockStr);
        String description = req.getParameter("description");

        items.setName(name);
        items.setCategoryId(itemCategory);
        items.setItemId(itemId);
        items.setPrice(price);
        items.setStock(stock);
        items.setDescription(description);

        itemAddService.addItem(items);

        resp.sendRedirect("item_list.jsp");
    }
}
