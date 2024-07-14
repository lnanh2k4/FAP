/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class UserCampus {

    private int userCampusID;
    private String campusID;
    private String userID;
    private int status;

    public UserCampus(int userCampusID, String campusID, String userID, int status) {
        this.userCampusID = userCampusID;
        this.campusID = campusID;
        this.userID = userID;
        this.status = status;
    }

    public UserCampus(String campusID, String userID, int status) {
        this.campusID = campusID;
        this.userID = userID;
        this.status = status;
    }

    public int getUserCampusID() {
        return userCampusID;
    }

    public void setUserCampusID(int userCampusID) {
        this.userCampusID = userCampusID;
    }

    public String getCampusID() {
        return campusID;
    }

    public void setCampusID(String campusID) {
        this.campusID = campusID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    

}
