/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author anlal
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = req.getParameter("acc");
        String pass = req.getParameter("pass");
        if (req.getParameter("log") != null) {
            UserDAO udao = new UserDAO();
            HttpSession session = req.getSession();
            if (udao.checkUser(acc, pass)) {
                session.setAttribute("login", '1');
                System.out.println("login-success");
//                req.getRequestDispatcher("ItemManage.jsp").forward(req, resp);
                resp.sendRedirect("ItemManage");
            } else {
                System.out.println("login-fail");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("Login.jsp");

    }

}
