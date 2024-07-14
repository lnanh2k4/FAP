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
import models.Group;
import models.Semester;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class GroupDAO {

    int groupID;
    String groupName;
    String semesterID;
    int status;

    public List<Group> getAllList() {
        ResultSet rs = null;
        List<Group> list = new ArrayList<>();
        String query = "SELECT g.GroupID, g.GroupName, g.SemesterID, g.Status FROM [Group] g INNER JOIN Semester s ON g.SemesterID = s.SemesterID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                groupID = rs.getInt("groupID");
                groupName = rs.getString("groupName");
                semesterID = rs.getString("semesterID");
                status = rs.getInt("status");
                list.add(new Group(groupID, groupName, new Semester(semesterID), status));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Group getGroup(int groupID) {
        ResultSet rs = null;
        Group getG = null;
        String query = "SELECT g.GroupID, g.GroupName, g.SemesterID, g.Status, s.SemesterID as SemID, s.SemesterName "
                + "FROM [Group] g "
                + "JOIN [Semester] s ON g.SemesterID = s.SemesterID "
                + "WHERE g.GroupID = ?";
        try {
            rs = SQL.executeQuery(query, groupID);
            if (rs.next()) {
                groupID = rs.getInt("groupID");
                groupName = rs.getString("groupName");
                semesterID = rs.getString("semesterID");
                status = rs.getInt("status");
                getG = new Group(groupID, groupName, new Semester(semesterID), status);
            }
        } catch (SQLException ex) { 
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getG;
    }

    public int deleteGroup(int groupID) {
        int result = -1;
        String query = "UPDATE [Group]"
                + " SET status=-1"
                + " WHERE groupID=?";
        try {
            result = SQL.executeUpdate(query, groupID);
        } catch (SQLException ex) { 
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateGroup(int groupID, String groupName, String semesterID) {
        int result = -1;
        String query = "UPDATE [Group] SET GroupName=? WHERE GroupID=? AND SemesterID=?";
        try {
            result = SQL.executeUpdate(query, groupName, groupID, semesterID);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int addGroup(String groupName, String semesterID) {
        int result = -1;
        String query = "INSERT INTO [Group](GroupName, SemesterID) VALUES (?, ?)";
        
        try {
            result = SQL.executeUpdate(query, groupName, semesterID);
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
