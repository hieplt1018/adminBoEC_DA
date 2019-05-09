/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import dao.StaffDAO;
import dao.StaffDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;

/**
 *
 * @author asus
 */
public class LoginServlet extends HttpServlet {
    StaffDAO staffDAO = new StaffDAOImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Staff staff = staffDAO.login(username, password);
            if (staff!=null) {
                HttpSession session = request.getSession();
                request.setAttribute("username", username);
                session.setAttribute("user", username);
                request.getRequestDispatcher("./admin/index.jsp").forward(request, response);
            }else{
                String errorMessage = "Wrong username or password!";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("./admin/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
