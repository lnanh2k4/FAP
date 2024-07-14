/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Semester;
import models.Week;
import utils.SQL;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class WeekDAO {

    Week week;
    int weekID;
    String weekStartDate;
    String weekEndDate;
    LocalDate semesterStartDate;
    LocalDate semesterEndDate;
    String semesterID;
    String semesterName;
    String yearID;
    int status;

    public List<Week> getAllList() {
        ResultSet rs = null;
        String query = "SELECT s.YearID as [Year ID], s.semesterID as [semesterID], s.semesterName as [semesterName], w.weekID as [weekID], w.startDate as [Week Start Date], w.endDate as [Week End Date], s.startDate as [Semester Start Date], s.endDate as [Semester End Date], w.status as [Status] FROM Week w INNER JOIN Semester s ON w.SemesterID = s.SemesterID ORDER BY [weekID] ASC";
        List<Week> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                yearID = rs.getString(1);
                semesterID = rs.getString(2);
                semesterName = rs.getString(3);
                weekID = rs.getInt(4);
                weekStartDate = rs.getString(5);
                weekEndDate = rs.getString(6);
                semesterStartDate = rs.getDate(7).toLocalDate();
                semesterEndDate = rs.getDate(8).toLocalDate();
                status = rs.getInt(9);
                if (status != -1) {
                    list.add(new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, yearID), status));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Week getWeek(int weekID) {
        ResultSet rs = null;
        Week gw = null;
        String query = "SELECT s.YearID as [Year ID], s.semesterID as [semesterID], s.semesterName as [semesterName], w.weekID as [weekID], w.startDate as [Week Start Date], w.endDate as [Week End Date], s.startDate as [Semester Start Date], s.endDate as [Semester End Date], w.status as [Status] FROM Week w INNER JOIN Semester s ON w.SemesterID = s.SemesterID WHERE weekID=?";
        try {
            rs = SQL.executeQuery(query, weekID);
            while (rs.next()) {
                yearID = rs.getString(1);
                semesterID = rs.getString(2);
                semesterName = rs.getString(3);
                weekID = rs.getInt(4);
                weekStartDate = rs.getString(5);
                weekEndDate = rs.getString(6);
                semesterStartDate = rs.getDate(7).toLocalDate();
                semesterEndDate = rs.getDate(8).toLocalDate();
                status = rs.getInt(9);
                if (status > -1) {
                    gw = new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, yearID), status);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gw;
    }

    public int deleteWeek(int weekID) {
        int rs = -1;
        String query = "UPDATE Week"
                + " SET status=-1"
                + " WHERE WeekID=?";

        try {
            rs = SQL.executeUpdate(query, weekID);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateWeek(int weekID, String semesterID, String startDate, String endDate) {
        int rs = -1;
        String query = "UPDATE Week"
                + " SET SemesterID=?, startDate=?,endDate=?"
                + " WHERE WeekID=?";

        try {
            rs = SQL.executeUpdate(query, semesterID, startDate, endDate, weekID);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addWeek(String semesterID, String startDate, String endDate) {
        int rs = -1;
        String query = "INSERT INTO Week(SemesterID, StartDate, EndDate) VALUES (?,?,?)";

        try {
            rs = SQL.executeUpdate(query, semesterID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
