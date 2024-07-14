/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.SubjectDAO;
import daos.UserCampusDAO;
import daos.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import models.User;

/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class UserController extends HttpServlet {

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
        String check = request.getParameter("check");
        String id = (String) request.getParameter("id");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        UserDAO user = new UserDAO();
        UserCampusDAO uc = new UserCampusDAO();
        System.out.println(u);
        String userID = request.getParameter("id");
        if (check == null) {
            List<User> list = user.getAllListByCampusID(uc.getUserCampus(u.getUserID()).getCampusID().getCampusID());
            request.setAttribute("userList", list);
            request.getRequestDispatcher("user.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("user", uc.getUserCampus(userID));
                    request.getRequestDispatcher("editUser.jsp").forward(request, response);
                    break;
                case "delete":
                    user.deleteUser(userID);
                    response.sendRedirect("UserController");
                    break;
                case "add":
                    response.sendRedirect("addUser.jsp");
                    break;
                case "detail":
                    request.setAttribute("user", uc.getUserCampus(userID));
                    request.getRequestDispatcher("userDetail.jsp").forward(request, response);
                    break;
                case "login":
                    session.setAttribute("mainUser", u);
                    session.setAttribute("user", user.getUserByUserID(userID));
                    response.sendRedirect("index.jsp");
                    break;
            }
        }
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
        String pathController = "SubjectController";
        String check = request.getParameter("check");
        String id = request.getParameter("subjectID");
        String name = request.getParameter("subjectName");
        int nocredit = Integer.parseInt(request.getParameter("subjectNoCredit"));
        String prerequisite = request.getParameter("subjectPrerequisite");
        String description = request.getParameter("subjectDescription");
        SubjectDAO s = new SubjectDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    s.updateSubject(id, name, nocredit, prerequisite, description);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    System.out.println("id cua post");
                    s.deleteSubject(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    s.addSubject(id, name, nocredit, prerequisite, description);
                    response.sendRedirect(pathController);
                    break;
            }
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
