/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class User {

    private String userID;
    private String firstName;
    private String lastName;
    private int sex;
    private String email;
    private String phone;
    private int semester;
    private int role;
    private Curriculum curriculumID;
    private String password;
    private int status;

    public User() {
    }

    public User(String userID, String firstName, String lastName, int sex, String email, String phone, int semester, int role, Curriculum curriculumID, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.semester = semester;
        this.role = role;
        this.curriculumID = curriculumID;
        this.password = password;
    }

    public User(String userID, String firstName, String lastName, int sex, String email, String phone, int semester, int role, Curriculum curriculumID, String password, int status) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.semester = semester;
        this.role = role;
        this.curriculumID = curriculumID;
        this.password = password;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Curriculum getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(Curriculum curriculumID) {
        this.curriculumID = curriculumID;
    }

}
