package studyMFTI;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Задача 1.2.4
// Задача 1.3.4
// Задача 1.6.10
@Getter
public class Department {
    private final String name;
    private Employee director;
    public List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name == null) return "";
        if (director == null) return name;
        return name + ", начальник которого " + director.getName();
    }
    public void setDirector(Employee director) {
        if (director.getDepartment().name.equals(this.name)) this.director = director;
    }
}
