/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import model.Bill;

/**
 *
 * @author asus
 */
public class BillDaoImpl implements BillDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public BillDaoImpl(){
        this.connectdb = new ConnectDB();
    }


    @Override
    public Bill getBill(int id) {
        String sql = "SELECT * FROM Bill WHERE ID = " + id;
        System.out.println(sql);
        Bill bill = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String cartId = rs.getString("CartID");
                int staffId = rs.getInt("StaffID");
                int accountId = rs.getInt("CustomerID");
                float total = rs.getFloat("Cost");
                String payment = rs.getString("PaymentMethod");
                Date createDate = rs.getDate("CreateDate");
                String billStatus = rs.getString("BillStatus ");
                long orderID = rs.getLong("OrdersID");
                bill = new Bill(ID, staffId, accountId, createDate, total, payment, billStatus, orderID);
            }
        } catch (Exception e) {
            System.out.println("Please check getBill index.jsp in BillDAOImpl");
        }
        finally{
            connectdb.closeConnect();
        }
        return bill;
    }

    @Override
    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> list = new ArrayList();
        String sql = "SELECT * FROM Bill";
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setID(rs.getInt(1));
                bill.setStaffID(rs.getInt(2));
                bill.setCustomerID(rs.getInt(3));
                bill.setCreateDate(rs.getDate(4));
                bill.setCost(rs.getFloat(5));
                bill.setPaymentMethod(rs.getString(6));
                bill.setBillStatus(rs.getString(7));
                bill.setOrderID(rs.getLong(8));
                list.add(bill);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllBill index.jsp in BillDAOImpl");
        } finally{
            connectdb.closeConnect();
        }
        return list;
    }
    
    
}
