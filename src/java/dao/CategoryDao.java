/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.ClothesCatergory;

/**
 *
 * @author asus
 */
public interface CategoryDao {
    public boolean insert(ClothesCatergory category);
    public ClothesCatergory getCategory(int id);
    public ArrayList<ClothesCatergory> getAllCategory();
    public ClothesCatergory update(ClothesCatergory clothes);
    public void delete(int id);
}
