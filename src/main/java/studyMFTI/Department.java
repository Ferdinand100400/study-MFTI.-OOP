package studyMFTI;

import java.util.ArrayList;
import java.util.List;

// Задача 1.2.4
// Задача 1.3.4
public class Department {
    private String name;
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

    public String getName() {
        return name;
    }

    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }
}
