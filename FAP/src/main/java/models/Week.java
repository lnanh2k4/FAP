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
    private Semester semesterID;

    public Week(int weekID, String semesterID, LocalDate startDate, LocalDate endDate, Semester semesterID) {
        this.weekID = weekID;
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.semesterID = semesterID;
    }

    public Week(String semesterID, LocalDate startDate, LocalDate endDate, Semester semesterID) {
        this.semesterID = semesterID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.SemesterID = semesterID;
    }
    
    public Week(){
    
    }
    
    
    
    
}
