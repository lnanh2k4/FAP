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
import models.Major;
import models.Specialization;
import utils.SQL;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class CurriculumDAO {

    String curriculumID;
    String curriculumName;
    String specializationID;
    String specializationName;
    String majorID;
    String majorName;
    int status;

    public List<Curriculum> getAllList() {
        ResultSet rs = null;
        List<Curriculum> list = new ArrayList<>();
        String query = "SELECT* FROM Curriculum INNER JOINSpecialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOINMajor ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                status = rs.getInt("status");
                list.add(new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName)), status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Curriculum getCurriculum() {
        ResultSet rs = null;
        Curriculum getC = null;

        String query = "SELECT* FROM Curriculum INNER JOIN Specialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOIN Major ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                status = rs.getInt("status");
                getC = (new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName)),status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getC;
    }

    public int deleteCurriculum(String curriculumID) {
        int rs = -1;
        String query = "UPDATE Curriculum"
                + " SET Status = 0"
                + " WHERE CurriculumID=?";
        try {
            rs = SQL.executeUpdate(query, curriculumID);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateCurriculum(String curriculumID, String curriculumName, String specializationID) {
        int rs = -1;
        String query = "UPDATE Curriculum"
                + " SET CurriculumName=?, SpecializationID=?"
                + " WHERE CurriculumID=?";
        try {
            rs = SQL.executeUpdate(query, curriculumName, specializationID, curriculumID);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addCurriculum(String curriculumID, String curriculumName, String specializationID) {
        int rs = -1;
        String query = "INSERT INTO Curriculum(CurriculumID,CurriculumName,SpecializationID) VALUES (?,?,?)";
        try {
            rs = SQL.executeUpdate(query, curriculumID, curriculumName, specializationID);
        } catch (SQLException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurriculumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
