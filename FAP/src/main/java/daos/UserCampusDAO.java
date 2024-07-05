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
import models.UserCampus;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class UserCampusDAO {
    int userCampusID;
    String campusID;
    String userID;
    int status;
    public List<UserCampus> getAllList() {
        ResultSet rs = null;
        List<UserCampus> list = new ArrayList<>();
        String query = "SELECT * FROM UserCampus INNER JOIN Campus ON UserCampus.CampusID = Campus.CampusID INNER JOIN [User] ON UserCampus.UserID = [User].UserID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                userCampusID = rs.getInt("userCampusID");
                campusID = rs.getString("campusID");
                userID = rs.getString("userID");
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
    
    public UserCampus getUserCampus() {
        ResultSet rs = null;
        UserCampus uc = null;
        String query = "SELECT * FROM UserCampus INNER JOIN Campus ON UserCampus.CampusID = Campus.CampusID INNER JOIN [User] ON UserCampus.UserID = [User].UserID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                userCampusID = rs.getInt("userCampusID");
                campusID = rs.getString("campusID");
                userID = rs.getString("userID");
                uc = new UserCampus(userCampusID, campusID, userID, status);
            }
        } catch (SQLException ex) { 
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return uc;
    }
    
    public int deleteUserCampus(String campusID, String userID) {
        int rs = -1;
        String query = "UPDATE UserCampus"
                + " SET Status = 0"
                + " WHERE CampusID=? AND UserID=?";
        try {
            rs = SQL.executeUpdate(query, campusID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCampusDAO.class.getName()).log(Level.SEVERE, null, ex);
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
