/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import daos.MajorDAO;
import daos.RoomDAO;
import daos.YearDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import models.Major;
import models.Room;
import models.Year;

/**
 *
 * @author mrmas
 */
public class RoomController extends HttpServlet {

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
        String id = (String) request.getParameter("id");
        RoomDAO y = new RoomDAO();
        if (check == null) {
            List<Room> list = y.getAllList();
            request.setAttribute("roomList", list);
            request.getRequestDispatcher("room.jsp").forward(request, response);
        } else {
            switch (check) {
                case "edit":
                    request.setAttribute("room", y.getRoom(id));
                    request.getRequestDispatcher("editRoom.jsp").forward(request, response);
                    break;
                case "delete":
                    request.setAttribute("room", y.getRoom(id));
                    request.getRequestDispatcher("deleteRoom.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addRoom.jsp");
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
        String pathController = "RoomController";
        String check = request.getParameter("check");
        String id = request.getParameter("roomID");
        String roomName = request.getParameter("roomName");
        RoomDAO y = new RoomDAO();
        System.out.println(check);
        if (check != null) {
            switch (check) {
                case "edit":
                    y.updateRoom(id, roomName);
                    response.sendRedirect(pathController);
                    break;
                case "delete":
                    y.deleteRoom(id);
                    response.sendRedirect(pathController);
                    break;
                case "add":
                    //System.out.println("check exist room : " + y.checkexist(id));
                    if (y.checkexist(id)) {
                        //System.out.println("Room : " + y.getRoom(id).getRoomID());
                        //System.out.println("check status of room : " + y.getRoom(id).getStatus());
                        if (y.getRoom(id).getStatus() == -1) {
                            y.updateRoom(id, roomName);
                            y.setStatus(id);
                            System.out.println(y.getRoom(id).getStatus());
                            response.sendRedirect(pathController);
                            break;
                        } else {
                            String erorrMessage = "This Room has existed";
                            request.setAttribute("errorAddRoom", erorrMessage);
                            request.getRequestDispatcher("addRoom.jsp").forward(request, response);
                            break;
                        }

                    } else {
                        y.addRoom(id, roomName);
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
