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
import models.Subject;
import utils.SQL;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class SubjectDAO {

    String subjectID;
    String subjectName;
    int subjectNoCredit;
    String subjectPrerequisite;
    String subjectDescription;
    int status;

    public List<Subject> getAllList() {
        ResultSet rs;
        String query = "SELECT * FROM dbo.Subject";
        List<Subject> list = new ArrayList<>();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                status = rs.getInt("status");
                if (status > -1){
                list.add(new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription, status));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Subject getSubject(String subjectID) {
        ResultSet rs = null;
        Subject getS = null;
        String query = "SELECT Subject.* FROM Subject WHERE SubjectID=?";
        try {
            rs = SQL.executeQuery(query, subjectID);
            while (rs.next()) {
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                status = rs.getInt("status");
                getS = (new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getS;
    }

    public int deleteSubject(String subjectID) {
        int rs = -1;
        String query = "UPDATE Subject"
                + " SET Status = -1"
                + " WHERE SubjectID=?";
        try {
            rs = SQL.executeUpdate(query, subjectID);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateSubject(String subjectID, String subjectName, int subjectNoCredit, String subjectPrerequisite, String subjectDescription) {
        int rs = -1;
        String query = "UPDATE Subject"
                + " SET SubjectName=?, SubjectNoCredit=?, SubjectPrerequisite=?,SubjectDescription=?"
                + " WHERE SubjectID=?";
        try {
            rs = SQL.executeUpdate(query, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription, subjectID);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateSubjectStatus(String subjectID, String subjectName, int subjectNoCredit, String subjectPrerequisite, String subjectDescription) {
        int rs = -1;
        String query = "UPDATE Subject"
                + " SET Status = 0, SubjectName=?, SubjectNoCredit=?, SubjectPrerequisite=?,SubjectDescription=?"
                + " WHERE SubjectID=?";
        try {
            rs = SQL.executeUpdate(query, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription, subjectID);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addSubject(String subjectID, String subjectName, int subjectNoCredit, String subjectPrerequisite, String subjectDescription) {
        int rs = -1;
        String query = "INSERT INTO [Subject](SubjectID,SubjectName,SubjectNoCredit,SubjectPrerequisite,SubjectDescription) VALUES (?,?,?,?,?)";
        try {
            rs = SQL.executeUpdate(query, subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
