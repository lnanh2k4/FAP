/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class GroupSubject {
    int groupSubjectID;
    Subject subjectID;
    Group groupID;

    public GroupSubject() {
    }

    public GroupSubject(int groupSubjectID, Subject subjectID, Group groupID) {
        this.groupSubjectID = groupSubjectID;
        this.subjectID = subjectID;
        this.groupID = groupID;
    }

    public GroupSubject(Subject subjectID, Group groupID) {
        this.subjectID = subjectID;
        this.groupID = groupID;
    }

    public int getGroupSubjectID() {
        return groupSubjectID;
    }

    public void setGroupSubjectID(int groupSubjectID) {
        this.groupSubjectID = groupSubjectID;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }

    public Group getGroupID() {
        return groupID;
    }

    public void setGroupID(Group groupID) {
        this.groupID = groupID;
    }
  
}
