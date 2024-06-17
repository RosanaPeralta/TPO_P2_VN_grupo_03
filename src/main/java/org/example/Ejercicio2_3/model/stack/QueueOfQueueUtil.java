package org.example.Ejercicio2_3.model.stack;

import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.model.definition.Queue;
import org.example.util.QueueUtil;

public class QueueOfQueueUtil {
    public static QueueOfQueue concatenate(QueueOfQueue... queueOfQueues){
        QueueOfQueue queueOfQueueConcatenated = new QueueOfQueue();
        for (int i = 0; i < queueOfQueues.length; i++) {
            QueueOfQueue queueIterated = queueOfQueues[i];
            if(queueIterated.isEmpty()){
                continue;
            }
            while(!queueIterated.isEmpty()){
                Queue currentQueue = queueIterated.getFirst();
                queueOfQueueConcatenated.addQueue(currentQueue);
                queueIterated.removeQueue();
            }
        }
        return queueOfQueueConcatenated;
    }

    public void flat(QueueOfQueue queueOfQueue){

    }

    public void reverseWithDepth(){

    }
    public static QueueOfQueue copy(QueueOfQueue queueOfStacks){
        QueueOfQueue aux= new QueueOfQueue();
        QueueOfQueue aux2= new QueueOfQueue();

        while(!queueOfStacks.isEmpty()){
            aux.addQueue(QueueUtil.copy(queueOfStacks.getFirst()));
            aux2.addQueue(QueueUtil.copy(queueOfStacks.getFirst()));
            queueOfStacks.removeQueue();
        }
        while(!aux.isEmpty()){
            queueOfStacks.addQueue(aux.getFirst());
            aux.removeQueue();
        }
        return aux2;
    }
    public static void print(QueueOfQueue queueOfQueue){
        QueueOfQueue aux= copy(queueOfQueue);
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
