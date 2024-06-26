package org.example.Ejercicio2_1.model;

import org.example.Ejercicio2_1.model.util.QueueOfStacksUtil;
import org.example.Ejercicio2_4.model.StaticStack;
import org.example.model.definition.Stack;

import static org.example.Ejercicio2_1.model.util.QueueOfStacksUtil.print;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new StaticStack();
        Stack stack2 = new StaticStack();
        stack1.add(8);
        stack1.add(7);
        stack2.add(11);
        stack2.add(3);

        QueueOfStacks queueOfStacks = new QueueOfStacks();
        queueOfStacks.add(stack1);
        queueOfStacks.add(stack2);
        QueueOfStacksUtil.print(queueOfStacks);
        int traza = QueueOfStacksUtil.traza(queueOfStacks);
        System.out.println("Traza:");
        System.out.println(traza);
        QueueOfStacks traspuesta = QueueOfStacksUtil.traspuesta(queueOfStacks);
        System.out.println("Traspuesta:");
        print(traspuesta);
        QueueOfStacks sumaMatricialResult = QueueOfStacksUtil.sumaMatricial(queueOfStacks, queueOfStacks);
        System.out.println("Suma Matricial:");
        print(sumaMatricialResult);
    }
}
