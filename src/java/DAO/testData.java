/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Item;
import model.Category;
import java.util.ArrayList;

/**
 *
 * @author anlal
 */
public class testData {

    public static void main(String[] args) {
        ItemsDAO idao = new ItemsDAO();
        ArrayList<Item> items = new ArrayList<Item>();
        items = idao.getAllItem();

        CateDAO cdao = new CateDAO();
        ArrayList<Category> cates = new ArrayList<Category>();
        cates = cdao.getAllCate();
        for (Category c : cates) {
            System.out.println(c.toString());
            for (Item i : items) {

                if (i.getCateID().equals(c.getCateID())) {
                    System.out.println(i.toString());
                }
                

            }
        }
    }

}
