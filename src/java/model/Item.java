/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anlal
 */
public class Item {
    
    private String cateID;
    private String itemID;
    private String imgLink;
    private String itemName;
    private String price;

    public Item() {
    }

    public Item(String CateID, String ItemID, String ImgLink, String ItemName, String Price) {
        this.cateID = CateID;
        this.itemID = ItemID;
        this.imgLink = ImgLink;
        this.itemName = ItemName;
        this.price = Price;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    

    @Override
    public String toString() {
        return "Item{" + "CateID=" + cateID + ", ItemID=" + itemID + ", ItemName=" + itemName + ", Price=" + price + '}';
    }
    
    
    
}
