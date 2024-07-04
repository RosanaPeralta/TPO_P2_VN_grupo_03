package org.example.Ejercicio2_3.model.util;

import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.model.definition.Queue;
import org.example.util.QueueUtil;

public class QueueOfQueueUtil {

    public static QueueOfQueue copy(QueueOfQueue queueOfStacks) {
        QueueOfQueue aux = new QueueOfQueue();
        QueueOfQueue aux2 = new QueueOfQueue();

        while (!queueOfStacks.isEmpty()) {
            aux.addQueue(QueueUtil.copy(queueOfStacks.getFirst()));
            aux2.addQueue(QueueUtil.copy(queueOfStacks.getFirst()));
            queueOfStacks.removeQueue();
        }
        while (!aux.isEmpty()) {
            queueOfStacks.addQueue(aux.getFirst());
            aux.removeQueue();
        }
        return aux2;
    }

    public static void printQueueOfQueue(QueueOfQueue queueOfQueue) {
        QueueOfQueue aux = copy(queueOfQueue);
        while (!aux.isEmpty()) {
            Queue queue = aux.getFirst();
            while (!queue.isEmpty()) {
                System.out.print(queue.getFirst() + " ");
                queue.remove();
            }
            aux.removeQueue();
        }
    }
}
