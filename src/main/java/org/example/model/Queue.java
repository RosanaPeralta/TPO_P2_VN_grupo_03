package org.example.model;

public class Queue implements IQueue {

    private static final int MAX = 10;

    private int[] array;
    private int count;

    public Queue() {
        this.array = new int[MAX];
        this.count = 0;
    }


    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        this.array[count] = a;
        count++;
    }

    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover el primer elemento de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }


    public boolean isEmpty() {
        return count == 0;
    }


    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.array[0];
    }
}
