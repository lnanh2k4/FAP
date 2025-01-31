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
import models.Curriculum;
import models.CurriculumDetail;
import models.Major;
import models.Specialization;
import utils.SQL;
import models.Subject;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class CurriculumDetailDAO {

    String subjectID;
    String subjectName;
    int subjectNoCredit;
    String subjectPrerequisite;
    String subjectDescription;
    String curriculumID;
    String curriculumName;
    String specializationID;
    String specializationName;
    String majorID;
    String majorName;
    int cdSemester;
    int status;

    public List<CurriculumDetail> getAllList() {
        ResultSet rs = null;
        List<CurriculumDetail> list = new ArrayList<>();
        String query = "SELECT*FROM CurriculumDetail INNER JOIN Subject ON CurriculumDetail.SubjectID = Subject.SubjectID INNER JOIN Curriculum ON CurriculumDetail.CurriculumID = Curriculum.CurriculumID INNER JOIN Specialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOIN Major ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                cdSemester = rs.getInt("cdSemester");
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");

                status = rs.getInt("status");
                list.add(new CurriculumDetail(new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription), new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), cdSemester, status));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public CurriculumDetail getCurriculumDetail() {
        ResultSet rs = null;
        CurriculumDetail getCD = null;

        String query = "SELECT*FROM[User] INNER JOINCurriculum ON [User].CurriculumID = Curriculum.CurriculumID INNER JOINSpecialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOINMajor ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                cdSemester = rs.getInt("cdSemester");
                subjectID = rs.getString("subjectID");
                subjectName = rs.getString("subjectName");
                subjectNoCredit = rs.getInt("subjectNoCredit");
                subjectPrerequisite = rs.getString("subjectPrerequisite");
                subjectDescription = rs.getString("subjectDescription");
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");

                status = rs.getInt("status");
                getCD = (new CurriculumDetail(new Subject(subjectID, subjectName, subjectNoCredit, subjectPrerequisite, subjectDescription), new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), cdSemester, status));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getCD;
    }

    public int deleteCurriculumDetail(String subjectID, String curriculumID) {
        int rs = -1;
        String query = "UPDATE CurriculumDetail"
                + " SET Status = 0?"
                + " WHERE SubjectID=? AND CurriculumID=?";
        try {
            rs = SQL.executeUpdate(query, subjectID, curriculumID);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateCurriculumDetail(String subjectID, String curriculumID, int cdSemester) {
        int rs = -1;
        String query = "UPDATE CurriculumDetail"
                + " SET CDSemester=?"
                + " WHERE SubjectID=? AND CurriculumID=?";
        try {
            rs = SQL.executeUpdate(query, cdSemester, subjectID, curriculumID);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addCurriculumDetail(String subjectID, String curriculumID, int cdSemester) {
        int rs = -1;
        String query = "INSERT INTO CurriculumDetail(SubjectID,CurriculumID,CDSemester) VALUES (?,?,?)";
        try {
            rs = SQL.executeUpdate(query, subjectID, curriculumID, cdSemester);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
