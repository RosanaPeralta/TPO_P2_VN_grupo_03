package org.example.Ejercicio2_3.model;

import org.example.Ejercicio2_4.model.StaticQueue;
import org.example.model.definition.Queue;

import static org.example.Ejercicio2_3.model.util.QueueOfQueueUtil.printQueueOfQueue;
import static org.example.util.QueueUtil.printQueue;

public class Main {
    public static void main(String[] args) {

        QueueOfQueue queueOfQueue = new QueueOfQueue();
        Queue queue1 = new StaticQueue();
        Queue queue2 = new StaticQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue2.add(5);
        queue2.add(6);
        queue2.add(7);
        queueOfQueue.addQueue(queue1);
        queueOfQueue.addQueue(queue2);
        QueueOfQueue queueOfQueue2 = new QueueOfQueue();
        QueueOfQueue queueOfQueueConcat = new QueueOfQueue();
        Queue queue3 = new StaticQueue();
        Queue queue4 = new StaticQueue();
        queue3.add(10);
        queue3.add(12);
        queue3.add(13);
        queue4.add(15);
        queue4.add(16);
        queue4.add(17);
        queueOfQueue2.addQueue(queue3);
        queueOfQueue2.addQueue(queue4);
        QueueOfQueue concat = queueOfQueueConcat.concatenate(queueOfQueue, queueOfQueue2);
        System.out.println("Concat");
        printQueueOfQueue(concat);
        System.out.println();

        System.out.println("Flat");
        QueueOfQueue queueOfQueue3 = new QueueOfQueue();
        queueOfQueue3.addQueue(queue1);
        queueOfQueue3.addQueue(queue2);
        queueOfQueue3.addQueue(queue3);
        queueOfQueue3.addQueue(queue4);
        Queue flatConcatenada = queueOfQueue3.flat();
        printQueue(flatConcatenada);
        System.out.println();

        System.out.println("Reversed With Depth");
        QueueOfQueue queueOfQueue4 = new QueueOfQueue();
        queueOfQueue4.addQueue(queue3);
        queueOfQueue4.addQueue(queue4);
        QueueOfQueue reversed = queueOfQueue4.reverseWithDepth();
        printQueueOfQueue(reversed);
        System.out.println();
    }
}
