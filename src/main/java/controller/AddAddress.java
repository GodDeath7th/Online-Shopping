package controller;

import entity.Address;
import entity.User;
import serviceImp.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAddress extends HttpServlet {
    private AddressServiceImpl service;
    private Address address;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u;
        u = (User)req.getSession().getAttribute("u");
        int userId = u.getId();
        String accept = req.getParameter("accept");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String zip = req.getParameter("zip");
        String phoneNumber = req.getParameter("PhoneNumber");
        String mobile = req.getParameter("mobile");
        String isDefault = req.getParameter("isDefault");
        address.setUserId(userId);
        address.setAccept(accept);
        address.setProvince(province);
        address.setCity(city);
        address.setArea(area);
        address.setZip(zip);
        address.setPhoneNumber(phoneNumber);
        address.setMobile(mobile);
        address.setIsDefault(isDefault);
        service.addAddress(address);

        resp.sendRedirect("form.jsp");


}
}
