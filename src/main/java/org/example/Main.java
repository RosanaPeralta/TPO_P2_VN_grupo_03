package org.example;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.Ejercicio2_1.model.stack.QueueOfStacksUtil;
import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.Ejercicio2_3.model.stack.QueueOfQueueUtil;
import org.example.Ejercicio2_4.model.StaticSet;
import org.example.Ejercicio2_4.model.StaticStack;
import org.example.Ejercicio2_4.model.StaticQueue;
import org.example.model.definition.Queue;
import org.example.model.definition.Stack;
import static org.example.Ejercicio2_1.model.stack.QueueOfStacksUtil.print;
import static org.example.util.QueueUtil.printQueue;
import static org.example.util.SetUtil.printSet;
import static org.example.util.StackUtil.printStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 2.1");
        ejercicio2_1();
        System.out.println("Ejercicio 2.3");
        ejercicio2_3();
        System.out.println("Ejercicio 2.4");
        ejerecicio2_4();
    }

    public static void ejercicio2_1 () {
        //TODO falta la traza
        Stack stack1 = new StaticStack();
        Stack stack2 = new StaticStack();
        stack1.add(8);
        stack1.add(4);
        stack2.add(2);
        stack2.add(3);

        QueueOfStacks queueOfStacks = new QueueOfStacks();
        queueOfStacks.addStack(stack1);
        queueOfStacks.addStack(stack2);
        System.out.println("Original:");
        print(queueOfStacks);
        QueueOfStacks traspuesta = QueueOfStacksUtil.traspuesta(queueOfStacks);
        System.out.println("Traspuesta:");
        print(traspuesta);
        QueueOfStacks sumaMatricialResult = QueueOfStacksUtil.sumaMatricial(queueOfStacks, queueOfStacks);
        System.out.println("Suma Matricial:");
        print(sumaMatricialResult);
    }

    public static void ejercicio2_3 () {
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
        QueueOfQueue concat = QueueOfQueueUtil.concatenate(queueOfQueue, queueOfQueue2);
        QueueOfQueueUtil.print(concat);
    }

    public static void ejerecicio2_4(){
        StaticStack stack = new StaticStack.Builder().add(4).add(5).build();
        System.out.println("Pila creada con Builder:");
        printStack(stack);
        StaticSet set = new StaticSet.Builder().add(1).add(2).build();
        System.out.println("Conjunto creado con Builder:");
        printSet(set);
        StaticQueue queue1 = new StaticQueue(1, 2, 3);
        System.out.println("Cola creada con varios elementos pasados por parámetro:");
        printQueue(queue1);
    }
}