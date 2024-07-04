/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
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
    String YearID;
    int status;
    public List<Week> getAllList() {
        ResultSet rs = null;
        String query = "SELECT * FROM Week INNER JOIN Semester ON Week.SemesterID = Semester.SemesterIDSELECT * FROM Week INNER JOIN Semester ON Week.SemesterID = Semester.SemesterID";
        List<Week> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                YearID = rs.getString("YearID");
                semesterID = rs.getString("semesterID");
                semesterName = rs.getString("semesterName");
                weekID = rs.getInt("weekID");
                weekStartDate = rs.getString("startDate");
                weekEndDate = rs.getString("endDate");
                semesterStartDate = rs.getDate("startDate").toLocalDate();
                semesterEndDate = rs.getDate("endDate").toLocalDate();
                status = rs.getInt("status");
                list.add(new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, YearID),status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Week getWeek() {
        ResultSet rs = null;
        Week gw = null;
        String query = "SELECT * FROM Week INNER JOIN Semester ON Week.SemesterID = Semester.SemesterIDSELECT * FROM Week INNER JOIN Semester ON Week.SemesterID = Semester.SemesterID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                YearID = rs.getString("YearID");
                semesterID = rs.getString("semesterID");
                semesterName = rs.getString("semesterName");
                weekID = rs.getInt("weekID");
                weekStartDate = rs.getString("startDate");
                weekEndDate = rs.getString("endDate");
                semesterStartDate = rs.getDate("startDate").toLocalDate();
                semesterEndDate = rs.getDate("endDate").toLocalDate();
                gw = new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, YearID),status);
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
                + " SET status=0"
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
    
    public int updateWeek(String semesterID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "UPDATE Week"
                + " SET WeekID=?, StartTime=?,EndTime=?"
                + " WHERE WeekID=?";

        try {
            rs = SQL.executeUpdate(query, semesterID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public int addTime(int weekID ,String semesterID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "INSERT INTO Week(WeekID, WeekID, StartDate, EndDate) VALUES (?,?,?,?)";


        try {
            rs = SQL.executeUpdate(query, weekID, semesterID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  

        return rs;
    }
}
