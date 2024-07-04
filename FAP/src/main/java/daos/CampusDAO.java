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
 * @author CE180191 - Huynh Hoang Ty
 */
public class CampusDAO {

    String campusID;
    String campusName;
    String campusAddress;
    String campusEmail;
    String campusHotline;
    int status;

    public List<Campus> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Campus.* FROM Campus";
        List<Campus> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                campusID = rs.getString("campusID");
                campusName = rs.getString("campusName");
                campusAddress = rs.getString("campusAddress");
                campusEmail = rs.getString("campusEmail");
                campusHotline = rs.getString("campusHotline");
                status = rs.getInt("status");
                list.add(new Campus(campusID, campusName, campusEmail, campusHotline,status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Campus getCampus() {
        ResultSet rs = null;
        Campus gc = null;
        String query = "SELECT Campus.* FROM Campus";

        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                campusID = rs.getString("campusID");
                campusName = rs.getString("campusName");
                campusAddress = rs.getString("campusAddress");
                campusEmail = rs.getString("campusEmail");
                campusHotline = rs.getString("campusHotline");
                gc = new Campus(campusID, campusName, campusEmail, campusHotline);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gc;
    }

    public int deleteCampus(String campusID) {
        int rs = -1;
        String query = "DELETE FROM Campus WHERE CampusID=?";
        try {
            rs = SQL.executeUpdate(query, campusID);
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateCampus(String campusID, String campusName, String campusAddress, String campusEmail, String campusHotline) {
        int rs = -1;
        String query = "UPDATE Campus"
                + " SET CampusName=?, CampusAddress=?, CampusEmail=?, CampusHotline=?"
                + " WHERE CampusID=?";
        try {
            rs = SQL.executeUpdate(query, campusName, campusAddress, campusEmail, campusHotline, campusID);
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addCampus(String campusID, String campusName, String campusAddress, String campusEmail, String campusHotline) {
        int rs = -1;
        String query = "INSERT INTO Campus(CampusID,CampusName,CampusAddress,CampusEmail,CampusHotline) VALUES (?,?,?,?,?)";
        try {
            rs = SQL.executeUpdate(query, campusID, campusName, campusAddress, campusEmail, campusHotline);
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
