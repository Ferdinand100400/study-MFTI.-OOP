package ru.chichkov.testAnnatationClasses;

import ru.chichkov.Annotation.Invoke;

public class B {

    @Invoke
    public String m4(A a) {
        return a.m1();
    }

    @Invoke
    public String m5() {
        return A.m1();
    }
    @Invoke
    public void m6() {
        System.out.println(A.m1());
    }
    @Invoke
    public String m7() {
        return "test";
    }
}
