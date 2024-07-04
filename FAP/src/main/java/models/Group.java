/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE180117 - Dang Cong Khanh
 */
public class Group {

    private int groupID;
    private String groupName;
    private String gemesterID;
    private int status;

    public Group(int groupID, String groupName, String gemesterID) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.gemesterID = gemesterID;
    }

    public Group(int groupID, String groupName, String gemesterID, int status) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.gemesterID = gemesterID;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Group() {
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGemesterID() {
        return gemesterID;
    }

    public void setGemesterID(String gemesterID) {
        this.gemesterID = gemesterID;
    }

}
