/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class GroupSubjectStudent {
    private int gssID;
    private User userID;
    private GroupSubject groupSubjectID;
    private int status;
    public GroupSubjectStudent() {
    }

    public GroupSubjectStudent(int gssID, User userID, GroupSubject groupSubjectID) {
        this.gssID = gssID;
        this.userID = userID;
        this.groupSubjectID = groupSubjectID;
    }

    public GroupSubjectStudent(int gssID, User userID, GroupSubject groupSubjectID, int status) {
        this.gssID = gssID;
        this.userID = userID;
        this.groupSubjectID = groupSubjectID;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public GroupSubjectStudent(User userID, GroupSubject groupSubjectID) {
        this.userID = userID;
        this.groupSubjectID = groupSubjectID;
    }

    public GroupSubject getGroupSubjectID() {
        return groupSubjectID;
    }

    public void setGroupSubjectID(GroupSubject groupSubjectID) {
        this.groupSubjectID = groupSubjectID;
    }

    public int getGssID() {
        return gssID;
    }

    public void setGssID(int gssID) {
        this.gssID = gssID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
    
}
