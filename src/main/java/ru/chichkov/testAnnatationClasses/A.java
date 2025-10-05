package ru.chichkov.testAnnatationClasses;

import ru.chichkov.Annotation.Default;
import ru.chichkov.Annotation.Invoke;

@Default(A.class)
public class A {
    String s;
    int x;
    A a;
    Object obj;
    @Invoke
    public static String m1() {
        return "text";
    }
    public String m2() {
        return "place";
    }
    @Invoke
    public Integer m3() {
        return 42;
    }

    public String toString() {
        return "A{ s=" + s + ", x=" + x + ", a=" + a + ", obj=" + obj + "}";
    }
}
