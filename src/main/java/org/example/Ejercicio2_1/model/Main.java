package org.example.Ejercicio2_1.model;

import org.example.Ejercicio2_1.model.util.QueueOfStacksUtil;
import org.example.model.definition.Stack;
import org.example.model.dynamic.DynamicStack;

public class Main {
    public static void main(String[] args) {
        QueueOfStacks matriz = new QueueOfStacks();
        Stack columna1 = new DynamicStack();
        Stack columna2 = new DynamicStack();
        Stack columna3 = new DynamicStack();
        columna1.add(1);
        columna1.add(2);
        columna1.add(3);
        columna2.add(4);
        columna2.add(5);
        columna2.add(6);
        columna3.add(7);
        columna3.add(8);
        columna3.add(9);
        matriz.addStack(columna1);
        matriz.addStack(columna2);
        matriz.addStack(columna3);
        QueueOfStacksUtil.traza(matriz);
    }
}
