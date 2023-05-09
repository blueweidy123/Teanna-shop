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
import java.io.PrintWriter;
import DAO.ItemsDAO;
import model.Item;
import java.util.ArrayList;

/**
 *
 * @author anlal
 */
public class allByCate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemsDAO idao = new ItemsDAO();
        ArrayList<Item> is = new ArrayList<>();

        String cate = req.getParameter("type");
        if (cate.equalsIgnoreCase("ALL")) {
            is = idao.getAllItem();
            req.setAttribute("items", is);
            req.getRequestDispatcher("addByCate.jsp").forward(req, resp);
        } else {
            is = idao.getAllItemByCate(cate);
            req.setAttribute("items", is);
            req.getRequestDispatcher("addByCate.jsp").forward(req, resp);
        }

//        is = idao.getAllItemByCate(cate);
        req.setAttribute("items", is);

        String rs = "";
        for (Item i : is) {
            System.out.println(i.toString());
        }
        req.getRequestDispatcher("addByCate.jsp").forward(req, resp);
    }

}
