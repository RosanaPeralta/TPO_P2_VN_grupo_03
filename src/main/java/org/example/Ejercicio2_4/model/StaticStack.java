package org.example.Ejercicio2_4.model;

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
            throw new RuntimeException("Límite excedido");
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

    public static class Builder {
        private StaticStack stack;

        public Builder() {
            stack = new StaticStack();
        }

        public Builder add(int a) {
            stack.add(a);
            return this;
        }

        public Builder addAll(StaticStack otherStack) {
            for (int i = 0; i < otherStack.count; i++) {
                this.add(otherStack.array[i]);
            }
            return this;
        }

        public StaticStack build() {
            return stack;
        }
    }
}
