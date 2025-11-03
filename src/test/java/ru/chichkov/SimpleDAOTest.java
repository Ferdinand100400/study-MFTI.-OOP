package ru.chichkov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.chichkov.DataBaseH2.dao.SimpleDAO;
import ru.chichkov.DataBaseH2.entity.Employee;

import java.sql.*;
import java.util.*;

public class SimpleDAOTest {
    String pathBD;

    @Before
    public void start() {
        pathBD = "jdbc:h2:C:\\Users\\ferdi\\IdeaProjects\\study_MFTI\\OOP\\src\\main\\resources\\BD";
        createBD();
    }

    @Test
    public void TestBD() {
        try (Connection connection = DriverManager.getConnection((pathBD))) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }

    @Test
    public void TestFindAll() {
        List<Employee> employeesExpected = Arrays.asList(
                new Employee(1, "Pete", 1),
                new Employee(2, "Anna", 1),
                new Employee(3, "Liza", 2),
                new Employee(4, "Tom", 2),
                new Employee(5, "Kate", 3)
        );
        try (Connection connection = DriverManager.getConnection((pathBD))) {
            SimpleDAO employee = new SimpleDAO<>(Employee.class, connection);
            List<String> employees = employee.findAll();
            Assert.assertEquals(employeesExpected.toString(), employees.toString());
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }

    @Test
    public void TestFindById() {
        Employee expected = new Employee(2, "Anna", 1);
        try (Connection connection = DriverManager.getConnection(pathBD)) {
            SimpleDAO employee = new SimpleDAO<>(Employee.class, connection);
            Assert.assertEquals(Optional.of(expected).toString(), employee.findByID(2).toString());
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }

    @Test
    public void TestUpdateAll() {
        Map<String, Object> update = new HashMap<>();
//        update.put("name", "null");
        update.put("DepartmentID", 3);
        try (Connection connection = DriverManager.getConnection(pathBD)) {
            SimpleDAO employee = new SimpleDAO<>(Employee.class, connection);
            System.out.println("Count update line: " + employee.updateAll(update));
            System.out.println(employee.findAll());
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }

    @Test
    public void TestDeleteAll() {
        Map<String, Object> update = new HashMap<>();
        update.put("id", 1);
        update.put("name", "Kate");
        try (Connection connection = DriverManager.getConnection(pathBD)) {
            SimpleDAO employee = new SimpleDAO<>(Employee.class, connection);
            System.out.println("Count delete line: " + employee.deleteAll(update));
            System.out.println(employee.findAll());
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }

    private void createBD() {
        try (Connection connection = DriverManager.getConnection((pathBD))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Department IF EXISTS");
            statement.executeUpdate("CREATE TABLE Department(ID INT PRIMARY KEY, NAME VARCHAR(255))");
            statement.executeUpdate("INSERT INTO Department VALUES(1, 'Accounting')");
            statement.executeUpdate("INSERT INTO Department VALUES(2, 'IT')");
            statement.executeUpdate("INSERT INTO Department VALUES(3, 'HR')");

            statement.executeUpdate("DROP TABLE Employee IF EXISTS");
            statement.executeUpdate("CREATE TABLE Employee(ID INT PRIMARY KEY, NAME VARCHAR(255), DepartmentID INT)");
            statement.executeUpdate("INSERT INTO Employee VALUES(1, 'Pete', 1)");
            statement.executeUpdate("INSERT INTO Employee VALUES(2, 'Anna', 1)");

            statement.executeUpdate("INSERT INTO Employee VALUES(3, 'Liza', 2)");
            statement.executeUpdate("INSERT INTO Employee VALUES(4, 'Tom', 2)");

            statement.executeUpdate("INSERT INTO Employee VALUES(5, 'Kate', 3)");
        } catch (SQLException e) {
            Assert.fail(String.valueOf(e));
        }
    }
}
