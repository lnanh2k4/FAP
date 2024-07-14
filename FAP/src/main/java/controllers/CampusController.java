/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.CampusDAO;
import daos.CurriculumDAO;
import daos.SpecializationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.Campus;


/**
 *
 * @author mrmas
 */
public class CampusController extends HttpServlet {

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
            out.println("<title>Servlet CurriculumController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CurriculumController at " + request.getContextPath() + "</h1>");
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
        CampusDAO ca = new CampusDAO();
        if (check == null) {
            List<Campus> list = ca.getAllList();
            request.setAttribute("campusList", list);
            request.getRequestDispatcher("campus.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("campus", ca.getCampus(id));
                    request.getRequestDispatcher("editCampus.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("campus", ca.getCampus(id));
                    request.getRequestDispatcher("deleteCampus.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addCampus.jsp");
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
        String pathController = "CampusController";
        String check = request.getParameter("check");
        String id = request.getParameter("campusID");
        String name = request.getParameter("campusName");
        String address = request.getParameter("campusAddress");
        String email = request.getParameter("campusEmail");
        String hotline = request.getParameter("campusHotline");

        CampusDAO ca = new CampusDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    ca.updateCampus(id, name, address, email, hotline);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    ca.deleteCampus(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    ca.addCampus(id, name, address, email, hotline);
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
