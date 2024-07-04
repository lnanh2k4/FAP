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
    int status;
    public List<Major> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Major.* FROM Major";
        List<Major> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                status = rs.getInt("status");
                list.add(new Major(majorID, majorName, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Major getMajor() {
        ResultSet rs = null;
        Major getM = null;
        String query = "SELECT Major.* FROM Major";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                getM = (new Major(majorID, majorName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getM;

    }

    public int deleteMajor(String majorID) {
        int rs = -1;
        String query = "DELETE FROM Major WHERE MajorID=?";

        try {
            rs = SQL.executeUpdate(query, majorID);
        } catch (SQLException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateMajor(String majorID, String majorName) {
        int rs = -1;
        String query = "UPDATE Major"
                + " SET MajorName=?"
                + " WHERE MajorID=?";
        try {
            rs = SQL.executeUpdate(query, majorName, majorID);
        } catch (SQLException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public int addMajor(String majorID, String majorName) {
        int rs = -1;
        String query = "INSERT INTO Major(MajorID,MajorName) VALUES (?,?)";
        try {
            rs = SQL.executeUpdate(query, majorName, majorID);
        } catch (SQLException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MajorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
