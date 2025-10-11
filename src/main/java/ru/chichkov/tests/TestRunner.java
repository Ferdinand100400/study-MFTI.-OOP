package ru.chichkov.tests;

import lombok.SneakyThrows;
import ru.chichkov.Annotation.Disabled;
import ru.chichkov.Annotation.Test;
import ru.chichkov.Annotation.TestData;
import ru.chichkov.Annotation.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

class TestRunner {
    @SneakyThrows
    public static <T> Map<ResultType, List<TestResult>> run(Class<T> clz, List<String> tags) {

        Constructor<T> constructor = clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T object = constructor.newInstance();

        Map<ResultType, List<TestResult>> results = new HashMap();
        results.put(ResultType.PASS, new ArrayList<>());
        results.put(ResultType.ERROR, new ArrayList<>());
        results.put(ResultType.FAILED, new ArrayList<>());
        results.put(ResultType.DISABLED, new ArrayList<>());
        Method[] mets = clz.getDeclaredMethods();
        //mets.filter(tags) TODO: фильтруем по тегам
        //mets.sort(byOrder) TODO: сортируем по value в Order
        //mets.sort(byDependency) TODO: сортируем по порядку следования
        for (Method m : mets) {
            if (!m.isAnnotationPresent(Test.class)) continue;

            String testName = m.getName();
            //TODO смотреть имя из аннотации
            if (!m.isAnnotationPresent(Disabled.class)) {
                results.get(ResultType.DISABLED).add(new TestResult(testName, null));
                continue;
            }

            try {
                m.setAccessible(true);
                //вызвать все что ДО TODO

                // Если есть аннотация TestData, то берем данные из нее
                if (m.isAnnotationPresent(TestData.class)) {
                    String dataMethodName = m.getAnnotation(TestData.class).value();
                    Method dataMethod = object.getClass().getMethod(dataMethodName);
                    dataMethod.setAccessible(true);
                    m.invoke(object, dataMethod.invoke(object));
                } else {
                    m.invoke(object);
                }

                //вызвать все что ПОСЛЕ TODO
            } catch (InvocationTargetException e) {
                if (e.getCause().getClass() == TestFailedException.class) {
                    results.get(ResultType.FAILED).add(new TestResult(testName, e.getCause()));
                } else {
                    results.get(ResultType.ERROR).add(new TestResult(testName, e.getCause()));
                }
                continue;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            results.get(ResultType.PASS).add(new TestResult(testName, null));
        }

        return results;
    }
}

record TestResult(String name, Throwable t) {
}

enum ResultType {
    PASS, FAILED, ERROR, DISABLED
}