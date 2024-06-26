package org.example.Ejercicio2_3.model.util;

import org.example.model.definition.Queue;

public class StackOfQueue implements IStackOfQueue {

    private Queue[] array;
    private int count;

    public StackOfQueue() {
        array = new Queue[10000];
        count = 0;
    }

    @Override
    public void add(Queue queue) {
        if (this.count >= 10000) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = queue;

    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Queue getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }
}
