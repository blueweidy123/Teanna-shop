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

import java.util.ArrayList;
import model.quest;
import DAO.questDAO;

/**
 *
 * @author anlal
 */
public class questC  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        questDAO qd = new questDAO();
        ArrayList<quest> qs = new ArrayList<>();
        qs = qd.getAllQ();
        
        int index = 0;
        if(req.getParameter("index")!=null){
            index = Integer.parseInt(req.getParameter("index"));
        }
        String ans = req.getParameter("ans");
        System.out.println(ans);
        
        if(req.getParameter("ans")!=null && ans.equalsIgnoreCase(qs.get(index).getAnswer())){
            index++;
        }
        
        req.setAttribute("qs", qs);
        
        req.setAttribute("Q", qs.get(index));
        
        req.getRequestDispatcher("quest.jsp").forward(req, resp);
    }
    
    
    
    
}
