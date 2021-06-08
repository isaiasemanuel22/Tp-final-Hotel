package com.company.models;

public class User extends Person{

    private UserType userType;
    private String userName;
    private Long userId;
    private String password;

    public User() {

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

    public Long getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = Long.parseLong(userId); }

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
        return super.toString() + " User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
