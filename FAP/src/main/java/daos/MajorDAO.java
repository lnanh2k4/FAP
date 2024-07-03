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
 * @author CE180191 - Huynh Hoang Ty
 */
public class MajorDAO {

    String majorID;
    String majorName;

    public List<Major> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Major.* FROM Major";
        List<Major> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                list.add(new Major(majorID, majorName));
            }
<<<<<<< HEAD
        } catch (SQLException ex) { 
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
=======
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
>>>>>>> 5857691ecbece3f42dabb4544341e21380b26114
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
<<<<<<< HEAD
    public Major getMajor(){
        ResultSet rs = null;
        Major getM = null ;
       String query = "SELECT Major.* FROM Major";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                getM= (new Major(majorID, majorName));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getM;
=======

    public Major getMajor() {
        ResultSet rs = null;
        Major gm = null;
        String query = "SELECT Major.* FROM Major";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                gm = new Major(majorID, majorName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gm;
    }

    public int addMajor() {
        return -1;
>>>>>>> 5857691ecbece3f42dabb4544341e21380b26114
    }
}
