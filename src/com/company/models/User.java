package com.company.models;

public class User extends Person{

    private UserType userType;
    private String userName;
    private String userId;
    private String password;
    private UserProfile userProfile;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
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
