/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class CurriculumDetail {
    private Subject subjectID;
    private Curriculum curriculumID;
    private int cdSemester;

    public CurriculumDetail() {
    }

    public CurriculumDetail(Subject subjectID, Curriculum curriculumID, int cdSemester) {
        this.subjectID = subjectID;
        this.curriculumID = curriculumID;
        this.cdSemester = cdSemester;
    }

    public int getCdSemester() {
        return cdSemester;
    }

    public void setCdSemester(int cdSemester) {
        this.cdSemester = cdSemester;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }

    public Curriculum getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(Curriculum curriculumID) {
        this.curriculumID = curriculumID;
    }
    
}
