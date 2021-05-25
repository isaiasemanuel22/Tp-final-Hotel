package com.company.models;

public class Receptionist {
    private int salary;
    private String turn;
    private User user;


    public Receptionist(int salary, String turn,User user) {
        this.user = user;
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
