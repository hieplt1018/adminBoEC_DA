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
import model.Staff;

/**
 *
 * @author asus
 */
public class StaffDAOImpl implements StaffDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;

    public StaffDAOImpl() {
        this.connectdb = new ConnectDB();
    }

    @Override
    public Staff login(String user, String pass) {
        String sql = "SELECT * FROM WebAccount WHERE Username = '" + user+"' and Password = '" + pass + "'";
        System.out.println(sql);
        Staff staff = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                staff = new Staff(user, pass, ID);
                System.out.println("Login Staff successful!");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Login Staff failed!");
        } finally {
        }
        return staff;
    }

    @Override
    public Staff getUser(int id) {
        String sql = "SELECT * FROM WebAccount WHERE ID = " + id;
        System.out.println(sql);
        Staff staff = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                staff = new Staff(username, password, id);
                System.out.println("Get User successful!");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("get User failed!");
        } finally {
        }
        return staff;
    }

}
