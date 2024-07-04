/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ScheduleDetail;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class ScheduleDetailDAO {

    int scheduleDetailID;
    int scheduleID;
    String roomID;
    String userID;
    int timeID;
    String campusID;
    int weekID;
    String schlDescription;
    int subjectSession;
    LocalDate date;
    int status;

    public List<ScheduleDetail> getAllList() {
        ResultSet rs = null;
        List<ScheduleDetail> list = new ArrayList<>();
        String query = "SELECT * FROM ScheduleDetail INNER JOIN"
                + " Schedule ON ScheduleDetail.ScheduleID = Schedule.ScheduleID INNER JOIN"
                + " Room ON ScheduleDetail.RoomID = Room.RoomID INNER JOIN"
                + " [User] ON ScheduleDetail.LecturerID = [User].UserID INNER JOIN"
                + " Time ON ScheduleDetail.TimeID = Time.TimeID INNER JOIN"
                + " Campus ON ScheduleDetail.CampusID = Campus.CampusID INNER JOIN"
                + " Week ON ScheduleDetail.WeekID = Week.WeekID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                scheduleDetailID = rs.getInt(scheduleDetailID);
                scheduleID = rs.getInt(scheduleID);
                roomID = rs.getString("roomID");
                userID = rs.getString("userID");
                timeID = rs.getInt(timeID);
                campusID = rs.getString("campusID");
                weekID = rs.getInt(weekID);
                schlDescription = rs.getString("schlDescription");
                subjectSession = rs.getInt(subjectSession);
                date = (LocalDate) rs.getObject("date");
                status = rs.getInt("status");
                list.add(new ScheduleDetail(scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID, schlDescription, subjectSession, date, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ScheduleDetail getScheduleDetail() {
        ResultSet rs = null;
        ScheduleDetail sd = null;
        String query = "SELECT * FROM ScheduleDetail INNER JOIN"
                + " Schedule ON ScheduleDetail.ScheduleID = Schedule.ScheduleID INNER JOIN"
                + " Room ON ScheduleDetail.RoomID = Room.RoomID INNER JOIN"
                + " [User] ON ScheduleDetail.LecturerID = [User].UserID INNER JOIN"
                + " Time ON ScheduleDetail.TimeID = Time.TimeID INNER JOIN"
                + " Campus ON ScheduleDetail.CampusID = Campus.CampusID INNER JOIN"
                + " Week ON ScheduleDetail.WeekID = Week.WeekID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                scheduleDetailID = rs.getInt(scheduleDetailID);
                scheduleID = rs.getInt(scheduleID);
                roomID = rs.getString("roomID");
                userID = rs.getString("userID");
                timeID = rs.getInt(timeID);
                campusID = rs.getString("campusID");
                weekID = rs.getInt(weekID);
                schlDescription = rs.getString("schlDescription");
                subjectSession = rs.getInt(subjectSession);
                date = (LocalDate) rs.getObject("date");
                sd = new ScheduleDetail(scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID, schlDescription, subjectSession, date);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sd;
    }

    public int deleteScheduleDetail(int scheduleDetailID, int scheduleID, String roomID, String userID, int timeID, String campusID, int weekID) {
        int rs = -1;
        String query = "DELETE FROM ScheduleDetail WHERE scheduleDetailID=?, scheduleID=?, roomID=?, userID=?, timeID=?, campusID=?, weekID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateScheduleDetail(int scheduleDetailID, int scheduleID, String roomID, String userID, int timeID, String campusID, int weekID) {
        int rs = -1;
        String query = "UPDATE ScheduleDetail"
                + " SET scheduleDetailID=?, scheduleID=?, roomID=?, userID=?, timeID=?, campusID=?, weekID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addScheduleDetail(int scheduleDetailID, int scheduleID, String roomID, String userID, int timeID, String campusID, int weekID) {
        int rs = -1;
        String query = "INSERT INTO ScheduleDetail(scheduleDetailID,scheduleID,roomID,userID,timeID,campusID,weekID) VALUES (?,?,?,?,?,?,?)";
        try {
            rs = SQL.executeUpdate(query, scheduleDetailID, scheduleID, roomID, userID, timeID, campusID, weekID);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
