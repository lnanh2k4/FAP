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
import models.Semester;
import utils.SQL;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class SemesterDAO {

    String semesterID;
    String semesterName;
    LocalDate startDate;
    LocalDate endDate;
    String yearID;
    int status;

    public List<Semester> getAllList() {
        ResultSet rs = null;
        List<Semester> list = new ArrayList<>();
        String query = "SELECT * FROM Semester INNER JOIN Year ON Semester.YearID = Year.YearID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                semesterID = (String) rs.getObject("semesterID");
                semesterName = (String) rs.getObject("semesterName");
                startDate = (LocalDate) rs.getObject("startDate");
                endDate = (LocalDate) rs.getObject("endDate");
                yearID = (String) rs.getObject("yearID");
                status = rs.getInt("status");
                list.add(new Semester(semesterID, semesterName, startDate, endDate, yearID, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Semester getSemester() {
        ResultSet rs = null;
        Semester se = null;
        String query = "SELECT * FROM Semester INNER JOIN Year ON Semester.YearID = Year.YearID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                semesterID = (String) rs.getObject("semesterID");
                semesterName = (String) rs.getObject("semesterName");
                startDate = (LocalDate) rs.getObject("startDate");
                endDate = (LocalDate) rs.getObject("endDate");
                yearID = (String) rs.getObject("yearID");
                se = new Semester(semesterID, semesterName, startDate, endDate, yearID, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return se;
    }

    public int deleteSemester(String semesterID, String semesterName, LocalDate startDate, LocalDate endDate, String yearID) {
        int rs = -1;
        String query = "UPDATE Semester"
                + " SET Status = 0"
                + "WHERE SemesterID=? AND SemesterName=?";
        try {
            rs = SQL.executeUpdate(query, semesterID, semesterName, startDate, endDate, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateSemester(String semesterID, String semesterName, LocalDate startDate, LocalDate endDate, String yearID) {
        int rs = -1;
        String query = "UPDATE Semester"
                + " SET startDate=?, endDate=?, yearID=?"
                + "WHERE SemesterID=? AND SemesterName=?";
        try {
            rs = SQL.executeUpdate(query, semesterID, semesterName, startDate, endDate, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addSemester(String semesterID, String semesterName, LocalDate startDate, LocalDate endDate, String yearID) {
        int rs = -1;
        String query = "INSERT INTO Semester(semesterID,semesterName,startDate,endDate,yearID) VALUES (?,?,?,?,?)";
        try {
            rs = SQL.executeUpdate(query, semesterID, semesterName, startDate, endDate, yearID);
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
