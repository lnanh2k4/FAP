/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class Time {

    private int timeID;
    private int slot;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private int status;

    public Time(int timeID, int Slot, LocalTime startTime, LocalTime endTime, String description) {
        this.timeID = timeID;
        this.slot = Slot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Time(int timeID, int slot, LocalTime startTime, LocalTime endTime, String description, int status) {
        this.timeID = timeID;
        this.slot = slot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
