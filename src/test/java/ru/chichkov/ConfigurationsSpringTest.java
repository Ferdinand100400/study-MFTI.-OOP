package ru.chichkov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.chichkov.exception.NotCorrectMarksException;
import ru.chichkov.reviews.Review;
import ru.chichkov.student.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConfigurationsSpringTest {
    ApplicationContext context = new AnnotationConfigApplicationContext("ru.chichkov.ConfigurationSpring");

    @Test
    public void testBeanHelloWorld() {
        String actual = context.getBean(String.class);
        Assert.assertEquals("Hello world", actual);
    }

    @Test
    public void testBeanRandom() {
        int actual1 = context.getBean("random", int.class);
        int actual2 = context.getBean("random", int.class);
        System.out.println(actual1 + "\n" + actual2);
        Assert.assertNotEquals(actual1, actual2);
    }

    @Test
    public void test2BeanRandom() {
        List<Integer> listActual = new ArrayList<>();
        int max = context.getBean("max", int.class);
        int min = context.getBean("min", int.class);
        for (int i = 0; i < 2 * (max - min); i++) {
            int actual = context.getBean("random", int.class);
            if (listActual.size() < (max - min - 1)) Assert.assertFalse(listActual.contains(actual));
            listActual.add(actual);
        }
        System.out.println(listActual.stream()
                        .sorted()
                        .collect(Collectors.toList()));
    }

    @Test
    public void testBeanStart() {
        Date actual = context.getBean(Date.class);
        System.out.println(actual);
        Assert.assertEquals(new Date().toString(), actual.toString());
    }

    @Test
    @DisplayName("The number is in the range 2 - 5")
    public void testBeanRangeNumberInRange() {
        Predicate<Integer> actual = context.getBean(Predicate.class);
        Assert.assertTrue(actual.test(2));
        Assert.assertTrue(actual.test(3));
        Assert.assertTrue(actual.test(4));
        Assert.assertTrue(actual.test(5));
    }

    @Test
    @DisplayName("The number is not in the range 2 - 5")
    public void testBeanRangeNumberNotInRange() {
        Predicate<Integer> actual = context.getBean(Predicate.class);
        Assert.assertFalse(actual.test(1));
        Assert.assertFalse(actual.test(6));
    }

    @Test
    public void testBeanMax() {
        int actual = context.getBean("max", int.class);
        Assert.assertEquals(100, actual);
    }

    @Test
    public void testBeanMin() {
        int actual = context.getBean("min", int.class);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testGoodReview() {
        Review expected = new Review("Очень хорошо", 4);
        Assert.assertEquals(expected.toString(), context.getBean("goodReview").toString());
    }

    @Test
    public void testSatisfactoryReview() {
        Review expected = new Review("Сойдет", 3);
        Assert.assertEquals(expected.toString(), context.getBean("satisfactoryReview").toString());
    }

    @Test
    public void testNotKnownReview() {
        System.out.println(context.getBean("notKnownReview"));
    }

    @Test
    public void testBestReview() {
        System.out.println("Best Review: " + context.getBean("bestReview"));
    }

    @Test
    public void testStudent1() {
        Student student = (Student) context.getBean("student1");
        student.setMarks(4,4,3,5,5);
        Exception exception = Assert.assertThrows(NotCorrectMarksException.class, () -> student.addMarks(2,1,5));
        Assert.assertEquals(student.getName() + "- оценка не удовлетворяет правилу", exception.getMessage());
    }
}
