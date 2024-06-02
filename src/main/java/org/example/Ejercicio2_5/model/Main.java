package org.example.Ejercicio2_5.model;

import org.example.model.IStack;
import org.example.model.Stack;
import org.example.stack.StackUtil;

public class Main {
    public static void main(String[] args) {
        IStack stack1 = new Stack();
        stack1.add(6);
        stack1.add(4);
        stack1.add(2);
        stack1.add(9);
        stack1.add(6);
        stack1.add(4);
        stack1.add(2);
        stack1.add(3);
        stack1.add(4);
        stack1.add(6);

        IStack stackOrdered = StackUtil.organiseStack(stack1);
        System.out.println("hola");
    }
}

