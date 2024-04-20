package org.example;

import org.example.Ejercicio2_1.model.QueueOfStacks;

import org.example.model.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        stack1.add(1);
        stack1.add(4);
        stack1.add(7);

        stack2.add(2);
        stack2.add(5);
        stack3.add(8);


        stack3.add(3);
        stack3.add(6);
        stack3.add(9);


        QueueOfStacks queueOfStacks = new QueueOfStacks();

        queueOfStacks.add(stack1);
        queueOfStacks.add(stack2);
        queueOfStacks.add(stack3);
        queueOfStacks.traza();
    }
}