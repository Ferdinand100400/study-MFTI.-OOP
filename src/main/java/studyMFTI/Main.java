package studyMFTI;
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

public class Main {
    public static void main(String[] args) {
        TestBlockTask1_1.testTask1();
        TestBlockTask1_1.testTask4();
        TestBlockTask1_1.testTask5();

        TestBlockTask1_2.testTask1();

        TestBlockTask1_3.testTask2();
        TestBlockTask1_3.testTask3();
        TestBlockTask1_3.testTask4();

        TestBlockTask1_4.testTask1();
        TestBlockTask1_4.testTask2();
        TestBlockTask1_4.testTask3();
        TestBlockTask1_4.testTask4();
        TestBlockTask1_4.testTask5();
        TestBlockTask1_4.testTask6();
        TestBlockTask1_4.testTask7();

    }
}