/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Staff;

/**
 *
 * @author asus
 */
public interface StaffDAO {
    Staff login(String user, String pass);
    Staff getUser(int id);
}
