/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Bill {
    private int ID;
    private int staffID;
    private int customerID;
    private Date createDate;
    private float cost;
    private String paymentMethod;
    private String billStatus;
    private long orderID;

    public Bill() {
    }

    public Bill(int ID, int staffID, int customerID, Date createDate, float cost, String paymentMethod, String billStatus, long orderID) {
        this.ID = ID;
        this.staffID = staffID;
        this.customerID = customerID;
        this.createDate = createDate;
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.billStatus = billStatus;
        this.orderID = orderID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }
    
    
}
