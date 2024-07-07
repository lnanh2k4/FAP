/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.ScheduleDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import models.ScheduleDetail;

/**
 *
 * @author Khanh
 */
public class ScheduleDetailController extends HttpServlet {

    ScheduleDetailDAO sd = new ScheduleDetailDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ScheduleDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ScheduleDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        int id = idParam != null ? Integer.parseInt(idParam) : -1;

        ScheduleDetailDAO dao = new ScheduleDetailDAO();

        if (action == null) {
            List<ScheduleDetail> list = dao.getAllList();
            request.setAttribute("scheduleDetailList", list);
            request.getRequestDispatcher("scheduleDetail.jsp").forward(request, response);
        } else {
            switch (action) {
                case "edit":
                    request.setAttribute("scheduleDetail", dao.getScheduleDetail(id));
                    request.getRequestDispatcher("editScheduleDetail.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("scheduleDetail", dao.getScheduleDetail(id));
                    request.getRequestDispatcher("deleteScheduleDetail.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addScheduleDetail.jsp");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ScheduleDetailDAO dao = new ScheduleDetailDAO();

        int scheduleDetailID = request.getParameter("scheduleDetailID") != null
                ? Integer.parseInt(request.getParameter("scheduleDetailID"))
                : -1;
        int scheduleID = Integer.parseInt(request.getParameter("scheduleID"));
        String roomID = request.getParameter("roomID");
        String userID = request.getParameter("userID");
        int timeID = Integer.parseInt(request.getParameter("timeID"));
        String campusID = request.getParameter("campusID");
        int weekID = Integer.parseInt(request.getParameter("weekID"));
        String schlDescription = request.getParameter("schlDescription");
        int subjectSession = Integer.parseInt(request.getParameter("subjectSession"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int status = Integer.parseInt(request.getParameter("status"));

        if (action != null) {
            switch (action) {
                case "edit":
                    dao.updateScheduleDetail(scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID, schlDescription, subjectSession, date, status);
                    break;
                case "delete":
                    dao.deleteScheduleDetail(scheduleDetailID);
                    break;
                case "add":
                    dao.addScheduleDetail(scheduleID, roomID, userID, timeID, campusID, weekID, schlDescription, subjectSession, date, status);
                    break;
            }
        }
        response.sendRedirect("ScheduleDetailController");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
