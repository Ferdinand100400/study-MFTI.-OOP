package ru.chichkov.tests;

import lombok.SneakyThrows;
import ru.chichkov.Annotation.Disabled;
import ru.chichkov.Annotation.Test;
import ru.chichkov.Annotation.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

class TestRunner {
    @SneakyThrows
    public static <T> Map<ResultType, List<TestResult>> run(Class<T> clz, List<String> tags) {

        Constructor<T> constructor= clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T object = constructor.newInstance();

        Map<ResultType, List<TestResult>> results= new HashMap();
        results.put(ResultType.PASS,new ArrayList<>());
        results.put(ResultType.ERROR,new ArrayList<>());
        results.put(ResultType.FAILED,new ArrayList<>());
        results.put(ResultType.DISABLED,new ArrayList<>());
        Method[] mets=clz.getDeclaredMethods();
        //mets.filter(tags) TODO: фильтруем по тегам
        //mets.sort(byOrder) TODO: сортируем по value в Order
        //mets.sort(byDependency) TODO: сортируем по порядку следования
        for (Method m: mets){
            if(!m.isAnnotationPresent(Test.class)) continue;

            String testName=m.getName();
            //TODO смотреть имя из аннотации
            if(!m.isAnnotationPresent(Disabled.class)){
                results.get(ResultType.DISABLED).add(new TestResult(testName,null));
                continue;
            }

            try{
                m.setAccessible(true);
                // Подготовка аргументов для метода
                List<Object> args = prepareArguments(m);
                //вызвать все что ДО TODO
                m.invoke(object, args);
                //вызвать все что ПОСЛЕ TODO
            } catch (InvocationTargetException e) {
                if(e.getCause().getClass() == TestFailedException.class){
                    results.get(ResultType.FAILED).add(new TestResult(testName,e.getCause()));
                }else{
                    results.get(ResultType.ERROR).add(new TestResult(testName,e.getCause()));
                }
                continue;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            results.get(ResultType.PASS).add(new TestResult(testName,null));
        }

        return results;
    }

    // Метод для подготовки аргументов для тестового метода
    private static List<Object> prepareArguments(Method method) {
        List<Parameter> parameters = List.of(method.getParameters());
        List<Object> args = new ArrayList<>();

        for (Parameter parameter: parameters) {
            Value valueAnnotation = parameter.getAnnotation(Value.class);
            if (valueAnnotation != null) {
                String propertyValue = valueAnnotation.value();
                // Преобразование типов
                try {
                    if (parameter.getType() == String.class) {
                        args.add(propertyValue);
                    } else if (parameter.getType() == Integer.class || parameter.getType() == int.class) {
                        args.add(Integer.parseInt(propertyValue));
                    } else if (parameter.getType() == Double.class || parameter.getType() == double.class) {
                        args.add(Double.parseDouble(propertyValue));
                    } else if (parameter.getType() == Boolean.class || parameter.getType() == boolean.class) {
                        args.add(Boolean.parseBoolean(propertyValue));
                    } else {
                        throw new IllegalArgumentException("Неизвестный тип: " + parameter.getType().getName());
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Ошибка преобразования " + parameter.getName() + e.getMessage());
                }

            } else {
                throw new IllegalArgumentException("Параметр " + parameter.getName() + " без аннотации @Value");
            }
        }
        return args;
    }
}
record TestResult(String name,Throwable t){}

enum ResultType{
    PASS, FAILED, ERROR, DISABLED
}