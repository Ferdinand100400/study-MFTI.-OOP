package ru.chichkov.main;

import ru.chichkov.animal.dog.Dog;
import ru.chichkov.animal.meow.GavAnimals;
import ru.chichkov.behavioralPatterns.SaveStudent;
import ru.chichkov.behavioralPatterns.SaveStudentImpl;
import ru.chichkov.behavioralPatterns.karateKid.Combination;
import ru.chichkov.behavioralPatterns.karateKid.KarateKid;
import ru.chichkov.behavioralPatterns.stock.Bot;
import ru.chichkov.behavioralPatterns.stock.Printer;
import ru.chichkov.behavioralPatterns.stock.Stock;
import ru.chichkov.behavioralPatterns.trafficLight.TrafficLight;
import ru.chichkov.connection.Connection;
import ru.chichkov.database.ConnectionBD;
import ru.chichkov.database.Database;
import ru.chichkov.database.patternDB.DatabasePattern;
import ru.chichkov.exception.LossOfConnectionException;
import ru.chichkov.DataStream.DataStream;
import ru.chichkov.geometry.*;
import ru.chichkov.linkedList.MyLinkedList;
import ru.chichkov.math.SumIntegers;
import ru.chichkov.math.SumStrings;
import ru.chichkov.math.fraction.GenerateFraction;
import ru.chichkov.reflection.Reflections;
import ru.chichkov.stack.Stack;
import ru.chichkov.storage.Box;
import ru.chichkov.storage.MethodsBox;
import ru.chichkov.storage.Storage;
import ru.chichkov.structuralPatterns.CachingLine;
import ru.chichkov.structuralPatterns.meowable.CatDog;
import ru.chichkov.structuralPatterns.meowable.CountMeow;
import ru.chichkov.student.*;
import ru.chichkov.temperature.Temperature;
import ru.chichkov.testAnnatationClasses.A;
import ru.chichkov.testAnnatationClasses.B;
import ru.chichkov.weapon.Shooter;
import ru.chichkov.animal.bird.Birds;
import ru.chichkov.animal.bird.Cuckoo;
import ru.chichkov.animal.bird.Parrot;
import ru.chichkov.animal.bird.Sparrow;
import ru.chichkov.employee.Department;
import ru.chichkov.employee.Employee;
import ru.chichkov.geometry.points.Point3D;
import ru.chichkov.animal.meow.Cat;
import ru.chichkov.animal.meow.Dolphin;
import ru.chichkov.animal.meow.MeowAnimals;
import ru.chichkov.geometry.point.Point;
import ru.chichkov.geometry.points.Color;
import ru.chichkov.geometry.points.Point1D;
import ru.chichkov.geometry.points.Size;
import ru.chichkov.geometry.shape.Circle;
import ru.chichkov.geometry.shape.GeneralSquare;
import ru.chichkov.geometry.shape.Rectangle;
import ru.chichkov.geometry.shape.Triangle;
import ru.chichkov.weapon.Automate;
import ru.chichkov.weapon.Gun;
import ru.chichkov.city.City;
import ru.chichkov.city.CityBackWay;
import ru.chichkov.city.Way;
import ru.chichkov.geometry.polyline.ClosedPolyline;
import ru.chichkov.geometry.polyline.Polyline;
import ru.chichkov.weapon.Weapon;
import ru.chichkov.house.House;
import ru.chichkov.human.Human;
import ru.chichkov.human.Name;
import ru.chichkov.math.fraction.Fraction;
import ru.chichkov.math.MathMethods;
import ru.chichkov.time.Time;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestBlockTask1_1 {
    public static void testTask1() {
        Point point1 = new Point(2, 5);
        Point point2 = new Point(10, 5);
        Point point3 = new Point(15, 20);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }

    /*public static void testTask2() {
        Human human1 = new Human("Клеопатра", 152);
        Human human2 = new Human("Пушкин", 167);
        Human human3 = new Human("Александр", 189);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }*/

   /* public static void testTask3() {
        Name name1 = new Name();
        name1.setSurname("Клеопатра");
        Name name2 = new Name();
        name2.setSurname("Пушкин");
        name2.setName("Александр");
        name2.setPatronymic("Сергеевич");
        Name name3 = new Name();
        name3.setSurname("Маяковский");
        name3.setName("Владимир");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }*/

    public static void testTask4() {
        Time time1 = new Time(10);
        Time time2 = new Time(10_000);
        Time time3 = new Time(100_000);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }

    public static void testTask5() {
        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);
        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);
    }
}

class TestBlockTask1_2 {
//    public static void testTask1() {
//        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
//        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
//
//        line1.setStartPoint(new Point(2, 5));
//        line1.setEndPoint(new Point(20, 50));
//        line2.setStartPoint(new Point(2, 10));
//        line2.setEndPoint(new Point(10, 10));
//
//        line1.setEndPoint(new Point(100, 25));
//
//        Line line3 = new Line(line1.getStartPoint(), line2.getEndPoint());
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//    }
    /*public static void testTask2 {
        // Задача 1.2.2
        Human human1 = new Human(name1, 152);
        Human human2 = new Human(name2, 167);
        Human human3 = new Human(name3, 189);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }*/
    /*public static void testTask3() {
        Name nameWithParent1 = new Name();
        nameWithParent1.setSurname("Чудов");
        nameWithParent1.setName("Иван");
        Name nameWithParent2 = new Name();
        nameWithParent2.setSurname("Чудов");
        nameWithParent2.setName("Петр");
        Name nameWithParent3 = new Name();
        nameWithParent3.setName("Борис");
        Human human1 = new Human(nameWithParent1);
        Human human2 = new Human(nameWithParent2, human1);
        Human human3 = new Human(nameWithParent3, human2);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }*/

    /*public static void testTask4() {
        Department departmentIT = new Department("IT");
        Employee employee1 = new Employee("Петрова", departmentIT);
        Employee employee2 = new Employee("Козлова", departmentIT);
        Employee employee3 = new Employee("Сидорова", departmentIT);
        departmentIT.setDirector(employee2);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
    }*/
}

class TestBlockTask1_3 {
    /*public static void testTask1() {
        List<Integer> marks = new ArrayList<>();
        marks.add(3);
        marks.add(4);
        marks.add(5);
        Student student1 = new Student("Вася", marks);
        Student student2 = new Student("Петя", student1.getMarks());
        student2.setMarksIndex(5, 0);
        // меняется и у Васи, потому что мы скопировали ссылку на лист,
        // который потом изменили, соотвественно везде поменялось
        System.out.println(student1);
        System.out.println(student2);

        // перезаписываю значия в новый лист (не по ссылке)
        List<Integer> marksStudent3 = new ArrayList<>(marks);
        Student student3 = new Student("Андрей", marksStudent3);
        student1.setMarksIndex(5, 1);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }*/
    public static void testTask2() {
        Polyline polyline1 = new Polyline();
        polyline1.setPoint(0, new Point(1, 5));
        polyline1.setPoint(1, new Point(2, 8));
        polyline1.setPoint(2, new Point(5, 3));
        Polyline polyline2 = new Polyline();
        polyline2.setPoint(0, polyline1.getPoints().get(0));
        polyline2.setPoint(1, new Point(2, -5));
        polyline2.setPoint(2, new Point(4, -8));
        polyline2.setPoint(3, polyline1.getPoints().get(polyline1.getPoints().size() - 1));

        polyline1.setPointLink(0, new Point(2, 10), polyline2);
        System.out.println(polyline1);
        System.out.println(polyline2);
    }

    public static void testTask3() {
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");
        cityA.setWay(0, new Way(cityF, 1));
        cityA.setWay(1, new Way(cityB, 5));
        cityA.setWay(2, new Way(cityD, 6));
        cityB.setWay(0, new Way(cityA, 5));
        cityB.setWay(1, new Way(cityC, 3));
        cityC.setWay(0, new Way(cityB, 3));
        cityC.setWay(1, new Way(cityD, 4));
        cityD.setWay(0, new Way(cityA, 6));
        cityD.setWay(1, new Way(cityC, 4));
        cityD.setWay(2, new Way(cityE, 2));
        cityE.setWay(0, new Way(cityF, 2));
        cityF.setWay(0, new Way(cityB, 1));
        cityF.setWay(1, new Way(cityE, 2));
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);
    }

    public static void testTask4() {
        Department departmentIT = new Department("IT");
        Employee employee1 = new Employee("Петрова", departmentIT);
        Employee employee2 = new Employee("Козлова", departmentIT);
        Employee employee3 = new Employee("Сидорова", departmentIT);
        departmentIT.setDirector(employee2);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee2.getDepartment().getEmployees());
    }
}

class TestBlockTask1_4 {
    public static void testTask1() {
        Point point4 = new Point(3, 5);
        Point point5 = new Point(26, 6);
        Point point6 = new Point(7, 8);
        System.out.println(point4);
        System.out.println(point5);
        System.out.println(point6);
    }

    public static void testTask2() {
        Line line4 = new Line(1, 3, 23, 8);
        Line line5 = new Line(5, 10, 25, 10);
        Line line6 = new Line(line4.getStartPoint(), line5.getEndPoint(), Point.class);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
    }

    public static void testTask3() {
        Polyline polyline4 = new Polyline(new Point(3, 5), new Point(25, 6), new Point(7, 8));
        System.out.println(polyline4);
    }

    public static void testTask4() {
        House house4 = new House(2);
        House house5 = new House(35);
        House house6 = new House(91);
        //   house6.amountFloor = 5; // изменить нельзя
        System.out.println(house4);
        System.out.println(house5);
        System.out.println(house6);
    }

    public static void testTask5() {
        Name name1 = Name.builder()
                .firstName("Клеопатра")
                .build();
        Name name2 = Name.builder()
                .firstName("Александр")
                .patronymic("Сергеевич")
                .surname("Пушкин")
                .build();
        Name name3 = Name.builder()
                .firstName("Владимир")
                .surname("Маяковский")
                .build();
        Name name4 = Name.builder()
                .firstName("Христофор")
                .patronymic("Бонифатьевич")
                .build();
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }

    public static void testTask6() {
        Human human1 = new Human("Лев");
        Human human2 = new Human(Name.builder()
                .firstName("Сергей")
                .surname("Пушкин")
                .build(), human1);
        Human human3 = new Human("Александр", human2);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }

    public static void testTask7() {
        Student student1 = new Student("Вася", 3, 4, 5);
        Student student2 = new Student("Максим");
        System.out.println(student1);
        System.out.println(student2);
    }
}

class TestBlockTask1_5 {
    /*public static void testTask1() {
        Gun gun = new Gun(3);
        gun.shoot();
        gun.shoot();
        gun.shoot();
        gun.shoot();
        gun.shoot();
    }*/

    public static void testTask2() {
        Cat cat = new Cat("Барсик");
        cat.meow();
        cat.meow(3);
    }

    public static void testTask3() {
        Line line = new Line(1, 1, 10, 15);
        System.out.println(line.length());
    }

    public static void testTask5() {
        Fraction fraction1 = new Fraction(10, 5);
        Fraction fraction2 = new Fraction(25, 5);
        Fraction fraction3 = new Fraction(8, 16);
        Fraction fraction4 = new Fraction(10, 10);
        Fraction fraction5 = new Fraction(1, 7);
        System.out.println(fraction1 + " + " + fraction4 + " = " + fraction1.sum(fraction4));
        System.out.println(fraction1 + " + " + "4" + " = " + fraction1.sum(4));
        System.out.println(fraction1 + " - " + fraction2 + " = " + fraction1.minus(fraction2));
        System.out.println(fraction1 + " - " + "2" + " = " + fraction1.minus(2));
        System.out.println(fraction3 + " * " + fraction4 + " = " + fraction3.mul(fraction4));
        System.out.println(fraction3 + " * " + "2" + " = " + fraction3.mul(2));
        System.out.println(fraction4 + " / " + fraction5 + " = " + fraction4.div(fraction5));
        System.out.println(fraction5 + " / " + "5" + " = " + fraction5.div(5));
        System.out.println("((" + fraction1 + " + " + fraction2 + ") / " + fraction3 + ") - 5 = " + fraction1.sum(fraction2).div(fraction3).minus(5));
    }

    public static void testTask6() {
        Student student1 = new Student("Вася", 3, 4, 5, 4);
        Student student2 = new Student("Петя", 5, 5, 5, 5);
        System.out.println(student1.getName() + ": средний бал: " + student1.averageMarks() + " " + student1.isExcellentStudent());
        System.out.println(student2.getName() + ": средний бал: " + student2.averageMarks() + " " + student2.isExcellentStudent());
    }

    public static void testTask7() {
        Polyline polyline = new Polyline(new Point(1, 5), new Point(2, 8), new Point(5, 3));
        System.out.println(polyline.length());
        polyline.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println(polyline.length());
    }

    public static void testTask8() {
        Square square = new Square(5, 3, 23);
        Polyline polyline = square.getPolyline();
        System.out.println(polyline.length());
        polyline.setPoint(polyline.getPoints().size() - 1, new Point(15, 25));
        System.out.println(polyline.length());
    }

}

class TestBlockTask1_6 {
    public static void TestTask1() {
        House house1 = new House(10);
        System.out.println(house1);
        House house2 = new House(0);
        System.out.println(house2);
        House house3 = new House(-5);
        System.out.println(house3);
    }

    public static void TestTask2_1() {
        Name name = Name.builder()
                .firstName("Вася")
                .build();
        System.out.println(name);
    }

    public static void TestTask2_2() {
        Name name = Name.builder()
                .firstName("Вася")
                .surname("Чудов")
                .patronymic(null)
                .build();
        System.out.println(name);
    }

    public static void TestTask2_3() {
        Name name = Name.builder()
                .firstName("")
                .build();
        System.out.println(name);
    }

    public static void TestTask2_4() {
        Name name = Name.builder()
                .firstName(null)
                .build();
        System.out.println(name);
    }

    public static void TestTask2_5() {
        Name name = Name.builder()
                .firstName(null)
                .surname("")
                .patronymic(null)
                .build();
        System.out.println(name);
    }

    public static void TestTask2_6() {
        Name name = Name.builder()
                .firstName(null)
                .surname("")
                .patronymic("Иванович")
                .build();
        System.out.println(name);
    }

    public static void TestTask3_1() {
        Square square = new Square(1, 2, 5);
        System.out.println(square.getLengthSide());
        square.setLengthSide(10);
        System.out.println(square.getLengthSide());
        square.setLengthSide(0);
    }

    public static void TestTask3_2() {
        Square square = new Square(1, 2, -5);
    }

    public static void TestTask4_1() {
        Fraction fraction = new Fraction(5, -2);
    }

    public static void TestTask4_2() {
        Fraction fraction = new Fraction(5, 0);
    }

    public static void TestTask4_3() {
        Fraction fraction = new Fraction(5, 1);
        System.out.println(fraction.sum(6));
        System.out.println(fraction.div(-5));
    }

    public static void TestTask4_4() {
        Fraction fraction = new Fraction(-5, 1);
        System.out.println(fraction.sum(6));
        System.out.println(fraction.div(5));
        System.out.println(fraction.div(new Fraction(-5, 1)));
    }

    public static void TestTask4_5() {
        Fraction fraction = new Fraction(-5, 1);
        System.out.println(fraction.div(new Fraction(-5, -1)));
    }

    public static void TestTask5() {
        Gun gun = new Gun(7, 3);
        for (int i = 0; i < 5; i++) gun.shoot();
        gun.setCount(8);
        gun.shoot();
        gun.shoot();
        gun.discharge();
        gun.shoot();
    }

    public static void TestTask6() {
        Point point1 = new Point(1, 3);
        Point point2 = new Point(5, 5);
        Point point3 = new Point(10, 5);
        Line line1 = new Line(point1, point2, Point.class);
        Line line2 = new Line(point1, point3, Point.class);
        if (!line1.getStartPoint().equals(line2.getStartPoint()))
            System.out.println("Линии не ссылаются на один объект точки");
    }

    public static void TestTask8_1() {
        Student student = new Student("Вася", 2, 3, 5, 1);
    }

    public static void TestTask8_2() {
        Student student = new Student("Вася", 2, 6, 5, 5);
    }

    public static void TestTask8_3() {
        Student student = new Student("Вася", 2, 3, 5, 5);
        System.out.println(student.getMarks());
    }

    public static void TestTask8_4() {
        Student student = new Student("Вася", 2, 5, 5, 3);
        student.setMarksIndex(2, 6);
    }

    public static void TestTask8_5() {
        Student student = new Student("Вася", 2, 5, 5, 3);
        student.setMarksIndex(2, 2);
        System.out.println(student.getMarks());
    }

    public static void TestTask9_1() {
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        cityA.setWay(0, new Way(cityB, 5));
        cityA.setWay(1, new Way(cityC, 6));
        cityB.setWay(0, new Way(cityA, 5));
        cityB.setWay(1, new Way(cityC, 7));
        cityB.setWay(2, new Way(cityA, 10));
        System.out.println(cityA);
        System.out.println(cityB);
    }

    public static void TestTask9_2() {
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        cityA.setWay(0, new Way(cityB, 5));
        cityA.setWay(1, new Way(cityC, 6));
        cityB.setWay(0, new Way(cityA, 5));
        cityC.setWay(0, new Way(cityA, 10));
        cityA.deleteWay(1);
        System.out.println(cityA);
    }

    public static void TestTask10() {
        Department departmentIT = new Department("IT");
        Department departmentHR = new Department("HR");
        Employee employee1 = new Employee("Петрова", departmentIT);
        Employee employee2 = new Employee("Козлова", departmentIT);
        Employee employee3 = new Employee("Сидорова", departmentHR);
        departmentIT.setDirector(employee3);
        departmentIT.setDirector(employee2);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee2.getDepartment().getEmployees());
        System.out.println(employee3.getDepartment().getEmployees());
        employee2.setDepartment(departmentHR);
        System.out.println(employee2);
        System.out.println(employee1);
    }

}

class TestBlockTest2_1 {
    public static void Task2() {
        Point point1 = new Point(1, 4);
        Point point2 = new Point(5, 1);
        Point point3 = new Point(6, 2);
        Point point4 = new Point(10, 4);
        ClosedPolyline closedPolyLine = new ClosedPolyline(point1, point2, point3, point4);
        Polyline polyLine = new Polyline(point1, point2, point3, point4);
        System.out.println("Длина замкнутой линии: " + closedPolyLine.length());
        System.out.println("Длина обычной линии: " + polyLine.length());
        System.out.println("Разница линий должна быть - " + new Line(point1, point4, Point.class).length());
    }

    public static void Task3() {
        City cityA = new City("A");
        CityBackWay cityB = new CityBackWay("B");
        City cityC = new City("C");
        cityB.setWays(new Way(cityA, 5), new Way(cityC, 10));
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
    }

    public static void Task4_1() {
        Automate automate = new Automate(4);
        automate.setCount(10);
        System.out.println(automate.getCount());
        automate.shoot();
    }

    public static void Task4_2() {
        Automate automate = new Automate(4);
        automate.setCount(6);
        automate.shoot(3);
    }

    public static void Task4_3() {
        Automate automate = new Automate(4, 5);
        automate.setCount(6);
        automate.shoot();
    }

    public static void Task5() {
        ru.chichkov.geometry.point.Point3D point3D = new ru.chichkov.geometry.point.Point3D(1, 2, 3);
        System.out.println(point3D);
    }
}

class TestBlockTask2_2 {
    public static void Task2() {
        Fraction fraction = new Fraction(-5, 1);
        Fraction fraction1 = fraction.sum(6);
        fraction1 = fraction1.div(fraction);
        fraction1 = fraction1.sum(-1);
        System.out.println(fraction1);
        System.out.println(fraction1.intValue());
        System.out.println(fraction1.longValue());
        System.out.println(fraction1.doubleValue());
        System.out.println(fraction1.floatValue());
    }

    public static void Task3() {
        Sparrow sparrow = new Sparrow();
        sparrow.sing();
        Cuckoo cuckoo = new Cuckoo();
        cuckoo.sing();
        Parrot parrot = new Parrot("Я умею говорить!");
        parrot.sing();
    }

    public static void Task4_1() {
        Circle circle = new Circle(10);
        System.out.println(circle.square());
    }

    public static void Task4_2() {
        ru.chichkov.geometry.shape.Square square = new ru.chichkov.geometry.shape.Square(3);
        square.setLengthB(1);
        square.setLength(2);
        System.out.println(square.getLengthA());
        System.out.println(square.getLengthB());
        System.out.println(square.square());
    }

    public static void Task4_3() {
        Rectangle rectangle = new Rectangle(4, 4);
        rectangle.setLengthA(2);
        System.out.println(rectangle.getLengthA());
        System.out.println(rectangle.getLengthB());
        System.out.println(rectangle.square());
    }

    public static void Task4_4() {
        Triangle triangle = new Triangle(2, 2, 3);
        triangle.setLengthA(3);
        System.out.println(triangle.getLengthA());
        System.out.println(triangle.getLengthB());
        System.out.println(triangle.getLengthC());
        System.out.println(triangle.square());
    }

    public static void Task5_1() {
        Point1D point1D = new Point1D(4);
        point1D.addAttributeLine(new Color("Red"));
        point1D.addAttributeLine(new Size(6));
        System.out.println(point1D);
        System.out.println(point1D.getAttributeLine().get(0).getName() + ": " + point1D.getAttributeLine().get(0).getValue());
        System.out.println(point1D.getAttributeLine().get(1).getName() + ": " + point1D.getAttributeLine().get(1).getValue());
    }

    public static void Task5_2() {
        Point3D point3D = new Point3D(4, 7, 2);
        point3D.addAttributeLine(new Color("Red"));
        point3D.addAttributeLine(new Size(6));
        System.out.println(point3D);
        System.out.println(point3D.getAttributeLine().get(0).getName() + ": " + point3D.getAttributeLine().get(0).getValue());
        System.out.println(point3D.getAttributeLine().get(1).getName() + ": " + point3D.getAttributeLine().get(1).getValue());
    }
}

class TestBlockTask2_3 {
    public static void Task1_1() {
        Fraction fraction = new Fraction(3, 5);
        System.out.println(MathMethods.sum(2, fraction, 2.3));
    }

    public static void Task1_2() {
        Fraction fraction1 = new Fraction(49, 12);
        Fraction fraction2 = new Fraction(3, 2);
        System.out.println(MathMethods.sum(3.6, fraction1, 3, fraction2));
    }

    public static void Task1_3() {
        Fraction fraction = new Fraction(1, 3);
        System.out.println(MathMethods.sum(fraction, 1));
    }

    public static void Task2() {
        Birds.birds(new Sparrow(), new Cuckoo(), new Sparrow(), new Parrot("Я умею говорить!"), new Sparrow());
    }

    public static void Task3() {
        System.out.println(GeneralSquare.generalSquare(new Rectangle(4, 4), new Circle(10), new ru.chichkov.geometry.shape.Square(5)));
    }

    public static void Task4() {
        MeowAnimals.meow(new Cat("Барсик"), new Dolphin("Кузя"), new Cat("Тузик"));
    }

    public static void Task5() {
        Point point1 = new Point(1, 4);
        Point point2 = new Point(5, 1);
        Point point3 = new Point(6, 2);
        Point point4 = new Point(10, 4);
        Line line = new Line(point2, point4, Point.class);
        ClosedPolyline closedPolyLine = new ClosedPolyline(point1, point2, point3, point4);
        Polyline polyLine = new Polyline(point1, point2, point3, point4);
        System.out.println(InterfaceLength.generalLength(line, closedPolyLine, polyLine));
    }

    public static void Task7() {
        Square square1 = new Square(0, 0, 10);
        Square square2 = new Square(10, 0, 5);
        System.out.println(InterfacePolyline.generalPolyline(square1, square2));
    }

    public static void Task8() {
        Weapon gun = new Gun(10, 2);
        Weapon automate = new Automate(10, 5);
        Shooter shooter1 = new Shooter("Владимир");
        Shooter shooter2 = new Shooter("Евгений");
        shooter2.setWeapon(gun);
        Shooter shooter3 = new Shooter("Сергей");
        shooter3.setWeapon(automate);
        shooter1.shoot();
        System.out.println();
        shooter2.shoot();
        System.out.println();
        shooter3.shoot();
    }

    public static void Task9() {
        Student student1 = new Student("Вася", new Rule1Or0(), 1, 2, 0, 1);
        System.out.println(student1.averageMarks());
        Student student2 = new Student("Петя", new RuleEvenNumber(), 0, 6, 82, 18);
        System.out.println(student2.averageMarks());
    }
}

class TestBlockTask3_1 {
//    public static void Task3() {
//        System.out.println(MathMethods.sum(7, new Fraction(11, 3), 3.21,
//                new BigInteger(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2})));
//    }

    public static void Task4() {
        System.out.println(MathMethods.myPow("5", "2"));
    }

    public static void Task5() {
        Point point = new Point(5, 6);
        java.awt.Point point2 = new java.awt.Point(4, 5);
        System.out.println(point);
        System.out.println(point2);
    }
}

class TestBlockTask4_1 {
    public static void Task4() throws LossOfConnectionException {
        Connection connection = new Connection("169.00.34.01");
        connection.close();
        System.out.println(connection.info());
    }
}

class TestBlockTask4_2 {

    // Задача 4.2.1
    public static void Task1() throws LossOfConnectionException {
        Connection connection = new Connection("ermakov.edu");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(connection.info());
            }
        } catch (LossOfConnectionException e) {
            throw new RuntimeException("Ошибка подключения!");
        } finally {
            connection.close();
        }
    }

    public static void Task2() {
        System.out.println(MathMethods.divNumbersFromString("45", "5", "five", "3"));
        System.out.println(MathMethods.divNumbersFromString("one", "two", "45", "5", "five", "3"));
        System.out.println(MathMethods.divNumbersFromString("one", "two", "45", "5", "five", "3", "two", "2"));
        System.out.println(MathMethods.divNumbersFromString("one", "two", "five"));
    }

    public static void Task3() {
        Student student1 = new Student("Вася", new Rule0To10(), 1, 0, 1);
        Student student2 = new Student("Петя", new RuleEvenNumber(), 0, 6, 82, 18);
        MethodsStudent.addMarkFromStudents(student1, student2);
        System.out.println(student1.getMarks());
        System.out.println(student2.getMarks());
    }

    public static void Task4(int maxRandomMark) {
        Random random = new Random();
        int randomCount = random.nextInt(10);
        List<String> constructorArgs = new ArrayList<>(randomCount);
        List<String> addArgs = new ArrayList<>(randomCount);
        for (int i = 0; i < randomCount; i++) {
            char[] charsConstructor = new char[random.nextInt(10)];
            for (int j = 0; j < charsConstructor.length; j++) {
                charsConstructor[j] = (char) (random.nextInt(73) + 48);
            }
            constructorArgs.add(String.valueOf(charsConstructor));
            addArgs.add(String.valueOf(random.nextInt(maxRandomMark)));
        }

//        List<Student> students;
//        try {
//            students = MethodsStudent.convert(constructorArgs, addArgs);
//            System.out.println(students);
//        }
//        catch (NotCorrectMarksException e) {
//            students = MethodsStudent.convert(constructorArgs, new ArrayList<>());
//            System.out.println(students);
//        }
        try {
            List<Student> students = MethodsStudent.convert(constructorArgs, addArgs);
            System.out.println(students);
        } catch (RuntimeException e) {
            StackTraceElement element = e.getStackTrace()[0];
            if (element.getMethodName().equals("convert")) {
                System.out.println("Не удалось создать студента");
            } else if (element.getMethodName().equals("setMarksIndex")) {
                List<Student> students = MethodsStudent.convert(constructorArgs, new ArrayList<>());
                System.out.println(students);
            } else {
                System.out.println("Ошибка: " + Arrays.toString(e.getStackTrace()));
            }
        }

    }
}

class TestBlockTask5_1 {
    public static void Task1() {
        Fraction fraction1 = new Fraction(10, 5);
        Fraction fraction2 = new Fraction(10, 5);
        Fraction fraction3 = fraction1;
        Fraction fraction4 = new Fraction(11, 5);
        System.out.println(fraction1.equals(fraction2));
        System.out.println(fraction1.equals(fraction3));
        System.out.println(fraction1.equals(fraction4));
        System.out.println(fraction1.hashCode());
        System.out.println(fraction2.hashCode());
        System.out.println(fraction3.hashCode());
        System.out.println(fraction4.hashCode());
    }

    public static void Task2() {
        ru.chichkov.geometry.point.Point3D point3D1 = new ru.chichkov.geometry.point.Point3D(1, 2, 3);
        ru.chichkov.geometry.point.Point3D point3D2 = new ru.chichkov.geometry.point.Point3D(1, 2, 3);
        ru.chichkov.geometry.point.Point3D point3D3 = new ru.chichkov.geometry.point.Point3D(2, 2, 3);
        System.out.println(point3D1.equals(point3D2));
        System.out.println(point3D1.equals(point3D3));
        System.out.println(point3D1.hashCode());
        System.out.println(point3D2.hashCode());
        System.out.println(point3D3.hashCode());
    }

    public static void Task3() {
        Line line1 = new Line(1, 2, 3, 4);
        Line line2 = new Line(1, 2, 3, 4);
        Line line3 = new Line(3, 4, 1, 2);
        Line line4 = new Line(4, 3, 2, 1);
        System.out.println(line1.equals(line2));
        System.out.println(line1.equals(line3));
        System.out.println(line1.equals(line4));
        System.out.println(line1.hashCode());
        System.out.println(line2.hashCode());
        System.out.println(line3.hashCode());
        System.out.println(line4.hashCode());
    }

    public static void Task4() {
        Polyline polyline1 = new Polyline(new Point(1, 2), new Point(3, 4), new Point(7, 8));
        ClosedPolyline closedPolyline = new ClosedPolyline(new Point(1, 2), new Point(3, 4), new Point(7, 8));
        Polyline polyline2 = new Polyline(new Point(1, 2), new Point(3, 4), new Point(7, 8), new Point(1, 2));
        ClosedPolyline closedPolyline2 = new ClosedPolyline(new Point(1, 2), new Point(7, 8), new Point(3, 4));
        ClosedPolyline closedPolyline3 = new ClosedPolyline(new Point(1, 2), new Point(7, 8), new Point(3, 4));
        System.out.println(polyline1.equals(closedPolyline));
        System.out.println(polyline1.equals(polyline2));
        System.out.println(polyline2.equals(closedPolyline));
        System.out.println(polyline2.equals(closedPolyline2));

        System.out.println(closedPolyline.equals(closedPolyline2));
        System.out.println(closedPolyline.equals(polyline2));
        System.out.println(closedPolyline2.equals(closedPolyline3));

        System.out.println(polyline1.hashCode());
        System.out.println(closedPolyline.hashCode());
        System.out.println(polyline2.hashCode());
        System.out.println(closedPolyline2.hashCode());
        System.out.println(closedPolyline3.hashCode());
    }

    public static void Task5() {
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        CityBackWay cityD = new CityBackWay("D");
        cityA.setWays(new Way(cityB, 5), new Way(cityC, 6));
        cityB.setWays(new Way(cityA, 5));
        cityC.setWays(new Way(cityA, 10));
        cityD.setWays(new Way(cityC, 15), new Way(cityB, 5));

        System.out.println(cityA.equals(cityB));        // false
        System.out.println(cityA.equals(cityC));        // false
        System.out.println(cityA.equals(cityD) + "\n"); // true

        System.out.println(cityB.equals(cityA));        // false
        System.out.println(cityB.equals(cityC));        // true
        System.out.println(cityB.equals(cityD) + "\n"); // false

        System.out.println(cityC.equals(cityA));        // false
        System.out.println(cityC.equals(cityB));        // true
        System.out.println(cityC.equals(cityD) + "\n"); // false

        System.out.println(cityD.equals(cityA));        // true
        System.out.println(cityD.equals(cityB));        // false
        System.out.println(cityD.equals(cityC) + "\n"); // false

        System.out.println(cityA.hashCode());
        System.out.println(cityB.hashCode());
        System.out.println(cityC.hashCode());
        System.out.println(cityD.hashCode());
    }

    public static void Task6() {
        Student student1 = new Student("Вася", 2, 5, 4, 3);
        Student student2 = new Student("Вася", 2, 3, 4, 5);
        Student student3 = new Student("Петя", 2, 5, 4, 3);
        Student student4 = new Student("Вася", 2, 4, 4, 3);
        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
        System.out.println(student1.equals(student4));

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student4.hashCode());
    }
}

class TestBlockTask6_1 {
    public static void Task1() {
        Box<Integer> box = new Box<>();
        box.setObject(3);
        System.out.println(MathMethods.sum(box.getObject()));
    }

//    public static void Task2_1() {
//        Storage<Integer> storage = new Storage<>(null);
//        System.out.println(storage.getObject(0));
//    }
//
//    public static void Task2_2() {
//        Storage<Integer> storage = new Storage<>(99);
//        System.out.println(storage.getObject(-1));
//    }
//
//    public static void Task2_3() {
//        Storage<String> storage = new Storage<>(null);
//        System.out.println(storage.getObject("default"));
//    }
//
//    public static void Task2_4() {
//        Storage<String> storage = new Storage<>("hello");
//        System.out.println(storage.getObject("hello world"));
//    }

    public static void Task4() {
        Student student1 = new Student("Вася", 2, 3, 4, 5);
        Student student2 = new Student("Петя", 5, 3, 4, 2);
        System.out.println(student1.compareTo(student2));
    }

    public static void Task5() {
        ru.chichkov.geometry.point.Point3D startPoint = new ru.chichkov.geometry.point.Point3D(1, 2, 3);
        ru.chichkov.geometry.point.Point3D endPoint = new ru.chichkov.geometry.point.Point3D(4, 5, 6);
        Line<ru.chichkov.geometry.point.Point3D> line = new Line<>(startPoint, endPoint, ru.chichkov.geometry.point.Point3D.class);
        System.out.println(line);
        line.setEndPoint(new ru.chichkov.geometry.point.Point3D(7, 8, 9));
        System.out.println(line);
    }

    public static void Task6() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}

class TestBlockTask6_2 {
    public static void Task1() {
        Line<Point> line1 = new Line<>(1, 2, 3, 4);
        Line<ru.chichkov.geometry.point.Point3D> line2 = new Line<>(1, 2, 3, 4, 5, 6);
        System.out.println(line1);
        MethodsLine.moveLineToXBy10(line1);
        System.out.println(line1);
        System.out.println(line2);
        MethodsLine.moveLineToXBy10(line2);
        System.out.println(line2);
    }

    public static void Task2() {
        Box<Integer> box1 = new Box<>();
        Box<Integer> box2 = new Box<>();
        Box<Double> box3 = new Box<>();
        Box<Float> box4 = new Box<>();
        box1.setObject(3);
        box2.setObject(5);
        box3.setObject(10.5);
        box4.setObject(15.0f);
        System.out.println(MethodsBox.MaxValueFromBox(box1, box2, box3, box4));
    }

    public static void Task3() {
        Box<ru.chichkov.geometry.point.Point3D> box1 = new Box<>();
        Box<Point> box2 = new Box<>();
        MethodsBox.BoxWithPoint3D(box1);
        MethodsBox.BoxWithPoint3D(box2);
        System.out.println(box1.getObject());
        System.out.println(box2.getObject());
    }

    public static void Task4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        MathMethods.fillingNumbers(list);
        System.out.println(list);
    }
}

class TestBlockTask6_3 {
    public static void Task1_1() {
        List<String> list = List.of("qwerty", "asdfg", "zx");
        List<Integer> newList = DataStream.of(list)
                .map(String::length)
                .collect(ArrayList::new, ArrayList::add);
        System.out.println(newList);
    }

    public static void Task1_2() {
        List<Integer> list = List.of(1, -3, 7);
        List<Integer> newList = DataStream.of(list)
                .map(Math::abs)
                .collect(ArrayList::new, ArrayList::add);
        System.out.println(newList);
    }

    public static void Task1_3() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        list.add(new Integer[]{10, -5, 0, 1, 2, 3, 4, 5});
        list.add(new Integer[]{-50, 7, 8, 9, 20, 1});
        List<Integer> newList = DataStream.of(list)
                .map(MathMethods::max)
                .collect(ArrayList::new, ArrayList::add);
        System.out.println(newList);
    }

    public static void Task2_1() {
        List<String> list = List.of("qwerty", "asdfg", "zx");
        List<String> newList = DataStream.of(list)
                .filter(s -> s.length() >= 3)
                .collect(ArrayList::new, ArrayList::add);
        System.out.println(newList);
    }

    public static void Task2_2() {
        List<Integer> list = List.of(1, -3, 7);
        Integer res = DataStream.of(list)
                .filter(n -> n > 0)
                .reduce(Integer::sum);
        //    .collect(ArrayList::new, ArrayList::add);
        System.out.println(res);
    }

    public static void Task2_3() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        list.add(new Integer[]{-10, -5, -0, -1, -2, -3, -4, -5});
        list.add(new Integer[]{-50, 7, 8, 9, 20, 1});
        List<Integer[]> newList = DataStream.of(list)
                .filter(MathMethods::negativeArray)
                .collect(ArrayList::new, ArrayList::add);
        for (Integer[] i : newList) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void Task3_1() {
        List<String> list = List.of("qwerty", "asdfg", "zx");
        String concat = DataStream.of(list)
                .reduce((s1, s2) -> s1 + s2);
        System.out.println(concat);
    }

    public static void Task3_2() {
        List<String> list = List.of("1", "-3", "7");
        Integer sum = DataStream.of(list)
                .map(Integer::parseInt)
                .filter(x -> x > 0)
                .reduce(Integer::sum);
        System.out.println(sum);
    }

    public static void Task3_3() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        list.add(Arrays.asList(-10, -5, -0, -1, -2, -3, -4, -5));
        list.add(Arrays.asList(-50, 7, 8, 9, 20, 1));
        Integer countElement = DataStream.of(list)
                .map(List::size)
                .reduce(Integer::sum);
        System.out.println(countElement);
    }

    public static void Task4_1() {
        Integer sum = DataStream.of("1", "-3", "7")
                .map(Integer::parseInt)
                .filter(x -> x > 0)
                .reduce(Integer::sum);
        System.out.println(sum);
    }
}

class Generate {
    List<String> list = new ArrayList<>();

    public void add(List<String> list) {
        this.list = list;
    }
}

class TestBlockTask7_1 {
    public static void Task1_1() {
        Storage<Integer> storage1 = Storage.empty();
        System.out.println(storage1.getObject(0));
        Storage<Integer> storage2 = Storage.of(null);
    }

    public static void Task1_2() {
        Storage<Integer> storage1 = Storage.ofNullable(null);
        Storage<Integer> storage2 = Storage.of(5);
        Storage<Integer> storage3 = Storage.ofNullable(null);
        System.out.println(storage1.getObject(0));
        System.out.println(storage2.getObject(0));
        System.out.println(storage3.getObject(0));
    }

    public static void Task1_3() {
        Storage<Integer> storage1 = Storage.lazy(() -> Stream.of(1, 2, 3)
                .map(x -> x * 2)
                .reduce(Integer::sum)
                .orElse(0));
        System.out.println(storage1.getObject(0));
    }

    public static void Task3() {
        GenerateFraction generateFraction = new Fraction.GenerateFractionImpl();
        Fraction fraction1 = generateFraction.generate(5, 10);
        Fraction fraction2 = generateFraction.generate(10, 5);
        Fraction fraction3 = generateFraction.generate(1, 1);
        Storage<Fraction> storage = Storage.lazy(() -> Stream.of(fraction1, fraction2, fraction3)
                .map((x) -> x.sum(5))
                .reduce(Fraction::sum)
                .orElse(new Fraction(0, 0)));
        System.out.println(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction3);
        System.out.println(storage.getObject(new Fraction(0, 0)));
        GenerateFraction generateFraction2 = new Fraction.GenerateFractionImpl();
    }

    public static void Task4() {
        GenerateFraction generateFraction = new Fraction.GenerateFractionImpl();
        Fraction fraction1 = generateFraction.generate(5, 10);
        Fraction fraction2 = generateFraction.generate(5, 10);
        Fraction fraction3 = generateFraction.generate(10, 5);
        System.out.println(fraction1 == fraction2);
        System.out.println(fraction1 == fraction3);
    }

    public static void Task5() {
        Temperature temperature1 = new Temperature("Холодно");
        System.out.println(temperature1.getMinTemp() + " ... " + temperature1.getMaxTemp());
        Temperature temperature2 = new Temperature("НОРМАЛЬНО");
        System.out.println(temperature2.getMinTemp() + " ... " + temperature2.getMaxTemp());
        Temperature temperature3 = new Temperature("ЖАРко");
        System.out.println(temperature3.getMinTemp() + " ... " + temperature3.getMaxTemp());
        Temperature temperature4 = new Temperature("Хорошо");
    }

    public static void Task6() throws Exception {
        Database database = new Database(2);
        ConnectionBD connection1 = database.getConnection();
        ConnectionBD connection2 = database.getConnection();
        ConnectionBD connection3 = database.getConnection();
        System.out.println(connection1 + "\n" + connection2 + "\n" + connection3);
        System.out.println(connection1.get(0));
        System.out.println(connection2.get(10));
        connection2.add("11");
        System.out.println(connection2.get(10));
        connection2.close();
        System.out.println(connection2.get(5));
        connection3 = database.getConnection();
        System.out.println(connection3.get(5));
    }
}

class TestBlockTask7_2 {
    public static void Task1() {
        System.out.println(MathMethods.sum(new SumIntegers(1), new SumIntegers(10), new SumStrings("abc")));
    }

    public static void Task2() {
        System.out.println(InterfaceLength.generalLength(new LengthStrings("abcd"), new LengthStrings("ab"),
                new Line<Point>(new Point(1, 1), new Point(3, 3), Point.class)));
    }

    public static void Task3() {
        MeowAnimals meowAnimals = new Cat("Барсик");
        CountMeow countMeow = new CountMeow(meowAnimals);
        Task3_testFun(countMeow);
        System.out.println(countMeow.getCountMeow());
    }

    public static void Task3_testFun(MeowAnimals meowAnimals) {
        for (int i = 0; i < 10; i++) meowAnimals.meow();
    }

    public static void Task4() {
        MeowAnimals cat = new Cat("Барсик");
        cat.meow();
        GavAnimals dog = new Dog("Шарик");
        dog.gav();
        CatDog catDog = new CatDog("КотоПес");
        catDog.gav();
        catDog.meow();
    }

    public static void Task7() {
        Line<Point> line1 = new Line<>(1, 1, 5, 5);
        CachingLine cachingLine = new CachingLine(line1);
        System.out.println(cachingLine.length());
        System.out.println(cachingLine.length());
        cachingLine.setStartPoint(new Point(2, 2));
        System.out.println(cachingLine.length());
    }
}

class TestBlockTask7_3 {
    public static void Task1() {
        DatabasePattern database = new DatabasePattern(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5")));
        database.addConverter(Integer.class, Integer::parseInt);
        database.addConverter(String.class, String::toString);
        database.addConverter(Point.class, x -> new Point(Integer.parseInt(x), Integer.parseInt(x)));
        System.out.println(database.get(2, Integer.class) + 1);
        System.out.println(database.get(2, String.class) + 1);
        System.out.println(database.get(2, Point.class));
    }

    public static void Task2() {
        KarateKid karateKid = new KarateKid("Дэниэл");
        Combination combination = new Combination();
        combination.addBead(KarateKid::beatHand);
        combination.addBead(KarateKid::beatLegs);
        combination.addBead(KarateKid::beatHand);
        combination.addBead(KarateKid::beatInJump);
        combination.beat(karateKid);
    }

    public static void Task4() {
        Student student = new Student("Петя", 1);
        student.addMarks(2);
        student.addMarks(5);
        student.setName("Коля");
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
    }

    public static void Task5() {
        Student student = new Student("Петя", 1);
        student.addMarks(2);
        SaveStudent saveStudent = new SaveStudentImpl(student);
        student.addMarks(5);
        student.setName("Коля");
        System.out.println(student);
        System.out.println(student.getSave(saveStudent));
    }

    public static void Task8() {
        Stock stock1 = Stock.of("ORCL", 75);
        Stock stock2 = Stock.of("TSLA", 696);
        Printer printer = new Printer();
        Bot bot = new Bot();
        stock1.addListener(printer);
        stock2.addListener(printer);
        stock1.addListener(bot);
        stock2.addListener(bot);
        stock1.setPrice(71);
        stock2.setPrice(700);
        stock1.setPrice(60);
        stock2.setPrice(50);
    }

    public static void Task9() {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
        trafficLight.next();
    }

    public static void Task12() {
        Polyline polyline = new Polyline(new Point(1, 1), new Point(5, 5), new Point(10, 10));
        for (Point p : polyline) {
            System.out.println(p);
        }
        Iterator<Point> pointIterator = polyline.iteratorFrom(new Point(5, 5));
        while (pointIterator.hasNext()) {
            System.out.println(pointIterator.next());
        }
    }
}

class testMyLinkedList {
    public static void withListIterator() {
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        ListIterator<Integer> iterator = linkedList.listIterator();
        iterator.next();
        iterator.next();
        iterator.add(48);
        iterator.add(49);
    }

    public static void withSubList() {
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        linkedList.subList(2, 4);
    }
}

class TaskStream {
    //    Задание 1:
//    Написать следующую стриму:
//    дан набор объектов типа Point,
//    необходимо взять все Point в разных координатах, (убрать с одинаковыми X,Y),
//    отсортировать по X, отрицательные Y сделать положительными и собрать это все в ломаную (объект типа Polyline)
    public static void task1() {
        List<Point> points = List.of(
                new Point(1, 1),
                new Point(2, 2),
                new Point(1, 1),
                new Point(5, -6),
                new Point(4, 9),
                new Point(2, -5)
        );
//        Polyline polyline = new Polyline(points.stream()
//                .distinct()
//                .sorted(Comparator.comparingInt(Point::getX))
//                .map((Point x) -> new Point(x.getX(), Math.abs(x.getY())))
//                .collect(Collectors.toList()));
        Polyline polyline = points.stream()
                .distinct()
                .map((Point x) -> new Point(x.getX(), Math.abs(x.getY())))
                .sorted(Comparator.comparingInt(Point::getX))
                .collect(Polyline::new,
                        Polyline::addPoints,
                        (line1, line2) -> line1.addPoints(line2.getPoints()));
        System.out.println(polyline);
    }

    //    Задание 2:
//    Дан текстовый файл с строками содержащими имя человека и его номер в следующей форме:
//    Вася:5
//    Петя:3
//    Аня:5
//    Номера людей могут повторяться.
//    У каких-то людей может не быть номера.
//    Необходимо написать стриму выполняющую следующее:
//    читаются все люди из файла, все имена приводится к нижнему регистру,
//    но с первой буквой в верхнем регистре, убираем из перечня всех людей без номеров,
//    а имена оставшихся группируются по их номеру:
//    [5:[Вася, Аня], 3:[Петя]]
    public static void task2() {
        Path filePath = Paths.get("src/main/resources/people.txt");
        try {
            Map<Integer, List<String>> groupedPeople = readFile(filePath);
            System.out.println(groupedPeople);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static Map<Integer, List<String>> readFile(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines
                    .map(line -> line.split(":"))
                    .filter(line -> line.length == 2 && !line[1].isEmpty())
                    .map((line) -> {
                        String name = line[0].trim();
                        String number = line[1].trim();
                        name = name.substring(0, 1).toUpperCase() + name.substring(1).toUpperCase();
                        return new AbstractMap.SimpleEntry<>(Integer.parseInt(number), name);
                    })
                    .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                            Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toList())));
        }
    }
}

class TestBlockTask8_3 {
    public static void Task1() {
        System.out.println(Reflections.collect(A.class, B.class));
    }

    public static void Task2() {
        A a = new A();
        Reflections.reset(a);
        System.out.println(a);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        TestBlockTask8_3.Task2();
    }
}