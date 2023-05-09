/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author anlal
 */
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Item;
import model.quest;

public class questDAO {

    Connection con;
    Statement statement;
    PreparedStatement pstm;
    ResultSet rs;

    public questDAO() {
        connect();
    }

    private void connect() {
        try {
            con = DBContext.getInstance().connection;
            if (con != null) {
                System.out.println("connect successfully");
            } else {
                System.out.println("connect fail");
            }
        } catch (Exception e) {
            System.out.println("connect Error: " + e.getMessage());
        }

    }
    
    public ArrayList<quest> getAllQ() {
        ArrayList<quest> qs = new ArrayList<quest>();
        try {
            String query = "SELECT * FROM [MyOrder].[dbo].[Question]";
            pstm = con.prepareStatement(query);
//            pstm.setString(1, cate);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String content = rs.getString(2);
                String QA = rs.getString(3);
                String QB = rs.getString(4);
                String QC = rs.getString(5);
                String QD = rs.getString(6);
                String ANSWER = rs.getString(7);
                quest Q = new quest(id, content, QA, QB, QC, QD, ANSWER);
                System.out.println(Q.toString());
                qs.add(Q);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return qs;
    }
    public quest getQ(String qid) {
        try {
            String query = "SELECT * FROM [MyOrder].[dbo].[Question] WHERE [id] = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, qid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String content = rs.getString(2);
                String QA = rs.getString(3);
                String QB = rs.getString(4);
                String QC = rs.getString(5);
                String QD = rs.getString(6);
                String ANSWER = rs.getString(7);
                quest Q = new quest(id, content, QA, QB, QC, QD, ANSWER);
                System.out.println(Q.toString());
                return Q;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }

}
