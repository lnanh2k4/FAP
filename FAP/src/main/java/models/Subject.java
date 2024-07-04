/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class Subject {

    private String subjectID;
    private String subjectName;
    private int subjectNoCredit;
    private String subjectPrerequisite;
    private String subjectDescription;
    private int status;

    public Subject() {
    }

    public Subject(String subjectID, String subjectName, int subjectNoCredit, String subjectPrerequisite, String subjectDescription) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectNoCredit = subjectNoCredit;
        this.subjectPrerequisite = subjectPrerequisite;
        this.subjectDescription = subjectDescription;
    }

    public Subject(String subjectID, String subjectName, int subjectNoCredit, String subjectPrerequisite, String subjectDescription, int status) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectNoCredit = subjectNoCredit;
        this.subjectPrerequisite = subjectPrerequisite;
        this.subjectDescription = subjectDescription;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectNoCredit() {
        return subjectNoCredit;
    }

    public void setSubjectNoCredit(int subjectNoCredit) {
        this.subjectNoCredit = subjectNoCredit;
    }

    public String getSubjectPrerequisite() {
        return subjectPrerequisite;
    }

    public void setSubjectPrerequisite(String subjectPrerequisite) {
        this.subjectPrerequisite = subjectPrerequisite;
    }

}
