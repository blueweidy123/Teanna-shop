/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author anlal
 */
public class CateDAO {

    private final String TABLE_NAME = "Categories";

    //khai bao cac thanh phan su ly database
    Connection con;//ket noi database(sql server)
    Statement statement;//thuc thi cau lenh
    PreparedStatement pstm;
    ResultSet rs;//luw va xu ly du lieu

    public CateDAO() {
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

    public ArrayList<Category> getAllCate() {
        ArrayList<Category> Cates = new ArrayList<Category>();
        try {
//            connect();
            String query = "SELECT * FROM [" + TABLE_NAME + "]";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String Category = rs.getString(2);
                Cates.add(new Category(CateID, Category));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Cates;
    }

}
