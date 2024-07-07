/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.ScheduleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import models.Schedule;

/**
 *
 * @author Khanh
 */
public class ScheduleController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScheduleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScheduleController at " + request.getContextPath() + "</h1>");
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
        ScheduleDAO w = new ScheduleDAO();
        if (check == null) {
            List<Schedule> list = w.getAllList();
            request.setAttribute("schedulekList", list);
            request.getRequestDispatcher("schedule.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("schedule", w.getSchedule(id));
                    request.getRequestDispatcher("editScheule.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("schedule", w.getSchedule(id));
                    System.out.println(id);
                    request.getRequestDispatcher("deleteScheule.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addScheule.jsp");
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
        String pathController = "ScheuleController";
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        System.out.println("id param"+idParam);
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        int groupSubjectID = Integer.parseInt(request.getParameter("groupSubjectID"));
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        ScheduleDAO y = new ScheduleDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    System.out.println("edit");
                    y.updateSchedule(id, groupSubjectID, startDate, endDate);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    System.out.println(id+" "+groupSubjectID);
                    y.deleteSchedule(id, groupSubjectID);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    System.out.println("Add");
                    y.addSchedule(groupSubjectID, startDate, endDate);
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
