package ru.chichkov.employee;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Задача 1.2.4
// Задача 1.3.4
// Задача 1.6.10
// Задача 3.2.1
@Getter
public class Department {
    final String name;
    Employee director;
    List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name == null) return "";
        if (director == null) return name;
        return name + ", начальник которого " + director.name;
    }
    public void setDirector(Employee director) {
        if (director == null || this.director == director) return;
        if (director.department != this) addEmployee(director);
        this.director = director;
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employee.department == this) return;
        employee.removeDepartment();
        employee.department = this;
        employees.add(employee);
    }
}
