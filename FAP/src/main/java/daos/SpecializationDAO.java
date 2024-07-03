/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Major;
import models.Specialization;
import utils.SQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Group;
import models.GroupSubject;
import models.Subject;
import utils.SQL;
/**
 *
 * @author CE181767 - Le Nhut Anh
 */
public class SpecializationDAO {
    String specializationID;
   String specializationName;
      String majorID;
     String majorName;
     
     public List<Specialization> getAllList() {
        ResultSet rs = null;
        List<Specialization> list = new ArrayList<>();
        String query = "SELECT* FROM Specialization INNER JOIN Major ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                list.add(new Specialization(specializationID, specializationName, new Major(majorID, majorName)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
      public Specialization getSpecialization() {
        ResultSet rs = null;
        Specialization getSP = null;
        String query = "SELECT* FROM Specialization INNER JOIN Major ON Specialization.MajorID = Major.MajorID";
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                specializationID = rs.getString("specializationID");
                specializationName = rs.getString("specializationName");
                majorID = rs.getString("majorID");
                majorName = rs.getString("majorName");
                getSP=(new Specialization(specializationID, specializationName, new Major(majorID, majorName)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getSP;
}
}

