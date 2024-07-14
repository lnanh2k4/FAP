/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.MajorDAO;
import daos.YearDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Major;
import models.Year;

/**
 *
 * @author mrmas
 */
public class YearController extends HttpServlet {

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
            out.println("<title>Servlet MajorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MajorController at " + request.getContextPath() + "</h1>");
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
        YearDAO y = new YearDAO();
        if (check == null) {
            List<Year> list = y.getAllList();
            request.setAttribute("yearList", list);
            request.getRequestDispatcher("year.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("year", y.getYear(id));
                    request.getRequestDispatcher("editYear.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("year", y.getYear(id));
                    request.getRequestDispatcher("deleteYear.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addYear.jsp");
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
        String pathController = "YearController";
        String check = request.getParameter("check");
        String id = request.getParameter("yearID");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        YearDAO y = new YearDAO();
        System.out.println(check);
        if (check != null) {
            switch (check) {
                case "edit":
                    y.updateYear(id, startDate, endDate);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    y.deleteYear(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    if (y.checkexist(id, startDate, endDate)) {
                        if (y.getYear(id).getStatus() == -1) {
                            y.updateYear(id, startDate, endDate);
                            y.setStatus(id);
                            response.sendRedirect(pathController);
                            System.out.println(y.getYear(id).getStatus());
                        } else {
                            String erorrMessage = "This year has existed";
                            request.setAttribute("errorAddYear", erorrMessage);
                            request.getRequestDispatcher("addYear.jsp").forward(request, response);
                        }

                    } else {
                        y.addYear(id, startDate, endDate);
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
