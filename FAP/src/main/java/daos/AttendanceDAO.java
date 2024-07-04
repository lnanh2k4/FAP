/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
                at = new Attendance(attendanceID, scheduleDetailID, userID, state, comment, note, status);
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
        String query = "UPDATE Attendance"
                + " SET Status = 0"
                + "WHERE scheduleDetailID=? AND userID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateAttendance(int scheduleDetailID, String userID, int state, String comment, String note,
            int status) {
        int rs = -1;
        String query = "UPDATE Attendance"
                + " SET Atten State=?, Comment=?, Note=?"
                + " WHERE ScheduleDetailID=? AND UserID=?";
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
        String query = "INSERT INTO Attendance(ScheduleDetailID,userID) VALUES (?,?)";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int presentAll(int scheduleDetailID) {
        int rs = -1;
        String query = "UPDATE Attendance SET State = 1 WHERE ScheduleDetailID = ?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int absentAll(int scheduleDetailID) {
        int rs = -1;
        String query = "UPDATE Attendance SET State = 0 WHERE ScheduleDetailID = ?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int randomizeAttendanceState(String yearID, String semesterID, int weekID, int scheduleID, int scheduleDetailID) {
    int updatedRows = 0;
    String selectQuery = "SELECT UserID FROM Attendance "
                        + "INNER JOIN ScheduleDetail ON Attendance.ScheduleDetailID = ScheduleDetail.ScheduleDetailID "
                        + "INNER JOIN Schedule ON ScheduleDetail.ScheduleID = Schedule.ScheduleID "
                        + "INNER JOIN Week ON ScheduleDetail.WeekID = Week.WeekID "
                        + "INNER JOIN Semester ON Week.SemesterID = Semester.SemesterID "
                        + "INNER JOIN Year ON Semester.YearID = Year.YearID "
                        + "WHERE Year.YearID = ? AND Semester.SemesterID = ? AND Week.WeekID = ? AND Schedule.ScheduleID = ? AND Attendance.ScheduleDetailID = ?";
    List<String> userIDs = new ArrayList<>();
    
    try {
        ResultSet rs = SQL.executeQuery(selectQuery, yearID, semesterID, weekID, scheduleID, scheduleDetailID);
        while (rs.next()) {
            userIDs.add(rs.getString("UserID"));
        }
        
        Random random = new Random();
        for (String userID : userIDs) {
            int state = random.nextInt(100) < 80 ? 1 : 0;
            String updateQuery = "UPDATE Attendance SET State = ? WHERE ScheduleDetailID = ? AND UserID = ?";
            int result = SQL.executeUpdate(updateQuery, state, scheduleDetailID, userID);
            updatedRows += result;
        }
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return updatedRows;
}


}
