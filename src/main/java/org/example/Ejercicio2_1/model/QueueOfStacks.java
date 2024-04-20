package org.example.Ejercicio2_1.model;

import org.example.model.Queue;
import org.example.model.Stack;

public class QueueOfStacks implements IQueueOfStacks {
    private static final int MAX = 10;
    private final Queue queue;
    private int count;
    public QueueOfStacks() {
        this.queue = new Queue();
        this.count = 0;
    }

    public void add(Stack stack) {
        this.queue.addStack(stack);
    }

    public void traza() {
        if(this.queue.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola vacía");
        }

        while(!this.queue.isEmpty()){
            this.queue.remove();
            count++;
        }
        System.out.println(this.count);
    }

    public void traspuesta(Queue queueOfStacks) {

    }

    public void sumaMatricial(Queue queueOfStacks) {

    }
}
