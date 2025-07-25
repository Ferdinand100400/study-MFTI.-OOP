package ru.chichkov.employees;

import lombok.Getter;

// Задача 1.2.4
// Задача 1.3.4
// Задача 1.6.10
// Задача 3.2.1
@Getter
public class Employee {
    final String name;
    Department department;
    public Employee (String name, Department department){
        this.name = name;
        this.department = department;
        department.employees.add(this);
    }

    @Override
    public String toString() {
        if (department.director != null && name.equals(department.director.name))
            return name + " начальник отдела " + department.name;
        return name + " работает в отделе " + department;
    }

    public void setDepartment(Department department) {
        if (!this.equals(this.department.director)) this.department = department;
    }
}
