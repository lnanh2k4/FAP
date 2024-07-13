/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.TimeDAO;
import daos.YearDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import models.Time;

/**
 *
 * @author mrmas
 */
public class TimeController extends HttpServlet {

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
        int id = request.getParameter("id") == null ? -1 : Integer.parseInt(request.getParameter("id"));
        TimeDAO y = new TimeDAO();
        if (check == null) {
            List<Time> list = y.getAllList();
            request.setAttribute("timeList", list);
            request.getRequestDispatcher("time.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    System.out.println(y.getTime(id));
                    request.setAttribute("time", y.getTime(id));
                    request.getRequestDispatcher("editTime.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("time", y.getTime(id));
                    request.getRequestDispatcher("deleteTime.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addTime.jsp");
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
        String pathController = "TimeController";
        String check = request.getParameter("check");
        int id = request.getParameter("timeID") == null ? -1 : Integer.parseInt(request.getParameter("timeID"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        System.out.println(request.getParameter("endTime"));
        LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
        LocalTime endTime = LocalTime.parse(request.getParameter("endTime"));
        String desc = request.getParameter("description");
        TimeDAO y = new TimeDAO();
        System.out.println(check);
        if (check != null) {
            switch (check) {
                case "edit":
                    y.updateTime(id, slot, startTime, endTime, desc);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    y.deleteTime(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    System.out.println("Add");
                    y.addTime(slot, startTime, endTime, desc);
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
