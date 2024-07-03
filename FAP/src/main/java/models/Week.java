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
    private LocalDate startDate;
    private LocalDate endDate;
    private Semester semesterID;

    public Week(int weekID, LocalDate startDate, LocalDate endDate, Semester semesterID) {
        this.weekID = weekID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.semesterID = semesterID;
    }

    public int getWeekID() {
        return weekID;
    }

    public void setWeekID(int weekID) {
        this.weekID = weekID;
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
        return semesterID;
    }

    public void setSemesterID(Semester semesterID) {
        this.semesterID = semesterID;
    }

    public Week(LocalDate startDate, LocalDate endDate, Semester semesterID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.semesterID = semesterID;
    }

    public Week() {
    }

    
    
    
    
    
    
}
