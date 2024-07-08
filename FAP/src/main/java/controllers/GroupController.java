/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.GroupDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Group;

/**
 *
 * @author Khanh
 */
public class GroupController extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        System.out.println(id);
        GroupDAO g = new GroupDAO();
        if (check == null) {
            List<Group> list = g.getAllList();
            request.setAttribute("groupList", list);
            request.getRequestDispatcher("group.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("group", g.getGroup(id));
                    request.getRequestDispatcher("editGroup.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("group", id);
                    request.getRequestDispatcher("deleteGroup.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addGroup.jsp");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathController = "GroupController";
        String check = request.getParameter("check");
        String idParam = request.getParameter("id");
        System.out.println("id param" + idParam);
        int id = idParam != null ? Integer.parseInt(idParam) : -1;
        String groupName = request.getParameter("groupName");
        String semesterID = request.getParameter("semesterID");
        int groupID = Integer.parseInt(request.getParameter("groupID"));
        GroupDAO groupDAO = new GroupDAO();

        if (check != null) {
            switch (check) {
                case "edit":
                    groupDAO.updateGroup(groupID, groupName, semesterID);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    groupDAO.deleteGroup(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    groupDAO.addGroup(groupID, groupName, semesterID);
                    response.sendRedirect(pathController);
                    break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Group Management Servlet";
    }
}
