package org.example;

import org.example.Ejercicio2_1.model.IQueueOfStacks;
import org.example.Ejercicio2_1.model.QueueOfStacks;

import org.example.Ejercicio2_1.model.stack.QueueOfStacksUtil;
import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.Ejercicio2_3.model.stack.QueueOfQueueUtil;
import org.example.model.DynamicSet;
import org.example.model.Queue;
import org.example.model.Stack;

import static org.example.Ejercicio2_1.model.stack.QueueOfStacksUtil.sumaMatricial;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        Stack stack4 = new Stack();

        stack1.add(8);
        stack1.add(4);

        stack2.add(2);
        stack2.add(3);

        //4  8 --> 4  8
        //3  2 --> 2  3
        QueueOfStacks queueOfStacks = new QueueOfStacks();
        QueueOfStacksUtil queueOfStacks1 = new QueueOfStacksUtil();

        queueOfStacks.addStack(stack1);
        queueOfStacks.addStack(stack2);
        IQueueOfStacks copyQueue = new QueueOfStacks(); // Crear una copia de la cola para no alterar la original

        //queueOfStacks12.traza(queueOfStacks);
        queueOfStacks1.traspuesta(queueOfStacks);

        QueueOfStacks matriz1 = new QueueOfStacks();
        QueueOfStacks matriz2 = new QueueOfStacks();

        matriz1.addStack(stack1);
        matriz1.addStack(stack2);
        matriz2.addStack(stack3);
        matriz2.addStack(stack4);


        QueueOfStacks suma = sumaMatricial(matriz1, matriz2);
        System.out.println(suma);

        //Ejercicio 2.3.1
        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        Queue queue3 = new Queue();

        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        queue3.add(4);
        queue3.add(12);
        queue3.add(6);

        QueueOfQueue queueOfQueue1= new QueueOfQueue();
        QueueOfQueue queueOfQueue2 = new QueueOfQueue();
        QueueOfQueue queueOfQueue3 = new QueueOfQueue();

        QueueOfQueueUtil queueOfQueueUtil = new QueueOfQueueUtil();
        queueOfQueue1.addQueue(queue1);
        queueOfQueue1.addQueue(queue2);
        queueOfQueue2.addQueue(queue1);
        queueOfQueue2.addQueue(queue2);
        queueOfQueue3.addQueue(queue3);

        queueOfQueueUtil.concatenate(queueOfQueue1, queueOfQueue2, queueOfQueue3);

        DynamicSet conjunto = new DynamicSet();
        conjunto.add(2);
        conjunto.add(3);
        conjunto.add(8);
        System.out.println(conjunto.choose());

    }
}