/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class Curriculum {

    private String curriculumID;
    private String curriculumName;
    private Specialization specializationID;
    private int status;

    public Curriculum(String curriculumID, String curriculumName, Specialization specializationID, int status) {
        this.curriculumID = curriculumID;
        this.curriculumName = curriculumName;
        this.specializationID = specializationID;
        this.status = status;
    }

    public Curriculum(String curriculumID, String curriculumName, Specialization specializationID) {
        this.curriculumID = curriculumID;
        this.curriculumName = curriculumName;
        this.specializationID = specializationID;
    }

    public Curriculum() {
    }

    public Specialization getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(Specialization specializationID) {
        this.specializationID = specializationID;
    }

    public String getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(String curriculumID) {
        this.curriculumID = curriculumID;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
