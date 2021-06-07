package com.company.models;

public class User {

    private UserType userType;
    private String userName;
    private String userId;
    private String password;

    public enum UserType {
        ADMIN,
        RECEPCIONISTA,
        PASAJERO;
    }

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return super.toString() + " User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
