package ru.chichkov.linkedList;

public class MyLinkedList<T> {

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        Node(T elem) {
            this.elem = elem;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> start;
    private Node<T> end;
    private int size;

    public MyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    // Добавление в конец за O(1)
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (end == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            newNode.prev = end;
            end = newNode;
        }
        size++;
    }

    // Добавление в начало за O(1)
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
        }
        size++;
    }

    // Добавление после указанного узла за O(1)
    public void addAfter(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Неверная ссылка на узел");
        }

        Node<T> newNode = new Node<>(data);
        newNode.next = node.next;
        newNode.prev = node;

        if (node.next != null) {
            node.next.prev = newNode;
        } else {
            end = newNode;
        }

        node.next = newNode;
        size++;
    }

    // Добавление перед указанным узлом за O(1)
    public void addBefore(Node<T> node, T data) {
        if (node == null) {
            throw new IllegalArgumentException("Неверная ссылка на узел");
        }

        Node<T> newNode = new Node<>(data);
        newNode.prev = node.prev;
        newNode.next = node;

        if (node.prev != null) {
            node.prev.next = newNode;
        } else {
            start = newNode;
        }

        node.prev = newNode;
        size++;
    }

    // Получение узла по индексу за O(n/2)
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Такого индекса не существует");
        }

        Node<T> current;
        if (index < size / 2) {
            current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = end;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    // Добавление по индексу за O(n/2 + 1)
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Такого индекса не существует");
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> targetNode = getNode(index);
            addBefore(targetNode, data);
        }
    }

    // Удаление узла за O(1)
    public void remove(Node<T> node) {
        if (node == null) {
            throw new IllegalArgumentException("Неверная ссылка на узел");
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            start = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }

        size--;
    }

    // Удаление по индексу за O(n/2)
    public T remove(int index) {
        Node<T> node = getNode(index);
        remove(node);
        return node.elem;
    }

    // Получение элемента по индексу за O(n/2)
    public T get(int index) {
        return getNode(index).elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = start;

        while (current != null) {
            sb.append(current.elem);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    // Методы получения начального и конечного узлов
    public Node<T> getStart() {
        return start;
    }

    public Node<T> getEnd() {
        return end;
    }
}
