/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import model.Category;
import model.Item;
import DAO.CateDAO;
import DAO.ItemsDAO;

/**
 *
 * @author anlal
 */
public class ManageItemController extends HttpServlet {

    private static final String UPLOAD_DIR = "/img/upload";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemsDAO items = new ItemsDAO();
        String id = req.getParameter("iId");
        String cateID = req.getParameter("cates");
        String url = req.getParameter("iURL");
        String name = req.getParameter("iName");
        String price = req.getParameter("iPrice");
        System.out.println("MODE: " + req.getParameter("mode") + " id: " + id + " cate: " + cateID + " url: " + url + " name: " + name + " price: " + price);

        /**
         * mode: 1-update 2-delete 3-add
         */
        if (req.getParameter("mode") != null && req.getParameter("mode").equals("1")) {
            items.updateItem(cateID, url, name, Double.valueOf(price), id);
        }
        if (req.getParameter("mode") != null && req.getParameter("mode").equals("2")) {
            items.removeItem(id);
        }
        if (req.getParameter("mode") != null && req.getParameter("mode").equals("3")) {
            items.addItem(cateID, url, name, Double.valueOf(price));
        }

        req.getRequestDispatcher("ItemManage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CateDAO cateDAO = new CateDAO();
        ItemsDAO itemDAO = new ItemsDAO();
        ArrayList<Category> cates = new ArrayList<Category>();
        ArrayList<Item> items = new ArrayList<Item>();

        HttpSession session = req.getSession();
        if (session.getAttribute("login") == null) {
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }

        cates = cateDAO.getAllCate();
        items = itemDAO.getAllItem();

        req.setAttribute("items", items);
        req.setAttribute("cates", cates);
        req.getRequestDispatcher("ItemManage.jsp").forward(req, resp);

    }

}
