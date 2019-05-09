/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import connect.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ClothesCatergory;
import model.Clothes;

/**
 *
 * @author asus
 */
public class ClothesDaoImpl implements ClothesDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;

    public ClothesDaoImpl() {
        this.connectdb = new ConnectDB();
    }

//    @Override
//    public boolean insert(Clothes cloths) {
//    }
    @Override
    public Clothes getClothes(String id) {
        String sql = "SELECT * FROM Clothes WHERE ID = " + id;
        System.out.println(sql);
        Clothes cloth = null;
        String idText = String.valueOf(id);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int categoryId = rs.getInt("ClothesCatergoryID");
                String name = rs.getString("Name");
                String size = rs.getString("Size");
                float price = rs.getFloat("Price");
                String company = rs.getString("Company");
                String country = rs.getString("Country");
                String image = rs.getString("Image");
                cloth = new Clothes(id, name, price, image, size, categoryId, country);
                System.out.println("Get Clothes successful!");
            }
        } catch (Exception e) {
            System.out.println("get Clothes failed!");
        } finally {
            connectdb.closeConnect();
        }
        return cloth;
    }

    @Override
    public ArrayList<Clothes> getAllClothes() {
        ArrayList<Clothes> list = new ArrayList<>();
        String sql = "SELECT * FROM Clothes LIMIT 50";
        Clothes clothes = null;
        
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString("ID");
                int categoryId = rs.getInt("ClothesCatergoryID");
                String name = rs.getString("Name");
                String size = rs.getString("Size");
                float price = rs.getFloat("Price");
                String country = rs.getString("Country");
                String image = rs.getString("Image");
                clothes = new Clothes(ID, name, price, image, size, categoryId, country);
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
    public void update(Clothes cloths) {
        String sql = "UPDATE Clothes set Name = '"+cloths.getName()+"', Price = "
                +cloths.getPrice()+", Image = '"+cloths.getImage()
                +"', Size = '"+cloths.getSize()+"', ClothesCatergoryID ="
                +cloths.getClothesCatergoryID()+", Country='"
                +cloths.getCountry() + "' where ID = '" + cloths.getID() +"'";
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Update Clothes success!");
        } catch (Exception e) {
            System.out.println("Update Clothes is failed!");
        } finally {
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Clothes WHERE ID = '" + id+"'";
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Delete Clothes success!");
        } catch (Exception e) {
            System.out.println("Delete Clothes is failed!");
        } finally {
            connectdb.closeConnect();
        }
    }

    @Override
    public boolean insert(Clothes cloths) {
        String sql = "INSERT INTO  Clothes (ClothesCatergoryID, Name, Size, Price, "
                + " Country, Image, ID, DiscountID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setInt(1, cloths.getClothesCatergoryID());
            stmt.setString(2, cloths.getName());
            stmt.setString(3, cloths.getSize());
            stmt.setFloat(4, cloths.getPrice());
            stmt.setString(5, cloths.getCountry());
            stmt.setString(6, cloths.getImage());
            stmt.setString(7, cloths.getID());
            stmt.setInt(8, 0);
            stmt.executeUpdate();
            System.out.println("Cloth inserted!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Loi insert Clothes");
        } finally {
//            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public int getNumberClothesByCategory(int CategoryId) {
        String sql = "select count(*) FROM Clothes WHERE ClothesCatergoryID=" + CategoryId;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int soluong = rs.getInt("count(*)");
                return soluong;
            }
        } catch (SQLException ex) {
            System.out.println("Catch getNumberClothesByCategory function failed!");
        } finally {
//            connectdb.closeConnect();
        }
        return 0;
    }

    @Override
    public Clothes getClothesDetails(String clothid) {
        String sql = "SELECT * FROM Clothes WHERE ID = '" + clothid +"'";
        Clothes clothes = null;
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                clothes.setID(rs.getString("ID"));
                clothes.setClothesCatergoryID(rs.getInt("ClothesCatergoryID"));
                clothes.setName(rs.getString("Name"));
                clothes.setSize(rs.getString("Size"));
                clothes.setPrice(rs.getFloat("Price"));
                clothes.setCountry(rs.getString("Country"));
                clothes.setImage(rs.getString("Image"));
                System.out.println("Get ClothesDetails successful!");
            }
        } catch (Exception e) {
            System.out.println("get ClothesDetails failed!");
        } finally {
//            connectdb.closeConnect();
        }
        return clothes;
    }

}
