package studyMFTI;

import studyMFTI.Point.Point;
import studyMFTI.Point.Point3D;
import studyMFTI.Weapon.Automate;
import studyMFTI.Weapon.Gun;
import studyMFTI.City.City;
import studyMFTI.City.CityBackWay;
import studyMFTI.City.Way;
import studyMFTI.Polyline.ClosedPolyline;
import studyMFTI.Polyline.Polyline;

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
    public static void testTask1() {
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));

        line1.setStartPoint(new Point(2, 5));
        line1.setEndPoint(new Point(20, 50));
        line2.setStartPoint(new Point(2, 10));
        line2.setEndPoint(new Point(10, 10));

        line1.setEndPoint(new Point(100, 25));

        Line line3 = new Line(line1.getStartPoint(), line2.getEndPoint());
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
    }
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
        System.out.println(employee2.getDepartment().employees);
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
        Line line6 = new Line(line4.getStartPoint(), line5.getEndPoint());
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
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Сергеевич", "Пушкин");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
    }

    public static void testTask6() {
        Human human1 = new Human("Лев");
        Human human2 = new Human(new Name("Сергей", "Пушкин"), human1);
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
        Name name = new Name("Вася");
        System.out.println(name);
    }

    public static void TestTask2_2() {
        Name name = new Name("Вася", "Чудов", null);
        System.out.println(name);
    }

    public static void TestTask2_3() {
        Name name = new Name("");
        System.out.println(name);
    }

    public static void TestTask2_4() {
        Name name = new Name(null);
        System.out.println(name);
    }

    public static void TestTask2_5() {
        Name name = new Name(null, "", null);
        System.out.println(name);
    }

    public static void TestTask2_6() {
        Name name = new Name(null, "", "Иванович");
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
        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point1, point3);
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
        System.out.println(employee2.getDepartment().employees);
        System.out.println(employee3.getDepartment().employees);
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
        System.out.println("Разница линий должна быть - " + new Line(point1, point4).length());
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
        Automate automate = new Automate();
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
        Point3D point3D = new Point3D(1,2,3);
        System.out.println(point3D);
    }
}

public class Main {
    public static void main(String[] args) {
        TestBlockTest2_1.Task5();

    }
}