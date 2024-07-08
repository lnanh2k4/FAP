/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.UserCampusDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.UserCampus;

/**
 *
 * @author Khanh
 */
public class UserCampusController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserCampusController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserCampusController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        System.out.println(id);
        UserCampusDAO userCampusDAO = new UserCampusDAO();
        if (check == null) {
            List<UserCampus> list = userCampusDAO.getAllList();
            request.setAttribute("userCampusList", list);
            request.getRequestDispatcher("userCampus.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("userCampus", userCampusDAO.getUserCampus(id));
                    request.getRequestDispatcher("editWeek.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("userCampus", userCampusDAO.getUserCampus(id));
                    System.out.println(id);
                    request.getRequestDispatcher("deleteWeek.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addWeek.jsp");
                    break;
            }
        }

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathController = "UserCampusController";
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        System.out.println("id param" + idParam);
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        String campusID = request.getParameter("campusID");
        String userID = request.getParameter("userID");
        UserCampusDAO userCampusDAO = new UserCampusDAO();
        if (check != null) {
            switch (check) {
                case "delete":
                    System.out.println(id);
                    userCampusDAO.deleteUserCampus(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    System.out.println("Add");
                    userCampusDAO.addUserCampus(campusID, userID);
                    response.sendRedirect(pathController);
                    break;
            }
        }
    }
}
