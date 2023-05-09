/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anlal
 */
public class Category {

    private String cateID;
    private String category;

    public Category() {
    }

    public Category(String CateID, String Category) {
        this.cateID = CateID;
        this.category = Category;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String CateID) {
        this.cateID = CateID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String Category) {
        this.category = Category;
    }

    @Override
    public String toString() {
        return "Category{" + "CateID=" + cateID + ", Category=" + category + '}';
    }

    
    
}
