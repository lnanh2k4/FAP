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

    public Specialization(String specializationID, String specializationName, Major majorID) {
        this.specializationID = specializationID;
        this.specializationName = specializationName;
        this.majorID = majorID;
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
