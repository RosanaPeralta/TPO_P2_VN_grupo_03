package org.example.Ejercicio2_5.model;

import org.example.model.definition.Stack;
import org.example.model.normal.StaticStack;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new StaticStack();
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

        Stack stackOrdered = StackUtil.organiseStack(stack1);
        System.out.println("hola");
    }
}

