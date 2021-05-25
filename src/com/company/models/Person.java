package com.company.models;

public abstract class Person {
    private static int uniqueID=0;
    private long ID;
    private String name;
    private String lastName;
    private String DNI;
    private String adress;
    private String phone;
    private String email;
    private String genre;

    public Person(){
        uniqueID++;
        this.ID=uniqueID;
    }

    public Person(long ID, String name, String lastName, String DNI, String adress, String phone, String email, String genre) {
        uniqueID++;
        this.ID=uniqueID;
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.genre = genre;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) { this.ID = ID; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDNI() { return DNI; }

    public void setDNI(String DNI) { this.DNI = DNI; }

    public String getAdress() { return adress; }

    public void setAdress(String adress) { this.adress = adress; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DNI='" + DNI + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
