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
    private String startDate;
    private String endDate;
    private Semester semesterID;

    public Week(int weekID, String startDate, String endDate, Semester semesterID) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Semester getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(Semester semesterID) {
        this.semesterID = semesterID;
    }

    

    public Week(String startDate, String endDate, Semester semesterID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.semesterID = semesterID;
    }

    public Week() {
    }  
}
