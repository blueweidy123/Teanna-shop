/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CateDAO;
import DAO.ItemsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Category;
import model.Item;

/**
 *
 * @author anlal
 */
public class Item_Grid extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CateDAO cateDAO = new CateDAO();
        ItemsDAO itemDAO = new ItemsDAO();
        ArrayList<Category> cates = cateDAO.getAllCate();
        ArrayList<Item> items = itemDAO.getAllItem();
        req.setAttribute("items", items);
        req.setAttribute("cates", cates);
        req.getRequestDispatcher("ItemsAssembly.jsp").forward(req, resp);
    }

}
