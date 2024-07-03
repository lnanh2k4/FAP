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
    
    public List<Time> getAllList(){
        ResultSet rs = null;
        String query = "SELECT Time.* FROM Time";
        List<Time> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
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
    public int addTime(){
        return -1;
    }
}
