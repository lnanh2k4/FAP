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
    private Campus campusID;
    private User userID;

    public UserCampus() {
    }
    private int status;

    public UserCampus(int userCampusID, Campus campusID, User userID, int status) {
        this.userCampusID = userCampusID;
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

    public Campus getCampusID() {
        return campusID;
    }

    public void setCampusID(Campus campusID) {
        this.campusID = campusID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    

}
