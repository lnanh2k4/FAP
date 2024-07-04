/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class Campus {

    private String campusID;
    private String campusName;
    private String campusAddress;
    private String campusEmail;
    private String campusHotline;
    private int status;

    public Campus(String campusID, String campusName, String campusEmail, String campusHotline) {
        this.campusID = campusID;
        this.campusName = campusName;
        this.campusEmail = campusEmail;
        this.campusHotline = campusHotline;
    }

    public Campus(String campusID, String campusName, String campusAddress, String campusEmail, String campusHotline, int status) {
        this.campusID = campusID;
        this.campusName = campusName;
        this.campusAddress = campusAddress;
        this.campusEmail = campusEmail;
        this.campusHotline = campusHotline;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Campus() {
    }

    public String getCampusID() {
        return campusID;
    }

    public void setCampusID(String campusID) {
        this.campusID = campusID;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusAddress() {
        return campusAddress;
    }

    public void setCampusAddress(String campusAddress) {
        this.campusAddress = campusAddress;
    }

    public String getCampusEmail() {
        return campusEmail;
    }

    public void setCampusEmail(String campusEmail) {
        this.campusEmail = campusEmail;
    }

    public String getCampusHotline() {
        return campusHotline;
    }

    public void setCampusHotline(String campusHotline) {
        this.campusHotline = campusHotline;
    }

}
