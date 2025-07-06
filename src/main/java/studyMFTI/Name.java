package studyMFTI;

// Задача 1.1.3
// Задача 1.4.5
public class Name {
    private String surname;
    private String name;
    private String patronymic;

    public Name(String name) {
        this.name = name;
    }

    public Name(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    public Name(String name, String patronymic, String surname) {
        this(name, surname);
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        if (surname == null) surname = "";
        if (name == null) name = "";
        if (patronymic == null) patronymic = "";
        return surname + " " + name + " " + patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
