/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import dao.ClothesDAO;
import dao.ClothesDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Clothes;

/**
 *
 * @author asus
 */
public class ManagerProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ClothesDAO clothesDAO = new ClothesDaoImpl();
        String command = (String) request.getParameter("command");
        System.out.println("Command: " + command);
        String message = null;
        try {
            switch (command) {
                case "insert": {
                    String name = request.getParameter("name");
                    float price = Float.parseFloat(request.getParameter("price"));
                    String image = request.getParameter("image");
                    String size = request.getParameter("size");
                    int category = Integer.parseInt(request.getParameter("category"));
                    String country = request.getParameter("country");
                    String id = name;
                    Clothes clothes = new Clothes(id, name, price, image, size, category, country);
                    clothesDAO.insert(clothes);
                    message = "INSERT SUCCESS!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("./admin/insert_product.jsp").forward(request, response);
                    break;
                }
                case "update": {
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    float price = Float.parseFloat(request.getParameter("price"));
                    String image = request.getParameter("image");
                    String size = request.getParameter("size");
                    int category = Integer.parseInt(request.getParameter("category"));
                    String country = request.getParameter("country");
                    Clothes clothes = new Clothes(id, name, price, image, size, category, country);
                    clothesDAO.update(clothes);
                    message = "UPDATE SUCCESS!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("./admin/manager_product.jsp").forward(request, response);
                    break;
                }
                case "delete": {
                    String id = request.getParameter("id");
                    clothesDAO.delete(id);
                    message = "DELETE SUCCESS!";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("./admin/manager_product.jsp").forward(request, response);
                    break;
                } 
                case "sendUpdate": {
                    String id = request.getParameter("id");
                    System.out.println("ID update: " + id);
                    request.setAttribute("idUpdate", id);
                    request.getRequestDispatcher("./admin/update_product.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
