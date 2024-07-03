/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Week;
import utils.SQL;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class WeekDAO {
    Week week;
    int weekID;
    
    public List<Week> getAllList(){
        ResultSet rs = null;
        String query = "";
        List<Week> list = new ArrayList();
        try {
            Connection con = SQL.getConnection();
            SQL.executeQuery(query);
        } catch (SQLException ex) { 
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public int addWeek(){
        
    }
}
