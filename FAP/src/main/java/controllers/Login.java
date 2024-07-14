/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.CampusDAO;
import daos.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class Login extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String check = request.getParameter("check");
        if (check != null) {
            if (check.equals("signout")) {
                session.invalidate();
            }
        }

        if (user != null) {
            response.sendRedirect("index.jsp");
            return;
        }
        response.sendRedirect("login.jsp");
        return;

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO u = new UserDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String campus = request.getParameter("campus");
        User user = u.getUser(email);
        System.out.println(user);
        if (user != null) {
            System.out.println(u.checkUser(user, email, password, campus));
            if (u.checkUser(user, email, password, campus)) {
                session.setAttribute("user", user);
                System.out.println("Trong if dung");
                response.sendRedirect("index.jsp");
                return;
            } else {
                System.out.println("Trong if sai");
                String erorrMessage = "Inputed information is incorrect!";
                request.setAttribute("errorLogin", erorrMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
        } else {
            System.out.println("Khong co tai khoan");
            String erorrMessage = "Inputed information is not existed!";
            request.setAttribute("errorLogin", erorrMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
