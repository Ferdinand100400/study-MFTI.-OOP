package ru.chichkov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

public class ConfigurationsSpringTest {
    ApplicationContext context = new AnnotationConfigApplicationContext("ru.chichkov.ConfigurationString");
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
}
