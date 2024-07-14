/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.Subject;

/**
 *
 * @author mrmas
 */
public class SubjectController extends HttpServlet {

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
            out.println("<title>Servlet SubjectController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectController at " + request.getContextPath() + "</h1>");
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
        SubjectDAO s = new SubjectDAO();
        if (check == null) {
            List<Subject> list = s.getAllList();
            request.setAttribute("subjectList", list);
            request.getRequestDispatcher("subject.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("subject", s.getSubject(id));
                    request.getRequestDispatcher("editSubject.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("subject", s.getSubject(id));

                    request.getRequestDispatcher("deleteSubject.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addSubject.jsp");
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
        String pathController = "SubjectController";
        String check = request.getParameter("check");
        String id = request.getParameter("subjectID");
        String name = request.getParameter("subjectName");
        int nocredit = Integer.parseInt(request.getParameter("subjectNoCredit"));
        String prerequisite = request.getParameter("subjectPrerequisite");
        String description = request.getParameter("subjectDescription");
        SubjectDAO s = new SubjectDAO();
        if (check != null) {
            switch (check) {
                case "edit":
                    s.updateSubject(id, name, nocredit, prerequisite, description);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    System.out.println("id cua post");
                    s.deleteSubject(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    if (s.checkexist(id)) {
                        String erorrMessage = "This Subject has existed";
                        request.setAttribute("errorAddSubject", erorrMessage);
                        request.getRequestDispatcher("addSubject.jsp").forward(request, response);
                    } else {
                        s.addSubject(id, name, nocredit, prerequisite, description);
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
