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
import model.Item;

/**
 *
 * @author anlal
 */
public class UserDAO {

    private final String DATABASE_NAME = "Teanna";
    private final String TABLE_NAME = "Items";

    Connection con;
    Statement statement;
    PreparedStatement pstm;
    ResultSet rs;

    public UserDAO() {
        connect();
    }
    
    public boolean checkUser(String acc, String pass){
        try {
            String query = "SELECT * FROM [Teanna].[dbo].[User] "
                    + "WHERE [account] = ? and [password] = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, acc);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
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

}
