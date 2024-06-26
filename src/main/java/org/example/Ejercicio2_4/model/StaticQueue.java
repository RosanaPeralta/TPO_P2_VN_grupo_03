package org.example.Ejercicio2_4.model;

import org.example.model.definition.Queue;

public class StaticQueue implements Queue {
    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public StaticQueue(int... elements) {
        if (elements.length > MAX) {
            throw new RuntimeException("La cantidad de elementos excede el máximo permitido");
        }
        this.array = new int[MAX];
        this.count = 0;
        for (int element : elements) {
            this.add(element);
        }
    }

    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return array[0];
    }
}
