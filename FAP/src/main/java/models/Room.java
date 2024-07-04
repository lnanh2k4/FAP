/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CE180191 - Huynh Hoang Ty
 */
public class Room {

    private String roomID;
    private String roomName;
    private int status;
    public Room(String roomID, String roomName) {
        this.roomID = roomID;
        this.roomName = roomName;
    }

    public Room(String roomID, String roomName, int status) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Room() {
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
