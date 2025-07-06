package studyMFTI;

// Задача 1.2.4
// Задача 1.3.4
public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.employees.add(this);
    }

    @Override
    public String toString() {
        if (department == null) return name;
        if (department.getDirector() != null && name.equals(department.getDirector().name))
            return name + " начальник отдела " + department.getName();
        return name + " работает в отделе " + department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}
