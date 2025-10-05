package ru.chichkov.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.*;
import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reflections {

    // Задача 8.1.1
    public static List<Field> fieldCollection(Class<?> cls) {
        List<Field> fieldList = new ArrayList<>();
        while (cls != Object.class) {
            fieldList.addAll(List.of(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return fieldList;
    }

    // Задача 8.1.4
    public static void validate(Object obj, Class<?> classTests) throws InvocationTargetException {
        List<Method> methodsTest = List.of(classTests.getMethods());
        for (Method test : methodsTest) {
            if (!test.getReturnType().equals(void.class) || test.getParameterCount() != 1) return;
            try {
                Object o = classTests.getDeclaredConstructor().newInstance();
                test.setAccessible(true);
                test.invoke(o, obj);
            } catch (InvocationTargetException e) {
                Throwable causer = e.getCause();
                if (causer.getClass() == CertPathValidatorException.class)
                    throw new IllegalArgumentException("Validation failed in method: "
                            + test.getName() + " - " + e.getCause().getMessage());
                throw new RuntimeException();
            } catch (Exception e2) {
                throw new IllegalArgumentException();
            }
        }
    }

    // Задача 8.1.6
    public static <T> T cache(T obj) {
        Class<?> clazz = obj.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();

        if (interfaces.length > 0) {
            return (T) Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    interfaces,
                    new CachingInvocationHandler(obj)
            );
        } else {
            return (T) Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    new Class<?>[]{clazz},
                    new CachingInvocationHandler(obj)
            );
        }
    }

    private static class CachingInvocationHandler implements InvocationHandler {
        private final Object target;
        private String original;
        private final Map<Method, Object> cache = new HashMap<>();

        public CachingInvocationHandler(Object target) {
            this.target = target;
            for (Method method: target.getClass().getMethods()) {
                if (method.getParameterCount() == 0)
                    cache.put(method, null);
            }
            original = target.toString();
        }

        @Override
        @SneakyThrows
        public Object invoke(Object proxy, Method method, Object[] args) {
            // Если пришел метод с аргументами, то проксюем, кэши сбрасываем
            if (!original.equals(target.toString())) {
                cache.replaceAll((Method, Object) -> null);
                original = target.toString();
                return method.invoke(target, args);
            }
            // Если метод без аргументов и закеширован, то возвращаем кэш
            if (cache.get(method) != null) {
                return cache.get(method);
            }
            // если метод без аргументов и не закеширован, то кешируем
            Object res = method.invoke(target, args);
            cache.put(method, res);
            return res;
        }
    }
}
