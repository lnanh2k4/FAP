/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeInsert;

import daos.AttendanceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQL;

/**
 *
 * @author Khanh
 */
public class Attendance {
    
    public void randomizeAttendance(){
    AttendanceDAO attendanceDAO = new AttendanceDAO();
        
        String yearID = "2023"; 
        String semesterID = "S1"; 
        int weekID = 1; 
        int scheduleID = 1; 
        int scheduleDetailID = 1; 

        int updatedRows = attendanceDAO.randomizeAttendanceState(yearID, semesterID, weekID, scheduleID, scheduleDetailID);
        System.out.println("Updated rows: " + updatedRows);
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
