/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class Specialization {

    private String specializationID;
    private String specializationName;
    private Major majorID;
    private int status;

    public Specialization(String specializationID, String specializationName, Major majorID) {
        this.specializationID = specializationID;
        this.specializationName = specializationName;
        this.majorID = majorID;
    }

    public Specialization(String specializationID, String specializationName, Major majorID, int status) {
        this.specializationID = specializationID;
        this.specializationName = specializationName;
        this.majorID = majorID;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Specialization() {
    }

    public Major getMajorID() {
        return majorID;
    }

    public void setMajorID(Major majorID) {
        this.majorID = majorID;
    }

    public String getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(String specializationID) {
        this.specializationID = specializationID;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
