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
    String query = "SELECT g.GroupID, g.GroupName, g.SemesterID, g.Status, s.SemesterID as SemID, s.SemesterName " +
                   "FROM dbo.[Group] g " +
                   "JOIN dbo.[Semester] s ON g.SemesterID = s.SemesterID";
    try {
        rs = SQL.executeQuery(query);
        while (rs.next()) {
            int groupID = rs.getInt("GroupID");
            String groupName = rs.getString("GroupName");
            String semesterID = rs.getString("SemesterID");
            int status = rs.getInt("Status");
            list.add(new Group(groupID, groupName,  semesterID));
        }
    } catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}


    public Group getGroup(int groupID) {
        ResultSet rs = null;
        Group getG = null;
        String query = "SELECT [Group].* FROM [Group] WHERE groupID=?";
        try {
            rs = SQL.executeQuery(query, groupName, semesterID);
            if (rs.next()) {
                groupID = rs.getInt("GroupID");
                groupName = rs.getString("GroupName");
                semesterID = rs.getString("SemesterID");
                status = rs.getInt("Status");
                getG = new Group(groupID, groupName, semesterID, status);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getG;
    }

    public int deleteGroup(int groupID) {
        int result = -1;
        String query = "UPDATE [Group]"
                + " SET status=-1"
                + " WHERE groupID=?";;
        try {
            result = SQL.executeUpdate(query, groupID);
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
