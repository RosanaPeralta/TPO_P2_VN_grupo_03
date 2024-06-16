package org.example.util;

import org.example.model.definition.Queue;
import org.example.model.normal.StaticQueue;

public class QueueUtil {

    public static int size(Queue queue) {
        Queue aux = copy(queue);
        int count = 0;
        while (!aux.isEmpty()) {
            aux.remove();
            count++;
        }
        return count;
    }

    public static Queue copy(Queue queue) {
        Queue aux = new StaticQueue();
        Queue aux2 = new StaticQueue();

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
