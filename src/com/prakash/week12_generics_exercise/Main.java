package com.prakash.week12_generics_exercise;

class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private E[] elements;
    private int index = -1;
    private int size;
    private int location = -1;
    private E returnElement;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element) throws QueueFullException {
        if ((index == size - 1 && location == 0) || (location == index + 1)) {
            throw new QueueFullException();
        }
        if (index == size - 1 && location != 0)
            index = -1;
        index++;
        elements[index] = element;
        if (location == -1)
            location = 0;
    }

    E dequeue() throws QueueEmptyException {
        if (location == -1 && index == -1) {
            throw new QueueEmptyException();
        }
        returnElement = elements[location];
        location++;
        if (location - 1 == index) {
            index = -1;
            location = -1;
        }
        if (location == size) {
            location = 0;
        }
        return (returnElement);
    }
}
public class Main {
    public static void main(String[] agrs) {
        Queue<String> strings = new Queue<>(3);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            strings.enqueue("Something");
            // strings.enqueue("Something More");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            // System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}