package studyMFTI;

// Задача 1.2.4
// Задача 1.3.4
// Задача 1.6.10
public record Employee(String name, Department department) {
    public Employee {
        department.employees.add(this);
    }

    @Override
    public String toString() {
        if (department.getDirector() != null && name.equals(department.getDirector().name))
            return name + " начальник отдела " + department.getName();
        return name + " работает в отделе " + department;
    }
}
