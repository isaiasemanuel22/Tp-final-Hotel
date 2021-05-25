package com.company.models;

public class User extends Person{
    private String userId;
    private String password;
    private String tipoUsuario;

    public User(){
        super();
    }

    public User(int ID, String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password) {
        super(ID, name, lastName, DNI, adress, phone, email, genre);
        this.userId = userId;
        this.password = password;
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
