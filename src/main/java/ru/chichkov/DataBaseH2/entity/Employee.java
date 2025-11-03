package ru.chichkov.DataBaseH2.entity;

public class Employee {
    private int id;
    private String name;
    private int departmentId;

    public Employee(int id, String name, int departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }
    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
