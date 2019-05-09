/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class Clothes {

    private String ID;
    private String Name;
    private float Price;
    private String Image;
    private String Size;
    private int ClothesCatergoryID;
    private String Country;

    public Clothes(String ID, String Name, float Price, String Image, String Size, int ClothesCatergoryID, String Country) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Image = Image;
        this.Size = Size;
        this.ClothesCatergoryID = ClothesCatergoryID;
        this.Country = Country;
    }

    @Override
    public String toString() {
        return "Clothes{" + "ID=" + ID + ", Name=" + Name + ", Price=" + Price + ", Image=" + Image + ", Size=" + Size + ", ClothesCatergoryID=" + ClothesCatergoryID + ", Country=" + Country + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public int getClothesCatergoryID() {
        return ClothesCatergoryID;
    }

    public void setClothesCatergoryID(int ClothesCatergoryID) {
        this.ClothesCatergoryID = ClothesCatergoryID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    
}
