package org.example.model.normal;

import org.example.model.definition.Stack;

public class StaticStack implements Stack {
    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public void add(int a) {
        if (this.count >= MAX) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = a;
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }

    public boolean isEmpty() {
        return this.count == 0;
    }
}
