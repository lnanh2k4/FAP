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
        String query = "SELECT * FROM [Group] INNER JOIN Semester ON [Group].SemesterID = Semester.SemesterID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                int groupID = rs.getInt("GroupID");
                String groupName = rs.getString("GroupName");
                String semesterID = rs.getString("SemesterID");
                int status = rs.getInt("Status");
                list.add(new Group(groupID, groupName, semesterID, status));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Group getGroup(String groupName, String semesterID) {
        ResultSet rs = null;
        Group group = null;
        String query = "SELECT * FROM [Group] WHERE GroupName=? AND SemesterID=?";
        try {
            rs = SQL.executeQuery(query, groupName, semesterID);
            if (rs.next()) {
                int groupID = rs.getInt("GroupID");
                int status = rs.getInt("Status");
                group = new Group(groupID, groupName, semesterID, status);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    public int deleteGroup(String groupName, String semesterID) {
        int result = -1;
        String query = "DELETE FROM [Group] WHERE GroupName=? AND SemesterID=?";
        try {
            result = SQL.executeUpdate(query, groupName, semesterID);
        } catch (SQLException | ClassNotFoundException ex) {
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

    public int addGroup(int groupID, String groupName, String semesterID) {
        int result = -1;
        String query = "INSERT INTO [Group](GroupID, GroupName, SemesterID) VALUES (?, ?, ?)";
        try {
            result = SQL.executeUpdate(query, groupID, groupName, semesterID);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
