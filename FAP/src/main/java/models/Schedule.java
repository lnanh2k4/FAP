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
    private LocalDate startTime;
    private LocalDate endTime;

    public Schedule(int ScheduleID, int GroupSubjectID, LocalDate startTime, LocalDate endTime) {
        this.ScheduleID = ScheduleID;
        this.GroupSubjectID = GroupSubjectID;
        this.startTime = startTime;
        this.endTime = endTime;
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
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
    
    
}
