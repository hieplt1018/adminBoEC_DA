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
public class ClothesCatergory {

    private int ID;
    private String Name;

    public ClothesCatergory() {
    }

    public ClothesCatergory(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "ClothesCatergory{" + "ID=" + ID + ", Name=" + Name + '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
