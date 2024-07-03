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
public class Schedule {

    private int scheduleID;
    private int groupSubjectID;
    private LocalDate startDate;
    private LocalDate endDate;

    public Schedule() {
    }

    public Schedule(int scheduleID, int groupSubjectID, LocalDate startDate, LocalDate endDate) {
        this.scheduleID = scheduleID;
        this.groupSubjectID = groupSubjectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getGroupSubjectID() {
        return groupSubjectID;
    }

    public void setGroupSubjectID(int groupSubjectID) {
        this.groupSubjectID = groupSubjectID;
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
    
    
    
    
}
