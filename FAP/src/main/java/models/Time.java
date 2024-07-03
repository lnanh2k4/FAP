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
public class Time {

    private int timeID;
    private int slot;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;

    public Time(int timeID, int Slot, LocalDate startTime, LocalDate endTime, String description) {
        this.timeID = timeID;
        this.slot = Slot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Time() {
    }

    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int Slot) {
        this.slot = Slot;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
