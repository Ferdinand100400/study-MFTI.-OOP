package ru.chichkov.student;

import ru.chichkov.exception.NotCorrectMarksException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Задача 4.2.3
public class MethodsStudent {

    public static void addMarkFromStudents(Student... students) {
        Random random = new Random();
        for (int i = 0; i < students.length; i++) {
            int mark = random.nextInt(10) + 1;
            try {
                students[i].addMarks(mark);
            }
            catch (NotCorrectMarksException e) {
                System.out.println("Не удалось добавить оценку \"" + mark + "\" студенту: " + students[i].getName());
                System.out.println("Оценки не добавились никому!");
                i--;
                while (i >= 0) {
                    students[i].deleteMark();
                    i--;
                }
                return;
            }
        }
    }

    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs) {
        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < constructorArgs.size(); i++) {
//            try {
//                students.add(new Student(constructorArgs.get(i), new Rule0To10()));
//            }
//            catch (Exception e) {
//                System.out.println("Студента " + constructorArgs.get(i) + " невозможно создать");
//                return new ArrayList<>();
//            }
//            if (!addArgs.isEmpty()) students.get(i).setMarks(Integer.parseInt(addArgs.get(i)));
//        }
        return students;
    }
}
