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
                list.add(new Semester(semesterID, semesterName, startDate, endDate, yearID));
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
                se = new Semester(semesterID, semesterName, startDate, endDate, yearID);
            }
        } catch (SQLException ex) { 
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return se;
    }
    
    public int addSchedule(int scheduleID, int groupSubjectID, LocalDate startDate, LocalDate endDate){
        int rs=-1;

            String query="";
            

        return rs;
    }
}
