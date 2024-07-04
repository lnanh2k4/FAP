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
import models.Year;
import utils.SQL;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class YearDAO {

    String yearID;
    LocalDate startDate;
    LocalDate endDate;
    int status;
    public List<Year> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Year.* FROM Year";
        List<Year> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                yearID = rs.getString("yearID");
                startDate = rs.getDate("startDate").toLocalDate();
                endDate = rs.getDate("endDate").toLocalDate();
                status = rs.getInt("status");
                list.add(new Year(yearID, startDate, endDate, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Year getYear() {
        ResultSet rs = null;
        Year gy = null;
        String query = "SELECT Year.* FROM Year";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                yearID = rs.getString("yearID");
                startDate = rs.getDate("startDate").toLocalDate();
                endDate = rs.getDate("endDate").toLocalDate();
                gy = new Year(yearID, startDate, endDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gy;
    }

    public int deleteYear(int yearID) {
        int rs = -1;
        String query = "DELETE FROM Year WHERE YearID=?";

        try {
            rs = SQL.executeUpdate(query, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateYear(LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "UPDATE Year"
                + " SET StartTime=?,EndTime=?"
                + " WHERE YearID=?";

        try {
            rs = SQL.executeUpdate(query, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addYear(String yearID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "INSERT INTO String(YearID,StartDate, EndDate) VALUES (?,?,?)";

        try {
            rs = SQL.executeUpdate(query, yearID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
