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
import utils.Encryption;

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
    int status;

    public List<User> getAllList() {
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM [User] INNER JOIN Curriculum ON [User].CurriculumID = Curriculum.CurriculumID INNER JOIN Specialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOIN Major ON Specialization.MajorID = Major.MajorID";
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
                status = rs.getInt("status");
                list.add(new User(userID, firstName, lastName, sex, email, phone, semester, role, new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), password, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public User getUser(String email) {
        ResultSet rs = null;
        User getU = null;
        String query = "SELECT * FROM [User] INNER JOIN Curriculum ON [User].CurriculumID = Curriculum.CurriculumID INNER JOIN Specialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOIN Major ON Specialization.MajorID = Major.MajorID where email=?";
        try {
            rs = SQL.executeQuery(query, email);
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
                getU = (new User(userID, firstName, lastName, sex, email, phone, semester, role, new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), password, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getU;
    }

    public User getUserByUserID(String userID) {
        ResultSet rs = null;
        User getU = null;
        String query = "SELECT * FROM [User] INNER JOIN Curriculum ON [User].CurriculumID = Curriculum.CurriculumID INNER JOIN Specialization ON Curriculum.SpecializationID = Specialization.SpecializationID INNER JOIN Major ON Specialization.MajorID = Major.MajorID where userID=?";
        try {
            rs = SQL.executeQuery(query, email);
            while (rs.next()) {
                email = rs.getString("email");
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
                getU = (new User(userID, firstName, lastName, sex, email, phone, semester, role, new Curriculum(curriculumID, curriculumName, new Specialization(specializationID, specializationName, new Major(majorID, majorName))), password, status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getU;
    }

    public int deleteUser(String userID) {
        int rs = -1;
        String query = "UPDATE User"
                + " SET Status = 0"
                + " WHERE UserID=?";
        try {
            rs = SQL.executeUpdate(query, userID);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int updateUser(String userID, String firstName, String lastName, int sex, String email, String phone, int semester, int role, String password, String curriculumID) {
        int rs = -1;
        String query = "UPDATE User"
                + " SET FirstName=?, LastName=?, Sex=?,Email=?,Semester=?,[Role]=?,CurriculumID=?,Phone=?,Password=?"
                + " WHERE UserID=?";
        try {
            rs = SQL.executeUpdate(query, firstName, lastName, sex, email, phone, semester, role, password, curriculumID, userID);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int addUser(String userID, String firstName, String lastName, int sex, String email, String phone, int semester, int role, String password, String curriculumID) {
        int rs = -1;
        if (password != null) {
            String query = "INSERT INTO [User](UserID, FirstName, LastName, Sex, Email, Semester, [Role], CurriculumID, Phone,Password) VALUES (?, ?, ?,?, ?, ?, ?, ?, ?,?)";
            try {
                rs = SQL.executeUpdate(query, userID, firstName, lastName, sex, email, semester, role, curriculumID, phone, password);
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String query = "INSERT INTO [User](UserID, FirstName, LastName, Sex, Email, Semester, [Role], CurriculumID, Phone) VALUES (?, ?, ?,?, ?, ?, ?, ?,?)";
            try {
                rs = SQL.executeUpdate(query, userID, firstName, lastName, sex, email, semester, role, curriculumID, phone);
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rs;

    }

    public boolean checkUser(User user, String email, String password, String campus) {
        UserCampusDAO uc = new UserCampusDAO();
        System.out.println("user.getPassword() != null" + user.getPassword() != null);
        System.out.println("user.getUserID().equals(password)" + user.getUserID().equals(password));
        System.out.println("uc.getUserCampus(user.getUserID()).getCampusID().equals(campus) " + uc.getUserCampus(user.getUserID()).getCampusID().equals(campus));
        System.out.println("user.getStatus() != -1 " + (user.getStatus() != -1));
        System.out.println("uc.getUserCampus(user.getUserID()).getCampusID()" + uc.getUserCampus(user.getUserID()).getCampusID().getCampusID());
        System.out.println("campus"+ campus);
        if (user.getPassword() != null) {
            return (Encryption.equalsSHA256(password, user.getPassword()) && uc.getUserCampus(user.getUserID()).getCampusID().getCampusID().equals(campus) && user.getStatus() != -1);
        }
        return (user.getUserID().equals(password) && uc.getUserCampus(user.getUserID()).getCampusID().getCampusID().equals(campus) && user.getStatus() != -1);
    }
}
