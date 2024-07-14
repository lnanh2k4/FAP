/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.WeekDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import models.Week;

/**
 *
 * @author mrmas
 */
public class WeekController extends HttpServlet {

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
        String idParam = request.getParameter("id");
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        System.out.println(id);
        WeekDAO w = new WeekDAO();
        if (check == null) {
            List<Week> list = w.getAllList();
            request.setAttribute("weekList", list);
            request.getRequestDispatcher("week.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("week", w.getWeek(id));
                    request.getRequestDispatcher("editWeek.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("week", w.getWeek(id));
                    System.out.println(id);
                    request.getRequestDispatcher("deleteWeek.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addWeek.jsp");
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
        String pathController = "WeekController";
        String check = request.getParameter("check");
        String idParam = request.getParameter("weekID");
        System.out.println("id param"+idParam);
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        String semesterID = request.getParameter("semesterID");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        WeekDAO y = new WeekDAO();
        System.out.println(check);
        if (check != null) {
            switch (check) {
                case "edit":
                    System.out.println("edit");
                    y.updateWeek(id, semesterID, startDate, endDate);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    System.out.println(id);
                    y.deleteWeek(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    System.out.println("Add");
                    y.addWeek(semesterID, startDate, endDate);
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
