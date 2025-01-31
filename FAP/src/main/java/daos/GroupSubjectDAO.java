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
import models.GroupSubject;
import models.Semester;
import models.Subject;
import utils.SQL;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class GroupSubjectDAO {

    int groupSubjectID;
    String subjectID;
    String subjectName;
    int subjectNoCredit;
    String subjectPrerequisite;
    String subjectDescription;
    int groupID;
    String groupName;
    String semesterID;
    int status;

    public List<GroupSubject> getAllList() {
        ResultSet rs = null;
        List<GroupSubject> list = new ArrayList<>();
        String query = "SELECT * FROM GroupSubject INNER JOIN Subject ON GroupSubject.SubjectID = Subject.SubjectID INNER JOIN  [Group] ON GroupSubject.GroupID = [Group].GroupID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                groupSubjectID = rs.getInt("groupSubjectID");
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                groupID = rs.getInt("groupID");
                groupName = rs.getString("groupName");
                semesterID = rs.getString("semesterID");
                status = rs.getInt("status");
                list.add(new GroupSubject(groupSubjectID, new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription), new Group(groupID, groupName, new Semester(semesterID), status)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public GroupSubject getGroupSubject() {
        ResultSet rs = null;
        GroupSubject gs = null;
        String query = "SELECT * FROM GroupSubject INNER JOIN Subject ON GroupSubject.SubjectID = Subject.SubjectID INNER JOIN  [Group] ON GroupSubject.GroupID = [Group].GroupID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                groupSubjectID = rs.getInt("groupSubjectID");
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                groupID = rs.getInt("groupID");
                groupName = rs.getString("groupName");
                semesterID = rs.getString("semesterID");

                status = rs.getInt("status");
                gs = new GroupSubject(groupSubjectID, new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription), new Group(groupID, groupName, new Semester(semesterID), status));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gs;
    }

    public int deleteGroupSubject(Subject subjectID, Group groupID) {
        int rs = -1;

        String query = "UPDATE GroupSubject"
                + " SET Status = 0"
                + " WHEREE GroupID=? AND SubjectID=?";
        try {
            rs = SQL.executeUpdate(query, subjectID, groupID);
        } catch (SQLException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GroupSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
