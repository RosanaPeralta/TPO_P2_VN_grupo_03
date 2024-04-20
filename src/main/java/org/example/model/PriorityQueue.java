package org.example.model;

public class PriorityQueue implements IPriorityQueue {

    private static final int MAX = 10000;

    private int[] values;
    private int[] priorities;
    private int count;

    public PriorityQueue() {
        this.values = new int[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    public void add(int a, int priority) {
        if(this.isEmpty() || this.priorities[count - 1] <= priority) {
            this.values[count] = a;
            this.priorities[count] = priority;
            count++;
            return;
        }

        if(this.priorities[0] > priority) {
            for(int i = count - 1; i >= 0; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[0] = a;
            this.priorities[0] = priority;
            count++;
            return;
        }

        int index = 0;
        for(int i = 0; i < count; i++) {
            if(this.priorities[i] > priority) {
                index = i;
                break;
            }
        }

        for(int i = count - 1; i >= index; i--) {
            this.values[i + 1] = this.values[i];
            this.priorities[i + 1] = this.priorities[i];
        }

        this.values[index] = a;
        this.priorities[index] = priority;
        count++;
    }


    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover el primer elemento de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
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
        return this.values[0];
    }

    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad del primer elemento de una cola vacía");
        }
        return this.priorities[0];
    }
}
