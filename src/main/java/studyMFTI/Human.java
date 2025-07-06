package studyMFTI;

// Задача 1.1.2; 1.2.2; 1.2.3
// Задача 1.4.6
public class Human {

    private Name name;
    private Human father;

    public Human(Name name, Human father) {
        this.name = name;
        if (father != null) this.father = father;
    }
    public Human(String name, Human father) {
        this(new Name(name), father);
    }
    public Human(Name name) {
        this(name, null);
    }
    public Human(String name) {
        this(new Name(name));
    }

    @Override
    public String toString() {
        String res = "";
        if (name.getSurname() == null) {
            if (father != null && father.getName().getSurname() != null) res += father.getName().getSurname();
        } else {
            res += name.getSurname();
        }
        if (name.getName() != null) res += " " + name.getName();
        if (name.getPatronymic() == null) {
            if (father != null && father.getName().getName() != null) res += " " + father.getName().getName() + "ович";
        } else {
            res += " " + name.getPatronymic();
        }
        return res;
    }

    public Name getName() {
        return name;
    }
}
