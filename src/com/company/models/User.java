package com.company.models;

public class User extends Person{
    private UserProfile userType;
    private String userId;
    private String password;

    public User(){
        super();
    }

    public User(UserProfile userType, String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password) {
        super(name, lastName, DNI, adress, phone, email, genre);
        this.userType = userType;
        this.userId = userId;
        this.password = password;
    }

    public UserProfile getUserType() {
        return userType;
    }

    public void setUserType(UserProfile userType) {
        this.userType = userType;
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
