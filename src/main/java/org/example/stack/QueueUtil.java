package org.example.stack;

import org.example.model.PriorityQueue;
import org.example.model.Queue;

public class QueueUtil {

    public static void sort(Queue queue) {
        PriorityQueue priorityQueue = new PriorityQueue();
        while(!queue.isEmpty()) {
            priorityQueue.add(-1, queue.getFirst());
            queue.remove();
        }
        while(!priorityQueue.isEmpty()) {
            queue.add(priorityQueue.getPriority());
            priorityQueue.remove();
        }
    }

    public static void merge(Queue queue) {
        int size = size(queue);
        if (queue.isEmpty() || size == 1) {
            return;
        }
        if (size == 2) {
            int first = queue.getFirst();
            queue.remove();
            queue.add(first);
            if (first <= queue.getFirst()) {
                first = queue.getFirst();
                queue.remove();
            }
            return;
        }

        Queue aux = new Queue();
        Queue aux2 = new Queue();

        for(int i = 0; i < size / 2; i++) {
            aux.add(queue.getFirst());
            queue.remove();
        }

        while(!queue.isEmpty()) {
            aux2.add(queue.getFirst());
            queue.remove();
        }

        merge(aux);
        merge(aux2);

        while(!aux.isEmpty() && !aux2.isEmpty()) {
            if(aux.getFirst() > aux2.getFirst()) {
                queue.add(aux2.getFirst());
                aux2.remove();
            } else {
                queue.add(aux.getFirst());
                aux.remove();
            }
        }

        while(!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }

        while(!aux2.isEmpty()) {
            queue.add(aux2.getFirst());
            aux2.remove();
        }
    }

    private static int size(Queue queue) {
        Queue aux = copy(queue);
        int count = 0;
        while (!aux.isEmpty()) {
            aux.remove();
            count++;
        }
        return count;
    }

    private static Queue copy(Queue queue) {
        Queue aux = new Queue();
        Queue aux2 = new Queue();

        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            aux2.add(queue.getFirst());
            queue.remove();
        }

        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }

        return aux2;
    }

}
