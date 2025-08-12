package ru.chichkov.stack;

import java.util.Arrays;

// Задача 6.1.6
public class Stack<T> {
    private T[] elements;
    private int currentIndex;
    public Stack(int startCapacity) {
        this.elements = (T[]) new Object[startCapacity];
        this.currentIndex = -1;
    }
    public Stack() {
        this(10);
    }

    public void push(T element) {
        this.currentIndex += 1;
        if (this.elements.length == this.currentIndex) this.elements = increaseSize();
        this.elements[this.currentIndex] = element;
    }
    public T pop() {
        T element = peek();
        this.elements[this.currentIndex] = null;
        this.currentIndex -= 1;
        return element;
    }
    public T peek() {
        if (this.currentIndex < 0) throw new IllegalArgumentException("В стеке нет элементов!");
        return this.elements[this.currentIndex];
    }

    private T[] increaseSize() {
        int newCapacity = this.elements.length + 10;
        return Arrays.copyOf(elements, newCapacity);
    }
}
