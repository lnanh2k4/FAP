/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class Week {
    private int weekID;
    private String semesterID;
    private LocalDate startDate;
    private LocalDate endDate;
    private Semester SemesterID;

    public Week(int weekID, String semesterID, LocalDate startDate, LocalDate endDate, Semester SemesterID) {
        this.weekID = weekID;
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.SemesterID = SemesterID;
    }

    public Week(String semesterID, LocalDate startDate, LocalDate endDate, Semester SemesterID) {
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.SemesterID = SemesterID;
    }
    
    public Week(){
    
    }
    
    public int getWeekID() {
        return weekID;
    }

    public void setWeekID(int weekID) {
        this.weekID = weekID;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
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

    public Semester getSemesterID() {
        return SemesterID;
    }

    public void setSemesterID(Semester SemesterID) {
        this.SemesterID = SemesterID;
    }
    
    
}
