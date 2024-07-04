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
public class Year {

    private String yearID;
    private LocalDate startDate;
    private LocalDate endDate;
    private int status;

    public Year(String yearID, LocalDate startDate, LocalDate endDate) {
        this.yearID = yearID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Year(String yearID, LocalDate startDate, LocalDate endDate, int status) {
        this.yearID = yearID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Year() {
    }

    public String getYearID() {
        return yearID;
    }

    public void setYearID(String yearID) {
        this.yearID = yearID;
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
