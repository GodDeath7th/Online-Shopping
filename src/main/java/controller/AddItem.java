package controller;

import entity.Item;
import serviceImp.ItemAddServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddItem extends HttpServlet {
    private Item items;
    ItemAddServiceImpl itemAddService = new ItemAddServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item();
        String name = req.getParameter("itemName");
        String itemCategory = req.getParameter("item_category");
        String itemId = req.getParameter("item_id");
        String priceStr = req.getParameter("price");
        Float price = Float.valueOf(priceStr);
        String stockStr = req.getParameter("stock");
        Integer stock = Integer.valueOf(stockStr);
        String description = req.getParameter("description");

        item.setName(name);
        item.setCategory(itemCategory);
        item.setPrice(price);
        item.setStock(stock);
        item.setDescription(description);

        itemAddService.addItem(item, true);

        resp.sendRedirect("item_list.jsp");
    }
}
