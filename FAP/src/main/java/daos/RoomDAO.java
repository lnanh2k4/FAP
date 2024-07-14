/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    int status;

    public List<Room> getAllList() {
        ResultSet rs = null;
        String query = "SELECT Room.* FROM Room";
        List<Room> list = new ArrayList();
        try {
            rs = SQL.executeQuery(query);
            while (rs.next()) {
                roomID = rs.getString("roomID");
                roomName = rs.getString("roomName");
                status = rs.getInt("status");
                if (status != -1) {
                    list.add(new Room(roomID, roomName, status));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Room getRoom(String id) {
        ResultSet rs = null;
        Room gr = null;
        String query = "SELECT Room.* FROM Room Where RoomID=?";
        try {
            rs = SQL.executeQuery(query, id);
            while (rs.next()) {
                roomID = rs.getString("roomID");
                roomName = rs.getString("roomName");
                status = rs.getInt("status");
                gr = new Room(roomID, roomName, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WeekDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gr;
    }

    public int deleteRoom(String roomID) {
        int rs = -1;
        String query = "UPDATE Room"
                + " SET Status = -1"
                + " WHERE RoomID=?";
        try {
            rs = SQL.executeUpdate(query, roomID);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int setStatus(String roomID) {
        int rs = -1;
        String query = "UPDATE Room"
                + " SET Status = 0"
                + " WHERE RoomID=?";

        try {
            rs = SQL.executeUpdate(query, roomID);
        } catch (SQLException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YearDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateRoom(String roomID, String roomName) {
        int rs = -1;
        String query = "UPDATE Room"
                + " SET RoomName=?"
                + " WHERE RoomID=?";

        try {
            rs = SQL.executeUpdate(query, roomName, roomID);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int addRoom(String roomID, String roomName) {
        int rs = -1;
        Room r = getRoom(roomID);
        if (r != null) {
            if (r.getRoomID().equals(roomID)) {
                System.out.println("if dung");
                updateRoomStatus(roomID, roomName);
                return rs;
            }
        }
        String query = "INSERT INTO Room(RoomID,RoomName) VALUES (?,?)";

        try {
            rs = SQL.executeUpdate(query, roomID, roomName);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public int updateRoomStatus(String roomID, String roomName) {
        int rs = -1;
        String query = "UPDATE Room"
                + " SET RoomName=?"
                + " WHERE RoomID=?";

        try {
            rs = SQL.executeUpdate(query, roomName, roomID);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public boolean checkexist(String roomID) {
        if (getRoom(roomID) == null) {
            return false;
        } else {
            return true;
        }
    }
}
