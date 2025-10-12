package ru.chichkov;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import ru.chichkov.Annotation.Cache;
import ru.chichkov.reflection.Reflections;

import static org.mockito.Mockito.*;

public class CacheTest {

    private ClassForCacheTestImpl interfaceTest;
    private ClassForCacheTest expectedInterface;
    private ClassForCacheTestImpl expectedClass;

    @Before
    public void setUp() {
        interfaceTest = Mockito.spy(new ClassForCacheTestImpl("test")); // перехватывает вызовы методов и проверяет, сколько раз они были вызваны
        expectedInterface = Reflections.cache(interfaceTest, ClassForCacheTest.class);
        expectedClass = Reflections.cache(interfaceTest, ClassForCacheTestImpl.class);
    }

    @Test
    @DisplayName("First time invoke interface method - caching")
    public void firstInvokeInterfaceMethod() {
        Assertions.assertEquals(42, expectedInterface.methodTestForCache());
        Mockito.verify(interfaceTest, times(1)).methodTestForCache();
    }

    @Test
    @DisplayName("Second time invoke interface method - cache hit")
    public void secondInvokeInterfaceMethodCacheHit() {
        expectedInterface.methodTestForCache(); // Первый вызов метода
        reset(interfaceTest); // Сбрасываем счетчик вызовов Mockito

        Assertions.assertEquals(42, expectedInterface.methodTestForCache());
        Mockito.verify(interfaceTest, never()).methodTestForCache(); // Проверяем, что метод не был вызван
    }


    @Test
    @DisplayName("Change state and invoke interface method - cache refresh")
    public void changeStateAndInvokeInterfaceMethodCacheRefresh() {
        expectedInterface.setValue("change"); // Изменяем target.toString()

        Assertions.assertEquals(42, expectedInterface.methodTestForCache()); // Вызов метода после изменения
        Mockito.verify(interfaceTest, times(1)).methodTestForCache(); // Проверяем, что метод был вызван для сброса кэша
    }

    @Test
    @DisplayName("First time invoke class method - caching")
    public void firstInvokeClassMethod() {
        Assertions.assertEquals(42, expectedClass.methodTestForCache());
        Mockito.verify(interfaceTest, times(1)).methodTestForCache();
    }

    @Test
    @DisplayName("Second time invoke class method - cache hit")
    public void secondInvokeClassMethodCacheHit() {
        expectedClass.methodTestForCache();
        reset(interfaceTest);

        Assertions.assertEquals(42, expectedClass.methodTestForCache());
        Mockito.verify(interfaceTest, never()).methodTestForCache();
    }

    @Test
    @DisplayName("Change state and invoke class method - cache refresh")
    public void changeStateAndInvokeClassMethodCacheRefresh() {
        expectedClass.setValue("change");

        Assertions.assertEquals(42, expectedClass.methodTestForCache());
        Mockito.verify(interfaceTest, times(1)).methodTestForCache();
    }

    @Test
    @DisplayName("Cache with specified methods in annotation")
    public void cacheWithSpecifiedMethods() {
        SpecificCacheClassImpl target = Mockito.spy(new SpecificCacheClassImpl());
        SpecificCacheClass proxy = Reflections.cache(target, SpecificCacheClass.class);

        proxy.method1();
        proxy.method1();
        proxy.method2();
        proxy.method2();


        verify(target, times(1)).method1(); // Метод должен быть закэширован
        verify(target, times(2)).method2(); // Метод должен быть закэширован
    }

    @Cache
    interface ClassForCacheTest {
        int methodTestForCache();

        void setValue(String value);
    }

    @Cache
    static class ClassForCacheTestImpl implements ClassForCacheTest {
        private String value;

        public ClassForCacheTestImpl(String value) {
            this.value = value;
        }

        public int methodTestForCache() {
            System.out.println("первый раз или изменен");
            return 42;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Cache("method1")
    interface SpecificCacheClass {
        void method1();
        void method2();
    }

    static class SpecificCacheClassImpl implements SpecificCacheClass {
        @Override
        public void method1() {
            System.out.println("method1");
        }

        @Override
        public void method2() {
            System.out.println("method2");
        }
    }
}