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

public class ScheduleController extends HttpServlet {

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
            request.setAttribute("scheduleList", list);
            request.getRequestDispatcher("schedule.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("schedule", w.getSchedule(id));
                    request.getRequestDispatcher("editSchedule.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("schedule", w.getSchedule(id));
                    System.out.println(id);
                    request.getRequestDispatcher("deleteSchedule.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addSchedule.jsp");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathController = "ScheduleController";
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        System.out.println("id param" + idParam);
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        int groupSubjectID = Integer.parseInt(request.getParameter("groupSubjectID"));
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        // In ra để kiểm tra
        System.out.println("Check: " + check);
        System.out.println("ID: " + id);
        System.out.println("GroupSubjectID: " + groupSubjectID);
        System.out.println("StartDate: " + startDate);
        System.out.println("EndDate: " + endDate);

        ScheduleDAO y = new ScheduleDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    System.out.println("edit");
                    y.updateSchedule(id, groupSubjectID, startDate, endDate);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    System.out.println(id + " " + groupSubjectID);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
