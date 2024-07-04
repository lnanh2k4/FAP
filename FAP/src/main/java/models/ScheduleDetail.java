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
public class ScheduleDetail {

    private int scheduleDetailID;
    private int scheduleID;
    private String roomID;
    private String userID;
    private int timeID;
    private String campusID;
    private int weekID;
    private String schlDescription;
    private int subjectSession;
    private LocalDate date;
    private int status;

    public ScheduleDetail(int scheduleDetailID, int scheduleID, String roomID, String userID, int timeID, String campusID, int weekID, String schlDescription, int SubjectSession, LocalDate date) {
        this.scheduleDetailID = scheduleDetailID;
        this.scheduleID = scheduleID;
        this.roomID = roomID;
        this.userID = userID;
        this.timeID = timeID;
        this.campusID = campusID;
        this.weekID = weekID;
        this.schlDescription = schlDescription;
        this.subjectSession = subjectSession;
        this.date = date;
    }

    public ScheduleDetail(int scheduleDetailID, int scheduleID, String roomID, String userID, int timeID, String campusID, int weekID, String schlDescription, int subjectSession, LocalDate date, int status) {
        this.scheduleDetailID = scheduleDetailID;
        this.scheduleID = scheduleID;
        this.roomID = roomID;
        this.userID = userID;
        this.timeID = timeID;
        this.campusID = campusID;
        this.weekID = weekID;
        this.schlDescription = schlDescription;
        this.subjectSession = subjectSession;
        this.date = date;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ScheduleDetail() {
    }

    public int getScheduleDetailID() {
        return scheduleDetailID;
    }

    public void setScheduleDetailID(int scheduleDetailID) {
        this.scheduleDetailID = scheduleDetailID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getTimeID() {
        return timeID;
    }

    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }

    public String getCampusID() {
        return campusID;
    }

    public void setCampusID(String campusID) {
        this.campusID = campusID;
    }

    public int getWeekID() {
        return weekID;
    }

    public void setWeekID(int weekID) {
        this.weekID = weekID;
    }

    public String getSchlDescription() {
        return schlDescription;
    }

    public void setSchlDescription(String SchlDescription) {
        this.schlDescription = schlDescription;
    }

    public int getSubjectSession() {
        return subjectSession;
    }

    public void setSubjectSession(int subjectSession) {
        this.subjectSession = subjectSession;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
