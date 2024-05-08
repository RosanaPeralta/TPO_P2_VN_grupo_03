package org.example.Ejercicio2_2.model.stack;

import org.example.Ejercicio2_2.model.stack.GenericInterfaces.*;
import org.example.model.IGenericSet;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        IGenericStack<Integer> intStack = new GenericStack<>();
        intStack.add(2);
        intStack.add(4);
        intStack.add(7);

        IGenericStack<String> strStack = new GenericStack<>();
        strStack.add("hola");
        strStack.add("2");
        strStack.add("'S0'");

        IGenericQueue<Integer> intQueue = new GenericQueue<>();
        intQueue.add(2);
        intQueue.add(-5);
        intQueue.add(23);

        IGenericQueue<String> strQueue = new GenericQueue<>();
        strQueue.add("mundo");
        strQueue.add("2");
        strQueue.add("f");

        IGenericQueue<IGenericStack<Integer>> stackQueue = new GenericQueue<>();
        stackQueue.add(intStack);
        // stackQueue.add(strStack); No lo acepta! —Lo que esta bien—

        IGenericSet<Integer> intSet = new GenericDynamicSet<>();
        intSet.add(2);
        // intSet.add("sd"); - Da error, lo que esta bien
        intSet.add(5);
        intSet.choose(); // Pendiente de revisar!

    }
}
