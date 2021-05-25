package com.company.models;

public class Receptionist extends User{
    private int salary;
    private String turn;

    public Receptionist() {
        super();
    }

    public Receptionist(int ID, String name, String lastName, String DNI, String adress, String phone, String email, String genre, String userId, String password, int salary, String turn) {
        super(ID, name, lastName, DNI, adress, phone, email, genre, userId, password);
        this.salary = salary;
        this.turn = turn;
    }

    public int getSalary() { return salary; }

    public void setSalary(int salary) { this.salary = salary; }

    public String getTurn() { return turn; }

    public void setTurn(String turn) { this.turn = turn; }

    @Override
    public String toString() {
        return super.toString() + " Receptionist{" +
                "salary=" + salary +
                ", turn='" + turn + '\'' +
                '}';
    }
}
