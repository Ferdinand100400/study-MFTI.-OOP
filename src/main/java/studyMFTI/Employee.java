package studyMFTI;

import lombok.Getter;
import lombok.Setter;

// Задача 1.2.4
// Задача 1.3.4
// Задача 1.6.10
@Getter
public class Employee {
    private final String name;
    private Department department;
    public Employee (String name, Department department){
        this.name = name;
        this.department = department;
        department.employees.add(this);
    }

    @Override
    public String toString() {
        if (department.getDirector() != null && name.equals(department.getDirector().name))
            return name + " начальник отдела " + department.getName();
        return name + " работает в отделе " + department;
    }

    public void setDepartment(Department department) {
        if (!this.equals(this.department.getDirector())) this.department = department;
    }
}
