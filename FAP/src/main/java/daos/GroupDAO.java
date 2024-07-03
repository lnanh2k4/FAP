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
    
    public List<Group> getAllList() {
        ResultSet rs = null;
        List<Group> list = new ArrayList<>();
        String query = "SELECT * FROM [Group] INNER JOIN Semester ON [Group].SemesterID = Semester.SemesterID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                groupID = rs.getInt("GroupID");
                groupName = (String) rs.getObject("groupName");
                semesterID = (String) rs.getObject("semesterID");
                list.add(new Group(groupID, groupName, semesterID));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int addGroup(int groupID, String groupName, String semesterID){
        int rs=-1;

            String query="";
            

        return rs;
    }
}
