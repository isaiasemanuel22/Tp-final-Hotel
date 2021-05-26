package com.company.models;

public class User extends Person{
    private long userId;
    private String password;
    private String tipoUsuario;

    public User(){
        super();
    }

<<<<<<< HEAD
    public User(String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password) {
        super(name, lastName, DNI, adress, phone, email, genre);
=======
    public User(long ID, String name, String lastName, String DNI, String adress, String phone, String email, String genre, long userId, String password) {
        super(ID, name, lastName, DNI, adress, phone, email, genre);
>>>>>>> 5c925de657f1f62225a6abb985166473625e0a5b
        this.userId = userId;
        this.password = password;
    }

    public long getUserId() { return userId; }

    public void setUserId(long userId) { this.userId = userId; }

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
