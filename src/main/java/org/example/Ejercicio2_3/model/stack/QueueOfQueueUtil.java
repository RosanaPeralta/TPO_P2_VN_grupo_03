package org.example.Ejercicio2_3.model.stack;

import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.model.Queue;

public class QueueOfQueueUtil {
    public void concatenate(QueueOfQueue... queueOfQueues){
        QueueOfQueue queueOfQueue = new QueueOfQueue();
        for (int i = 0; i < queueOfQueues.length; i++) {
            QueueOfQueue queueIterated = queueOfQueues[i];
            if(queueIterated.isEmpty()){
                continue;
            }
            while(!queueIterated.isEmpty()){
                Queue currentQueue = queueIterated.getFirst();
                queueOfQueue.addQueue(currentQueue);
                queueIterated.removeQueue();
            }
        }
        System.out.println(queueOfQueue);
    }

    public void flat(QueueOfQueue queueOfQueue){

    }

    public void reverseWithDepth(){

    }
}
