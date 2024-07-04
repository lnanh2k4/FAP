/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Attendance;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class AttendanceDAO {

    int attendanceID;
    int scheduleDetailID;
    String userID;
    int state;
    String comment;
    String note;
    int status;

    public List<Attendance> getAllList() {
        ResultSet rs = null;
        List<Attendance> list = new ArrayList<>();
        String query = "SELECT * FROM Attendance INNER JOIN [User] ON Attendance.UserID = [User].UserID CROSS JOIN Campus";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                attendanceID = rs.getInt("attendanceID");
                scheduleDetailID = rs.getInt("scheduleDetailID");
                userID = rs.getString("userID");
                state = rs.getInt("state");
                comment = rs.getString("comment");
                note = rs.getString("note");
                status = rs.getInt("status");
                list.add(new Attendance(scheduleDetailID, userID, state, comment, note, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Attendance getAttendance() {
        ResultSet rs = null;
        Attendance at = null;
        String query = "SELECT * FROM Attendance INNER JOIN [User] ON Attendance.UserID = [User].UserID CROSS JOIN Campus";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                attendanceID = rs.getInt("attendanceID");
                scheduleDetailID = rs.getInt("scheduleDetailID");
                userID = rs.getString("userID");
                state = rs.getInt("state");
                comment = rs.getString("comment");
                note = rs.getString("note");
                status = rs.getInt("status");
                at = new Attendance(attendanceID, scheduleDetailID, userID, state, comment, note,status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return at;
    }

    public int deleteAttendance(int scheduleDetailID, String userID) {
        int rs = -1;
        String query = "DELETE FROM Attendance WHERE scheduleDetailID=?, userID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateAttendance(int scheduleDetailID, String userID) {
        int rs = -1;
        String query = "UPDATE Attendance"
                + " SET scheduleDetailID=?, userID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addAttendance(int scheduleDetailID, String userID) {
        int rs = -1;
        String query = "INSERT INTO Attendance(scheduleDetailID,userID) VALUES (?,?)";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
