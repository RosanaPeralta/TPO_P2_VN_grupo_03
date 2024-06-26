package org.example.Ejercicio2_3.model;

import org.example.Ejercicio2_3.model.util.StackOfQueue;
import org.example.model.definition.Queue;
import org.example.model.definition.Stack;
import org.example.model.normal.StaticQueue;
import org.example.model.normal.StaticStack;

import static org.example.Ejercicio2_3.model.util.QueueOfQueueUtil.copy;

public class QueueOfQueue implements IQueueOfQueue {
    private static final int MAX = 10;
    private final Queue[] arrayQueue;
    private int count;

    public QueueOfQueue() {
        this.arrayQueue = new Queue[MAX];
        this.count = 0;
    }

    public void addQueue(Queue queue) {
        if (count == MAX) {
            throw new RuntimeException("Cantidad máxima de elementos alcanzada");
        }
        this.arrayQueue[count] = queue;
        count++;
    }

    public void removeQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede remover la primer cola de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.arrayQueue[i] = this.arrayQueue[i + 1];
        }
        this.count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Queue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primer pila de una cola vacía");
        }
        return this.arrayQueue[0];
    }

    public QueueOfQueue concatenate(QueueOfQueue... queueOfQueues) {
        QueueOfQueue queueOfQueueConcatenated = new QueueOfQueue();
        for (int i = 0; i < queueOfQueues.length; i++) {
            QueueOfQueue queueIterated = copy(queueOfQueues[i]);
            if (queueIterated.isEmpty()) {
                continue;
            }
            while (!queueIterated.isEmpty()) {
                Queue currentQueue = queueIterated.getFirst();
                queueOfQueueConcatenated.addQueue(currentQueue);
                queueIterated.removeQueue();
            }
        }
        return queueOfQueueConcatenated;
    }

    public Queue flat() {
        QueueOfQueue aux = copy(this);
        Queue queueConcatenada = new StaticQueue();

        while (!aux.isEmpty()) {
            Queue queue = aux.getFirst();
            while (!queue.isEmpty()) {
                queueConcatenada.add(queue.getFirst());
                queue.remove();
            }
            aux.removeQueue();
        }
        return queueConcatenada;
    }

    public QueueOfQueue reverseWithDepth() {
        Queue aux;
        Stack stack = new StaticStack();
        StackOfQueue stackQueues = new StackOfQueue();

        while (!this.isEmpty()) {
            aux = this.getFirst();
            while (!aux.isEmpty()) {
                stack.add(aux.getFirst());
                aux.remove();
            }
            while (!stack.isEmpty()) {
                aux.add(stack.getTop());
                stack.remove();
            }
            stackQueues.add(aux);
            this.removeQueue();
        }
        while (!stackQueues.isEmpty()) {
            this.addQueue(stackQueues.getTop());
            stackQueues.remove();
        }
        return this;
    }

}
