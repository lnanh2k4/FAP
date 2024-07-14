/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.MajorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.Major;

/**
 *
 * @author mrmas
 */
public class MajorController extends HttpServlet {

   

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
        MajorDAO m = new MajorDAO();
        if (check == null) {
            List<Major> list = m.getAllList();
            request.setAttribute("majorList", list);
            request.getRequestDispatcher("major.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("major", m.getMajor(id));
                    request.getRequestDispatcher("editMajor.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("major", m.getMajor(id));
                    request.getRequestDispatcher("deleteMajor.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addMajor.jsp");
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
        String pathController ="MajorController";
        String check = request.getParameter("check");
        String id = request.getParameter("majorID");
        String name = request.getParameter("majorName");
        MajorDAO m = new MajorDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    m.updateMajor(id, name);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    m.deleteMajor(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    m.addMajor(id, name);
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
