package org.example.Ejercicio2_2.model.stack;

import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericQueue;
import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericSet;
import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericStack;
import org.example.Ejercicio2_2.model.stack.GenericUtil.GenericSetUtil;
import org.example.Ejercicio2_2.model.stack.GenericUtil.GenericStackUtil;

public class Main {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.add(2);
        intStack.add(4);
        intStack.add(7);

        GenericStack<String> strStack = new GenericStack<>();
        strStack.add("hola");
        strStack.add("2");
        strStack.add("'S0'");

        GenericStackUtil genericStackUtils = new GenericStackUtil();
        GenericStack<String> invertido = genericStackUtils.invert(strStack);

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
        intSet.add(6);
        intSet.add(1);
        Object elegido = intSet.choose(); // Pendiente de revisar!
        GenericSetUtil setutis = new GenericSetUtil();
        GenericDynamicSet<Integer> copia = setutis.copy(intSet);

        System.out.println(elegido);
    }
}
