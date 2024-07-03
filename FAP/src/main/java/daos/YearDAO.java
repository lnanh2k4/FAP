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
    private String yearID;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public List<Year> getAllList(){
        ResultSet rs = null;
        String query = "SELECT Year.* FROM Year";
        List<Year> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
                yearID = rs.getString("yearID");
                startDate = rs.getDate("startDate").toLocalDate();
                endDate = rs.getDate("endDate").toLocalDate();
                list.add(new Year(yearID, startDate, endDate));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public int addYear(){
        return -1;
    }
}
