package com.company.models;

public class User extends Person{

    private UserType userType;
    private String userName;
    private String password;
    private Integer roomID;

    public User() {

    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return super.toString() + " User{"
                +"UserType="+userType
                +"UserName="+userName
                +"Password=" +password
                +"Habitacion="+roomID
                +'}';
    }
}
