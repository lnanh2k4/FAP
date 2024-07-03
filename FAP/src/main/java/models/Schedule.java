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

    private int ScheduleID;
    private int GroupSubjectID;
    private LocalDate startDate;
    private LocalDate endDate;

    public Schedule(int ScheduleID, int GroupSubjectID, LocalDate startDate, LocalDate endDate) {
        this.ScheduleID = ScheduleID;
        this.GroupSubjectID = GroupSubjectID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(int ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public int getGroupSubjectID() {
        return GroupSubjectID;
    }

    public void setGroupSubjectID(int GroupSubjectID) {
        this.GroupSubjectID = GroupSubjectID;
    }

    public LocalDate getStartTime() {
        return startDate;
    }

    public void setStartTime(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndTime() {
        return endDate;
    }

    public void setEndTime(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    
}
