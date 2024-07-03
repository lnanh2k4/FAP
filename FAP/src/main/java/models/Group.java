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
    private int GroupID;
    private String GroupName;
    private String SemesterID;

    public Group(int GroupID, String GroupName, String SemesterID) {
        this.GroupID = GroupID;
        this.GroupName = GroupName;
        this.SemesterID = SemesterID;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int GroupID) {
        this.GroupID = GroupID;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getSemesterID() {
        return SemesterID;
    }

    public void setSemesterID(String SemesterID) {
        this.SemesterID = SemesterID;
    }
    
    
}
