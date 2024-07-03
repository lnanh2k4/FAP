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

    private String SemesterID;
    private String SemesterName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String YearID;

    public Semester(String SemesterID, String SemesterName, LocalDate startDate, LocalDate endDate, String YearID) {
        this.SemesterID = SemesterID;
        this.SemesterName = SemesterName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.YearID = YearID;
    }
    
    
    
    public String getSemesterID() {
        return SemesterID;
    }

    public void setSemesterID(String SemesterID) {
        this.SemesterID = SemesterID;
    }

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String SemesterName) {
        this.SemesterName = SemesterName;
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
