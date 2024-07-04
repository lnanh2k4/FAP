/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class Attendance {
    private int attendanceID;
    private int scheduleDetailID;
    private String userID;
    private int state;
    private String comment;
    private String note;
    private int status;

    public Attendance(int attendanceID, int scheduleDetailID, String userID, int state, String comment, String note, int status) {
        this.attendanceID = attendanceID;
        this.scheduleDetailID = scheduleDetailID;
        this.userID = userID;
        this.state = state;
        this.comment = comment;
        this.note = note;
        this.status = status;
    }

    public Attendance(int scheduleDetailID, String userID, int state, String comment, String note, int status) {
        this.scheduleDetailID = scheduleDetailID;
        this.userID = userID;
        this.state = state;
        this.comment = comment;
        this.note = note;
        this.status = status;
    }
    

    public Attendance() {
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getScheduleDetailID() {
        return scheduleDetailID;
    }

    public void setScheduleDetailID(int scheduleDetailID) {
        this.scheduleDetailID = scheduleDetailID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
