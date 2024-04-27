package org.example;

import org.example.Ejercicio2_1.model.QueueOfStacks;

import org.example.Ejercicio2_1.model.stack.QueueOfStacksUtil;
import org.example.model.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        Stack stack4 = new Stack();

        stack1.add(8);
        stack1.add(4);
        stack1.add(7);
        stack1.add(3);


        stack2.add(2);
        stack2.add(3);
        stack2.add(8);
        stack2.add(7);

        stack3.add(3);
        stack3.add(6);
        stack3.add(0);
        stack3.add(1);

        stack4.add(3);
        stack4.add(8);
        stack4.add(2);
        stack4.add(5);


        QueueOfStacks queueOfStacks = new QueueOfStacks();
        QueueOfStacksUtil queueOfStacks12 = new QueueOfStacksUtil();

        queueOfStacks.addStack(stack1);
        queueOfStacks.addStack(stack2);
        queueOfStacks.addStack(stack3);
        queueOfStacks.addStack(stack4);

        queueOfStacks12.traza(queueOfStacks);

    }
}