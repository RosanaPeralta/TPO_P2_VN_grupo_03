package org.example.Ejercicio2_3.model;

import org.example.model.definition.Queue;

public class QueueOfQueue implements IQueueOfQueue{
    private static final int MAX = 10;
    private int count;
    private final Queue[] arrayQueue;
    public QueueOfQueue() {
        this.arrayQueue = new Queue[MAX];
        this.count = 0;
    }
    public void addQueue(Queue queue) {
        if(count == MAX) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        this.arrayQueue[count] = queue;
        count++;
    }

    public void removeQueue() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover la primer cola de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.arrayQueue[i] = this.arrayQueue[i + 1];
        }
        this.count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Queue getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primer pila de una cola vacía");
        }
        return this.arrayQueue[0];
    }
}
