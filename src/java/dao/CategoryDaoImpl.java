/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ClothesCatergory;

/**
 *
 * @author asus
 */
public class CategoryDaoImpl implements CategoryDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public CategoryDaoImpl(){
        this.connectdb = new ConnectDB();
    }
    @Override
    public boolean insert(ClothesCatergory category) {
        String sql = "INSERT INTO Category (Name) VALUES(?)"; 
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.executeUpdate();
            System.out.println("Category inserted!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Loi insert account");
        }
        finally {
            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public ClothesCatergory getCategory(int id) {
        String sql = "SELECT * FROM ClothesCatergory WHERE ID = " + id;
        System.out.println(sql);
        ClothesCatergory category = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("Name");
                category = new ClothesCatergory(id, name);
                System.out.println("Get Category successful!");
            }
        } catch (Exception e) {
            System.out.println("get Category failed!");
        }
        finally{
            connectdb.closeConnect();
        }
        return category;
    }

    @Override
    public ArrayList<ClothesCatergory> getAllCategory() {
        ArrayList<ClothesCatergory> list = new ArrayList<>();
        String sql = "SELECT * FROM ClothesCatergory ";
        ClothesCatergory clothes = null;
        
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                clothes = new ClothesCatergory(ID, name);
                list.add(clothes);
            }
        } catch (SQLException ex) {
            System.out.println("Catch getList function");
        } finally {
//            connectdb.closeConnect();
        }
        return list;
    }

    @Override
    public ClothesCatergory update(ClothesCatergory clothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM ClothesCatergory WHERE ID = " + id;
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Delete Category success!");
        } catch (Exception e){
            System.out.println("Delete Category is failed!");
        } finally {
            connectdb.closeConnect();
        }
    }
    
}
