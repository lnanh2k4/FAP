/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.SemesterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import models.Semester;

/**
 *
 * @author Khanh
 */
public class SemesterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SemesterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SemesterController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String semesterID = request.getParameter("semesterID");
        SemesterDAO semesterDAO = new SemesterDAO();

        if (check == null) {
            List<Semester> list = semesterDAO.getAllList();
            request.setAttribute("semesterList", list);
            request.getRequestDispatcher("semester.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    Semester semester = semesterDAO.getSemester(semesterID);
                    request.setAttribute("semester", semester);
                    request.getRequestDispatcher("editSemester.jsp").forward(request, response);
                    break;
                case "delete":
                    semester = semesterDAO.getSemester(semesterID);
                    request.setAttribute("semester", semester);
                    request.getRequestDispatcher("deleteSemester.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addSemester.jsp");
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
        String check = request.getParameter("check");
        String semesterID = request.getParameter("semesterID");
        String semesterName = request.getParameter("semesterName");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        String yearID = request.getParameter("yearID");
        SemesterDAO semesterDAO = new SemesterDAO();

        if (check != null) {
            switch (check) {
                case "edit":
                    semesterDAO.updateSemester(semesterID, semesterName, startDate, endDate, yearID);
                    response.sendRedirect("SemesterController");
                    break;
                case "delete":
                    semesterDAO.deleteSemester(semesterID, semesterName, startDate, endDate, yearID);
                    response.sendRedirect("SemesterController");
                    break;
                case "add":
                    semesterDAO.addSemester(semesterID, semesterName, startDate, endDate, yearID);
                    response.sendRedirect("SemesterController");
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
        return "Semester management controller";
    }
}
