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
import models.Time;
import utils.SQL;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class TimeDAO {

    int timeID;
    int slot;
    LocalDate startTime;
    LocalDate endTime;
    String description;

    public List<Time> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Time.* FROM Time";
        List<Time> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                timeID = rs.getInt("timeID");
                slot = rs.getInt("slot");
                startTime = rs.getDate("startTime").toLocalDate();
                endTime = rs.getDate("endTime").toLocalDate();
                description = rs.getString("description");
                list.add(new Time(timeID, slot, startTime, endTime, description));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Time getTime() {
        ResultSet rs = null;
        Time gt = null;
        String query = "SELECT Time.* FROM Time";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                timeID = rs.getInt("timeID");
                slot = rs.getInt("slot");
                startTime = rs.getDate("startTime").toLocalDate();
                endTime = rs.getDate("endTime").toLocalDate();
                description = rs.getString("description");
                gt = new Time(timeID, slot, startTime, endTime, description);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gt;
    }

    public int deleteTime(int timeID) {
        int rs = -1;
        String query = "DELETE FROM Time WHERE TimeID=?";

        try {
            rs = SQL.executeUpdate(query, timeID);
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateTime(int slot, LocalDate startDate, LocalDate endDate, String description) {
        int rs = -1;
        String query = "UPDATE Time"
                + " SET Slot=?, StartTime=?,EndTime=?,Description=?"
                + " WHERE TimeID=?";

        try {
            rs = SQL.executeUpdate(query, slot, startDate, endDate, description);
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addTime(int timeID, int slot, LocalDate startDate, LocalDate endDate, String description) {
        int rs = -1;
        String query = "INSERT INTO Time(TimeID, Slot, StartDate, EndDate, Description) VALUES (?,?,?,?,?)";

        try {
            rs = SQL.executeUpdate(query, timeID, slot, startDate, endDate, description);
        } catch (SQLException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
