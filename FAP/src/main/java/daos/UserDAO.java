/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Curriculum;
import models.Major;
import models.Specialization;
import models.User;

import utils.SQL;

/**
 *
 * @author Nguyen Le Khac Vu - CE180175
 */
public class UserDAO {

    String userID;
    String firstName;
    String lastName;
    int sex;
    String email;
    String phone;
    int semester;
    int role;
    String password;
    String curriculumID;
    String curriculumName;
    String specializationID;
    String specializationName;
    String majorID;
    String majorName;

    public List<User> getAllList() {
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        String query = "SELECT*FROM Subject";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                userID = rs.getString("userID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                sex = rs.getInt("sex");
                email = rs.getString("email");
                phone = rs.getString("phone");
                semester = rs.getInt("semester");
                role = rs.getInt("role");
                password = rs.getString("password");
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                list.add(new User(userID, firstName, lastName, sex, email, phone, semester, role, new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), password));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public User getUser() {
        ResultSet rs = null;
        User getU = null;
        String query = "SELECT*FROM Subject";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                userID = rs.getString("userID");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                sex = rs.getInt("sex");
                email = rs.getString("email");
                phone = rs.getString("phone");
                semester = rs.getInt("semester");
                role = rs.getInt("role");
                password = rs.getString("password");
                curriculumID = rs.getString("curriculumID");
                curriculumName = rs.getString("curriculumName");
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                getU =(new User(userID, firstName, lastName, sex, email, phone, semester, role, new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), password));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getU;
    }
}
