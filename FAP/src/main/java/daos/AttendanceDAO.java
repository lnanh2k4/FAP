/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
                list.add(new Attendance(attendanceID, scheduleDetailID, userID, state, comment, note));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public int addAttendance(int attendanceID, int scheduleDetailID, String userID, int state, String comment, String note){
        int rs=-1;

            String query="";
            

        return rs;
    }
}
