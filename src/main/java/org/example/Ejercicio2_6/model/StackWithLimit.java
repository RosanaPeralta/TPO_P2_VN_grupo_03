package org.example.Ejercicio2_6.model;

import org.example.model.definition.Stack;

public class StackWithLimit implements Stack {

    private final int[] array;
    private int count;
    private int capacity;

    public StackWithLimit(int capacity) {
        this.array = new int[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    public void add(int a) {
        if(this.count >= capacity) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }
}
