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
import models.Room;
import utils.SQL;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class RoomDAO {
    String roomID;
    String roomName;
    public List<Room> getAllList(){
        ResultSet rs = null;
        String query = "SELECT Room.* FROM Room";
        List<Room> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()){
                roomID = rs.getString("roomID");
                roomName = rs.getString("roomName");
                list.add(new Room(roomID, roomName));
            }
        } catch (SQLException ex) { 
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    public int addRoom(){
        return -1;
    }
}
