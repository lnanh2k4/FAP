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
import models.Curriculum;
import models.Major;
import models.Specialization;
import models.User;
import models.UserCampus;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class UserCampusDAO {
    
    int userCampusID;
    Campus campusID;
    User userID;
    int status;
    CampusDAO c = new CampusDAO();
    UserDAO u = new UserDAO();
    
    public List<UserCampus> getAllList() {
        ResultSet rs = null;
        List<UserCampus> list = new ArrayList<>();
        String query = "SELECT * FROM UserCampus";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                userCampusID = rs.getInt("userCampusID");                
                campusID = c.getCampus(rs.getString("campusID"));
                userID = u.getUserByUserID(rs.getString("userID"));
                status = rs.getInt("status");
                list.add(new UserCampus(userCampusID, campusID, userID, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public UserCampus getUserCampus(String userID) {
        ResultSet rs = null;
        UserCampus uc = null;
        String query = "SELECT * FROM UserCampus WHERE UserCampus.userID=?";
        try {
            rs = SQL.executeQuery(query, userID);
            while (rs.next()) {
                userCampusID = rs.getInt("userCampusID");                
                campusID = c.getCampus(rs.getString("campusID"));
                status = rs.getInt("status");
                uc = new UserCampus(userCampusID, campusID, u.getUserByUserID(userID), status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uc;
    }
    
    public int deleteUserCampus(String userCampusID) {
        int rs = -1;
        String query = "UPDATE UserCampus"
                + " SET status=-1"
                + " WHERE UserCampusID=?";
        
        try {
            rs = SQL.executeUpdate(query, userCampusID);
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public int addUserCampus(String campusID, String userID) {
        int rs = -1;
        String query = "INSERT INTO UserCampus(campusID,userID) VALUES (?,?)";
        try {
            rs = SQL.executeUpdate(query, campusID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
