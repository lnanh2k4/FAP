/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
 * @author CE180117 - Dang Cong Khanh
 */
public class ScheduleDAO {
    ScheduleDAO sd;
    int ScheduleID;
    int GroupSubjectID;
    LocalDate startDate;
    LocalDate endDate;
    
    public List<ScheduleDAO> getAllList() {
        ResultSet rs = null;
        List<ScheduleDAO> list = new ArrayList<>();
        String query = "SELECT * FROM GroupSubject INNER JOIN Subject ON GroupSubject.SubjectID = Subject.SubjectID INNER JOIN  [Group] ON GroupSubject.GroupID = [Group].GroupID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                gs = (ScheduleDAO) rs.getObject("gs");
                groupSubjectID = rs.getInt("groupSubjectID");
                subjectID = (Subject) rs.getObject("subjectID");
                groupID = (Group) rs.getObject("groupID");
                list.add(new ScheduleDAO(groupSubjectID, subjectID, groupID));
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
