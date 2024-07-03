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
import models.Major;
import utils.SQL;

/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class MajorDAO {
    String majorID;
    String majorName;
    public List<Major> getAllList(){
        ResultSet rs = null;
        String query = "SELECT Major.* FROM Major";
        List<Major> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                list.add(new Major(majorID, majorName));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public int addMajor(){
        return -1;
    }
}
