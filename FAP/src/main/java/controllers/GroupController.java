/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.GroupDAO;
import daos.SpecializationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.Group;

import models.Specialization;

/**
 *
 * @author mrmas
 */
public class GroupController extends HttpServlet {

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
        String check = request.getParameter("check");
        int id = Integer.parseInt(request.getParameter("id"));
        GroupDAO cu = new GroupDAO();
        if (check == null) {
            List<Group> list = cu.getAllList();
            request.setAttribute("groupList", list);
            request.getRequestDispatcher("group.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("group", cu.getGroup(id));
                    request.getRequestDispatcher("editGroup.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("group", cu.getGroup(id));
                    request.getRequestDispatcher("deleteGroup.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addGroup.jsp");
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
        String pathController = "GroupController";
        String check = request.getParameter("check");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("groupName");
        String idsp = request.getParameter("semesterID");
        GroupDAO cu = new GroupDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    cu.updateGroup(id, name, idsp);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    cu.deleteGroup(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    cu.addGroup(name, idsp);
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
