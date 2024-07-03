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
import models.Campus;
import utils.SQL;

/**
 *
 * @author mrmas
 */
public class CampusDAO {
    String campusID;
    String campusName;
    String campusAddress;
    String campusEmail;
    String campusHotline;
    public List<Campus> getAllList(){
        ResultSet rs = null;
        String query = "SELECT Campus.* FROM Campus";
        List<Campus> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
                campusID = rs.getString("campusID");
                campusName = rs.getString("campusName");
                campusAddress = rs.getString("campusAddress");
                campusEmail  = rs.getString("campusEmail");
                campusHotline = rs.getString("campusHotline");
                list.add(new Campus(campusID, campusName, campusEmail, campusHotline));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public int addCampus(){
        return -1;
    }
}
