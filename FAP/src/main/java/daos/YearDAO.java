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
        String query = "SELECT * FROM dbo.Year";
        List<Year> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            System.out.println("Row " + rs.getRow());
            while (rs.next()) {
                yearID = rs.getString("yearID");
                startDate = rs.getDate("StartDate").toLocalDate();
                endDate = rs.getDate("EndDate").toLocalDate();
                status = rs.getInt("status");
                if (status > -1) {
                    list.add(new Year(yearID, startDate, endDate, status));
                }
            }
            list.size();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public Year getYear(String yearID) {
        ResultSet rs = null;
        Year gy = null;
        String query = "SELECT Year.* FROM Year WHERE YearID=?";
        try {
            rs = SQL.executeQuery(query, yearID);
            while (rs.next()) {
                yearID = rs.getString("yearID");
                startDate = rs.getDate("startDate").toLocalDate();
                endDate = rs.getDate("endDate").toLocalDate();
                status = rs.getInt("status");
                gy = new Year(yearID, startDate, endDate, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gy;
    }

    public int deleteYear(String yearID) {
        int rs = -1;
        String query = "UPDATE Year"
                + " SET Status = -1"
                + " WHERE YearID=?";

        try {
            rs = SQL.executeUpdate(query, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateYear(String yearID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "UPDATE Year"
                + " SET StartDate=?,EndDate=?"
                + " WHERE YearID=?";

        try {
            rs = SQL.executeUpdate(query, startDate, endDate, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addYear(String yearID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "INSERT INTO Year(YearID,StartDate, EndDate) VALUES (?,?,?)";
        try {
            rs = SQL.executeUpdate(query, yearID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int setStatus(String yearID) {
        int rs = -1;
        String query = "UPDATE Year"
                + " SET Status = 0"
                + " WHERE YearID=?";

        try {
            rs = SQL.executeUpdate(query, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public boolean checkexist(String yearID, LocalDate startDate, LocalDate endDate) {
        //Year year_cur = new Year();
        //year_cur = getYear(yearID);
        if (getYear(yearID) == null) {
            return false;
        } else {
            return true;
        }
    }
}
