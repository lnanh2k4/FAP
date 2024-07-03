/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Group;
import models.GroupSubject;
import models.Subject;
import utils.SQL;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class GroupSubjectDAO {

    GroupSubject gs;
    int groupSubjectID;
    Subject subjectID;
    Group groupID;

    public List<GroupSubject> getAllList() {
        ResultSet rs = null;
        List<GroupSubject> list = new ArrayList<>();
        String query = "SELECT * FROM GroupSubject INNER JOIN Subject ON GroupSubject.SubjectID = Subject.SubjectID INNER JOIN  [Group] ON GroupSubject.GroupID = [Group].GroupID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                gs = (GroupSubject) rs.getObject("gs");
                groupSubjectID = rs.getInt("groupSubjectID");
                subjectID = (Subject) rs.getObject("subjectID");
                groupID = (Group) rs.getObject("groupID");
                list.add(new GroupSubject(groupSubjectID, subjectID, groupID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public int addGroupSubject(String subjectID, int groupID){
        int rs=-1;

            String query="";
            

        return rs;
    }

}
