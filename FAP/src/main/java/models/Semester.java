/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class Semester {

    private String semesterID;
    private String semesterName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String YearID;

    public Semester(String SemesterID, String SemesterName, LocalDate startDate, LocalDate endDate, String YearID) {
        this.semesterID = SemesterID;
        this.semesterName = SemesterName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.YearID = YearID;
    }
    
    
    
    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String SemesterID) {
        this.semesterID = SemesterID;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String SemesterName) {
        this.semesterName = SemesterName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getYearID() {
        return YearID;
    }

    public void setYearID(String YearID) {
        this.YearID = YearID;
    }
    
    
}
