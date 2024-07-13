/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.AttendanceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Attendance;

/**
 *
 * @author Khanh
 */
public class AttendanceController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GroupController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GroupController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        String scheduleDetailIDParam = request.getParameter("scheduleDetailID");
        int scheduleDetailID = scheduleDetailIDParam != null ? Integer.parseInt(scheduleDetailIDParam) : -1;

        AttendanceDAO attendanceDAO = new AttendanceDAO();

        if (action == null) {
            List<Attendance> list = attendanceDAO.getAllList();
            request.setAttribute("attendanceList", list);
            request.getRequestDispatcher("attendance.jsp").forward(request, response);
        } else {
            switch (action) {
                case "edit":
                    int attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
                    request.setAttribute("attendance", attendanceDAO.getAttendance(attendanceID));
                    request.getRequestDispatcher("editAttendance.jsp").forward(request, response);
                    break;
                case "delete":
                    String userID = request.getParameter("userID");
                    attendanceDAO.deleteAttendance(scheduleDetailID, userID);
                    response.sendRedirect("AttendanceController");
                    break;
                case "add":
                    response.sendRedirect("addAttendance.jsp");
                    break;
                case "attendAll":
                    attendanceDAO.presentAll(scheduleDetailID);
                    response.sendRedirect("AttendanceController");
                    break;
                case "absentAll":
                    attendanceDAO.absentAll(scheduleDetailID);
                    response.sendRedirect("AttendanceController");
                    break;
                case "present":
                    attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
                    attendanceDAO.present(attendanceID);
                    response.sendRedirect("AttendanceController");
                    break;
                case "absent":
                    attendanceID = Integer.parseInt(request.getParameter("attendanceID"));
                    attendanceDAO.absent(attendanceID);
                    response.sendRedirect("AttendanceController");
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
        String pathController = "AttendanceController";
        String action = request.getParameter("action");
        String scheduleDetailIDParam = request.getParameter("scheduleDetailID");
        int scheduleDetailID = scheduleDetailIDParam != null ? Integer.parseInt(scheduleDetailIDParam) : -1;
        String userID = request.getParameter("userID");
        int state = Integer.parseInt(request.getParameter("state"));
        String comment = request.getParameter("comment");
        String note = request.getParameter("note");
        int status = Integer.parseInt(request.getParameter("status"));

        AttendanceDAO attendanceDAO = new AttendanceDAO();

        if (action != null) {
            switch (action) {
                case "edit":
                    attendanceDAO.updateAttendance(scheduleDetailID, userID, state, comment, note);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    attendanceDAO.deleteAttendance(scheduleDetailID, userID);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    attendanceDAO.addAttendance(scheduleDetailID, userID);
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
