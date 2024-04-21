package org.example.Ejercicio2_1.model.stack;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.model.Queue;

public class QueueOfStacksUtil {

    public void traza(QueueOfStacks queueOfStacks) {
        QueueOfStacks aux1 = new QueueOfStacks();
        QueueOfStacks aux2 = new QueueOfStacks();
        int count = 0;

        if(queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola vacía");
        }

        while(!queueOfStacks.isEmpty()){
            aux1.addStack(queueOfStacks.getFirst());
            aux2.addStack(queueOfStacks.getFirst());
            queueOfStacks.removeStack();
            count++;
        }
        while (!aux1.isEmpty()) {
            queueOfStacks.addStack(aux1.getFirst());
            aux1.removeStack();
        }
        System.out.println(count);

    }

    public void traspuesta(QueueOfStacks queueOfStacks) {

    }

    public void sumaMatricial(Queue queueOfStacks) {

    }
}
