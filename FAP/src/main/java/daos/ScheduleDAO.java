/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Group;
import models.GroupSubject;
import models.Schedule;
import models.Subject;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class ScheduleDAO {

    int scheduleID;
    int groupSubjectID;
    LocalDate startDate;
    LocalDate endDate;
    int status;

    public List<Schedule> getAllList() {
        ResultSet rs = null;
        List<Schedule> list = new ArrayList<>();
        String query = "SELECT * FROM Schedule INNER JOIN GroupSubject ON Schedule.GroupSubjectID = GroupSubject.GroupSubjectID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                int scheduleID = rs.getInt("scheduleID");
                int groupSubjectID = rs.getInt("groupSubjectID");
                Date sqlStartDate = rs.getDate("startDate");
                Date sqlEndDate = rs.getDate("endDate");
                LocalDate startDate = sqlStartDate.toLocalDate(); 
                LocalDate endDate = sqlEndDate.toLocalDate();
                status = rs.getInt("status");
                list.add(new Schedule(scheduleID, groupSubjectID, startDate, endDate, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Schedule getSchedule(int scheduleID) {
        ResultSet rs = null;
        Schedule sc = null;
        String query = "SELECT Schedule.*, GroupSubject.GroupSubjectID AS Expr1 FROM Schedule INNER JOIN GroupSubject ON Schedule.GroupSubjectID = GroupSubject.GroupSubjectID WHERE ScheduleID=?";
        try {
            rs = SQL.executeQuery(query, scheduleID);
            while (rs.next()) {
                scheduleID = rs.getInt("scheduleID");
                groupSubjectID = rs.getInt("groupSubjectID");
                startDate = (LocalDate) rs.getObject("startDate");
                endDate = (LocalDate) rs.getObject("endDate");
                status = rs.getInt("status");
                sc = new Schedule(scheduleID, groupSubjectID, startDate, endDate, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sc;
    }

    public int deleteSchedule(int scheduleID, int groupSubjectID) {
        int rs = -1;
        String query = "UPDATE Schedule"
                + " SET Status = 0"
                + " WHERE ScheduleID=? AND GroupSubjectID=?";
        try {
            rs = SQL.executeUpdate(query, groupSubjectID);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateSchedule(int scheduleID, int groupSubjectID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "UPDATE Schedule"
                + " SET StartDate=?, EndDate=?"
                + " WHERE ScheduleID=? AND GroupSubjectID=?";
        try {
            rs = SQL.executeUpdate(query, scheduleID, groupSubjectID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addSchedule(int groupSubjectID, LocalDate startDate, LocalDate endDate) {
        int rs = -1;
        String query = "INSERT INTO Schedule(groupSubjectID,startDate,endDate) VALUES ?,?,?)";
        try {
            rs = SQL.executeUpdate(query, groupSubjectID, startDate, endDate);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
