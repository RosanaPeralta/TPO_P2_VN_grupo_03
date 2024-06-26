package org.example.Ejercicio2_4.model;

import static org.example.util.QueueUtil.printQueue;
import static org.example.util.SetUtil.printSet;
import static org.example.util.StackUtil.printStack;

public class Main {
    public static void main(String[] args) {
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
