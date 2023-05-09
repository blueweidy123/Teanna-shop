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
import model.Item;
import model.Category;
import DAO.CateDAO;
import DAO.ItemsDAO;
import java.util.ArrayList;

/**
 *
 * @author anlal
 */
public class recommend extends HttpServlet {

    public final int itemPerPage = 3;
    
    public final int byPrice = 0;
    public final int byID = 1;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemsDAO idao = new ItemsDAO();
        CateDAO cdao = new CateDAO();
        ArrayList<Item> is = new ArrayList<>();
        ArrayList<Category> cs = new ArrayList<>();

        int numOPage = idao.numberOfPage(itemPerPage);

        int pageNumber = 1;
        if (req.getParameter("page") != null) {
            pageNumber = Integer.parseInt(req.getParameter("page"));
        }
        is = idao.getItemByOffset((pageNumber - 1) * itemPerPage, itemPerPage, byPrice);

        cs = cdao.getAllCate();
        req.setAttribute("page", pageNumber);
        req.setAttribute("numOPage", numOPage);
        req.setAttribute("cates", cs);
        req.setAttribute("items", is);

        req.getRequestDispatcher("recommend.jsp").forward(req, resp);
    }

}
