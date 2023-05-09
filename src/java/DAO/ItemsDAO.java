/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Item;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author anlal
 */
public class ItemsDAO {

    private final String DATABASE_NAME = "Teanna";
    private final String TABLE_NAME = "Items";
    private final String MILK_TEA = "MT";
    private final String GREEN_TEA = "GT";
    private final String FRUIT_TEA = "FT";
    private final String ICE_SMOOTHIE = "IS";
    private final String YOGURT_SMOOTHIE = "YS";
    private final String SPECIAL_SMOOTHIE = "SS";

    Connection con;
    Statement statement;
    PreparedStatement pstm;
    ResultSet rs;

    public ItemsDAO() {
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
    
    public ArrayList<Item> getAllItemByCate(String cate) {
        ArrayList<Item> Items = new ArrayList<Item>();
        try {
            String query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] "
                    + "WHERE [CateID] = ? GROUP BY [CateID],[ItemID],[ImgLink],[ItemName],[Price]";
            pstm = con.prepareStatement(query);
            pstm.setString(1, cate);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Items.add(new Item(CateID, ItemID, Img, ItemName, Price));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    //count All Item in table [Items] and calculate number of page
    public int numberOfPage(int numberOfItem) {
        try {
            String query = "SELECT COUNT(*) FROM [Teanna].[dbo].[Items]";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int num = rs.getInt(1);
                return (int) Math.ceil((double) num / numberOfItem);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return 0;
    }
    
    //get All Item in table [Items]
    public ArrayList<Item> getAllItemOrder(int type) {
        ArrayList<Item> Items = new ArrayList<Item>();
        String query = "";
        try {
            switch(type){
                case 1:
                    query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] GROUP BY [CateID],[ItemID],[ImgLink],[ItemName],[Price] order by Price asc;";
                    break;
                case 2:
                    query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] GROUP BY [CateID],[ItemID],[ImgLink],[ItemName],[Price] order by Price desc;";
                    break;
            }
            
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Item i = new Item(CateID, ItemID, Img, ItemName, Price);
                Items.add(i);
                System.out.println("added all "+i.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    //get All Item in table [Items]
    public ArrayList<Item> getAllItem() {
        ArrayList<Item> Items = new ArrayList<Item>();
        try {
            String query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] GROUP BY [CateID],[ItemID],[ImgLink],[ItemName],[Price];";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Item i = new Item(CateID, ItemID, Img, ItemName, Price);
                Items.add(i);
                System.out.println("added all "+i.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    /**
     * get All Item in table [Items] by: 1.price 2.name
     */
    public ArrayList<Item> getItemByOffset(int offset, int nextN_row, int type) {
        ArrayList<Item> Items = new ArrayList<Item>();
        try {
            String query = "";
            switch (type) {
                case 0:
                    query = "SELECT * FROM [Teanna].[dbo].[Items] OFFSET ORDER BY [Price] desc "
                            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
                    break;
                case 1:
                    query = "SELECT * FROM [Teanna].[dbo].[Items] "
                            + "OFFSET ORDER BY [ItemID] asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
                    break;
                default:
                    query = "SELECT * FROM [Teanna].[dbo].[Items] "
                            + "OFFSET ORDER BY [ItemID] asc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";
                    break;
            }
            pstm = con.prepareStatement(query);
            pstm.setInt(1, offset);
            pstm.setInt(2, nextN_row);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Items.add(new Item(CateID, ItemID, Img, ItemName, Price));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    public ArrayList<Item> ItemByParam(int type) {
        ArrayList<Item> Items = new ArrayList<Item>();
        try {
            String query;
            switch (type) {
                case 1:
                    query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] "
                            + "GROUP BY [Price],[ItemID],[ImgLink],[ItemName],[CateID] ORDER BY [Price] DESC";
                    break;
                case 2:
                    query = "SELECT [CateID],[ItemID],[ImgLink],[ItemName],[Price] FROM [Teanna].[dbo].[Items] "
                            + "GROUP BY [Price],[ItemID],[ImgLink],[ItemName],[CateID] ORDER BY [ItemName] DESC";
                    break;
                default:
                    query = "SELECT * FROM [Teanna].[dbo].[Items] OFFSET ORDER BY [ItemID] "
                            + "OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY;";
                    break;
            }
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Items.add(new Item(CateID, ItemID, Img, ItemName, Price));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    public ArrayList<Item> getAllItemByCategory(String cate) {
        ArrayList<Item> Items = new ArrayList<Item>();
        try {
            String query = "SELECT * FROM [" + DATABASE_NAME + "].[dbo].[" + TABLE_NAME + "] WHERE [CateID] = '" + cate + "';";
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String CateID = rs.getString(1);
                String ItemID = rs.getString(2);
                String Img = rs.getString(3);
                String ItemName = rs.getString(4);
                String Price = rs.getString(5);
                Items.add(new Item(CateID, ItemID, Img, ItemName, Price));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return Items;
    }

    public void addItem(String category, String url, String name, double price) {
        try {
            String query = "INSERT INTO Items (CateID, ImgLink, ItemName, Price) "
                    + "VALUES (?, ?, ?, ?)";
            pstm = con.prepareStatement(query);
            pstm.setString(1, category);
            pstm.setString(2, url);
            pstm.setString(3, name);
            pstm.setDouble(4, price);
            pstm.execute();
            System.out.println("added");
        } catch (Exception e) {
            System.out.println("add Error: " + e.getMessage());
        }
    }

    public void updateItem(String cateID, String url, String name, double price, String id) {
        try {
            String query = "UPDATE [" + DATABASE_NAME + "].[dbo].[" + TABLE_NAME + "] "
                    + "SET [CateID] =?, "
                    + "[ImgLink] =?, "
                    + "[ItemName] =?, "
                    + "[Price] =? "
                    + "WHERE [ItemID] =?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, cateID);
            pstm.setString(2, url);
            pstm.setString(3, name);
            pstm.setDouble(4, price);
            pstm.setString(5, id);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("update Error: " + e.getMessage());
        }
    }

    public void removeItem(String id) {
        try {
            String query = "DELETE FROM [" + DATABASE_NAME + "].[dbo].[" + TABLE_NAME + "] WHERE [ItemID] =?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("remove Error: " + e.getMessage());
        }
    }

}
