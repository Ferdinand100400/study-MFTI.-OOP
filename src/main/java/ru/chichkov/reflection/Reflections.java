package ru.chichkov.reflection;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import ru.chichkov.Annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.security.cert.CertPathValidatorException;
import java.util.*;

@Default(Reflections.class)
@ToString
public class Reflections {
    // Для задачи 8.3.2
    private static final Map<Class<?>, Object> defaultValues = new HashMap<>();

    static {
        defaultValues.put(int.class, 42);
        defaultValues.put(Integer.class, 42);
        defaultValues.put(double.class, 4.2);
        defaultValues.put(Double.class, 4.2);
        defaultValues.put(String.class, "hello");
        defaultValues.put(boolean.class, false);
        defaultValues.put(Boolean.class, false);
        defaultValues.put(char.class, '5');
        defaultValues.put(Character.class, '5');

    }

    // Задача 8.1.1
    public static List<Field> fieldCollection(Class<?> cls) {
        List<Field> fieldList = new ArrayList<>();
        while (cls != Object.class) {
            fieldList.addAll(List.of(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return fieldList;
    }

    // Задача 8.3.5
    public static void validate(Object obj) {
        Class<?> cls = obj.getClass();
        Validate validateAnnotation = cls.getAnnotation(Validate.class);
        if (validateAnnotation == null) {
            try {
                findAliasAnnotation(obj);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Ошибка при обработке аннотации-псевдонима: " + e.getMessage());
            }
            return;
        }
        // Если есть @Validate
        Class<?>[] classesTest = validateAnnotation.value();
        validateWithClasses(obj, classesTest);
    }

    // Поиск псевдонимной аннотации
    private static void findAliasAnnotation(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        for (Annotation annotation : cls.getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(AValidate.class)) {
                Method valueMethod = annotation.annotationType().getMethod("value");
                Class<?>[] classesTests = (Class<?>[]) valueMethod.invoke(annotation);
                validateWithClasses(obj, classesTests);
            }
        }
    }

    // Задача 8.1.4
    // Валидация с полученными классами
    public static void validateWithClasses(Object obj, Class<?>[] classesTests) {
        for (Class<?> classTests : classesTests) {
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
                        throw new IllegalArgumentException("Валидация провалена в методе: "
                                + test.getName() + " - " + e.getCause().getMessage());
                    throw new RuntimeException();
                } catch (Exception e2) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    // Задача 8.1.6
    // Задача 8.3.6
    @SuppressWarnings("unchecked")
    public static <T> T cache(T obj, Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Cache.class)) return obj;
        if (clazz.isInterface()) {
            return (T) Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    clazz.getInterfaces(),
                    new CachingInvocationHandler(obj, clazz.getAnnotation(Cache.class))
            );
        }
        return (T) Enhancer.create(clazz, (Callback) new CachingInvocationHandler(obj, clazz.getAnnotation(Cache.class)));
    }

    private static class CachingInvocationHandler implements InvocationHandler {
        private final Object target;
        private String original;
        private final Map<Method, Object> cache = new HashMap<>();

        public CachingInvocationHandler(Object target, Cache cacheAnnotation) {
            this.target = target;
            for (Method method : target.getClass().getMethods()) {
                if (cacheAnnotation.value().length == 0) {
                    if (method.getParameterCount() == 0)
                        cache.put(method, null);
                } else {
                    if (Arrays.asList(cacheAnnotation.value()).contains(method.getName())) {
                        if (method.getParameterCount() == 0) {
                            cache.put(method, null);
                        }
                    }
                }
            }
            original = target.toString();
        }

        @Override
        @SneakyThrows
        @Invoke
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

    // Задача 8.3.1
    private static Map<String, Object> collect(Class<?> cls) throws
            InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Map<String, Object> result = new HashMap<>();
        List<Method> methods = List.of(cls.getDeclaredMethods());
        Object o = cls.getDeclaredConstructor().newInstance();
        for (Method method : methods) {
            if (method.getParameterCount() == 0 && !method.getReturnType().equals(void.class) && method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                result.put(method.getName(), method.invoke(o));
            }
        }
        return result;
    }

    public static Map<String, Object> collect(Class<?>... classes) {
        Map<String, Object> result = new HashMap<>();
        for (Class<?> cls : classes) {
            try {
                result.putAll(collect(cls));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    // Задача 8.3.2
    public static void reset(Object... objects) {
        for (Object obj : objects) {
            List<Field> fields = new ArrayList<>(fieldCollection(obj.getClass()));
            for (Field field : fields) {
                if (field.isAnnotationPresent(Default.class) || obj.getClass().isAnnotationPresent(Default.class)) {
                    try {
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();
                        Object defaultValue = defaultValues.getOrDefault(fieldType, getDefault(fieldType));
                        field.set(obj, defaultValue);
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Ошибка добавления дефолтного значение в поле: " + field + " класса: " + field.getClass());
                    }
                }
            }
        }
    }

    // К задаче 8.3.2
    public static Object getDefault(Class<?> type) {
        if (type.isPrimitive()) return 0;
        return null;
    }
}
