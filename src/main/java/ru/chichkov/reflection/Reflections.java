package ru.chichkov.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reflections {

    // Задача 8.1.1
    public static List<Field> fieldCollection(Class<?> cls) {
        List<Field> fieldList = new ArrayList<>();
        while (cls != Object.class) {
            fieldList.addAll(new ArrayList<>(List.of(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return fieldList;
    }

    // Задача 8.1.4
    public static void validate(Object obj, Class<?> classTests) {
        List<Method> methodsTest = List.of(classTests.getMethods());
        for (Method test : methodsTest) {
            if (test.getReturnType().equals(void.class) && test.getParameterCount() == 1) {
                try {
                    if (Modifier.isStatic(test.getModifiers())) test.invoke(null, obj);
                    else {
                        Object o = classTests.getDeclaredConstructor().newInstance();
                        test.invoke(o, obj);
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException("Validation failed in method: "
                            + test.getName() + " - " + e.getCause().getMessage());
                }
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
        private final Map<Method, Object> cache = new HashMap<>();
        private final Map<Method, Object> lastResults = new HashMap<>();

        public CachingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getParameterCount() > 0) {
                throw new IllegalArgumentException("Кэширование поддерживается только для методов без параметров.");
            }
            // Проверяем, был ли метод вызван ранее
            if (cache.containsKey(method)) {
                // Если состояние объекта изменилось, вызываем метод заново
                if (!isObjectChanging(method)) {
                    Object result = method.invoke(target);
                    cache.put(method, result);
                    lastResults.put(method, result);
                    return result;
                }
                // Если состояние объекта не изменилось, возвращаем кэшированное значение
                return cache.get(method);
            } else {
                // Первый вызов метода
                Object result = method.invoke(target);
                cache.put(method, result);
                lastResults.put(method, result);
                return result;
            }
        }

        private boolean isObjectChanging(Method method) {
            try {
                Object currentResult = method.invoke(target);
                return lastResults.get(method).equals(currentResult);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
