/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Clothes;

/**
 *
 * @author asus
 */
public interface ClothesDAO {
    public boolean insert(Clothes clothes);
    public Clothes getClothes(String id);
    public ArrayList<Clothes> getAllClothes();
    public void update(Clothes clothes);
    public void delete(String id);
    public int getNumberClothesByCategory(int CategoryId);
    public Clothes getClothesDetails(String clothid);
}
