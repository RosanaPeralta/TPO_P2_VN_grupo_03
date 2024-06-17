package org.example.Ejercicio2_1.model;

import org.example.model.definition.Stack;

public class QueueOfStacks implements IQueueOfStacks {
    private static final int MAX = 10;
    private int count;

    private final Stack[] arrayStack;
    public QueueOfStacks() {
        this.arrayStack = new Stack[MAX];
        this.count = 0;
    }

    public void addStack(Stack stack) {
        if(count == MAX) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        this.arrayStack[count] = stack;
        count++;
    }

    public void removeStack() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover la primer pila de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.arrayStack[i] = this.arrayStack[i + 1];
        }
        this.count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public Stack getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primer pila de una cola vacía");
        }
        return this.arrayStack[0];
    }

}
