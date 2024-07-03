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
                list.add(new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, YearID)));
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
                gw = new Week(weekID, weekStartDate, weekEndDate, new Semester(semesterID, semesterName, semesterStartDate, semesterEndDate, YearID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gw;
    }

    public int addWeek() {
        return -1;
    }
}
