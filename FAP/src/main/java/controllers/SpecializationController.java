/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.SpecializationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import models.Specialization;

/**
 *
 * @author mrmas
 */
public class SpecializationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpecializationController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpecializationController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        SpecializationDAO sp = new SpecializationDAO();
        if (check == null) {
            List<Specialization> list = sp.getAllList();
            request.setAttribute("specializationList", list);
            request.getRequestDispatcher("specialization.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("specialization", sp.getSpecialization(id));
                    request.getRequestDispatcher("editSpecialization.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("specialization", sp.getSpecialization(id));
                    request.getRequestDispatcher("deleteSpecialization.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addSpecialization.jsp");
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
        String pathController = "SpecializationController";
        String check = request.getParameter("check");
        String id = request.getParameter("specializationID");
        String name = request.getParameter("specializationName");
        String idMajor = request.getParameter("majorID");
        SpecializationDAO sp = new SpecializationDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    sp.updateSpecialization(id, name, idMajor);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    sp.deleteSpecialization(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    if (sp.checkexist(id)) {
                        String erorrMessage = "This Specialization has existed";
                        request.setAttribute("errorAddSpecialization", erorrMessage);
                        request.getRequestDispatcher("addSpecialization.jsp").forward(request, response);
                    } else {
                        sp.addSpecialization(id, name, idMajor);
                        response.sendRedirect(pathController);
                    }
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
