/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class Major {

    private String majorID;
    private String majorName;
    private int status;

    public Major(String majorID, String majorName, int status) {
        this.majorID = majorID;
        this.majorName = majorName;
        this.status = status;
    }

    public Major(String majorID, String majorName) {
        this.majorID = majorID;
        this.majorName = majorName;
    }

    public Major() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

}
