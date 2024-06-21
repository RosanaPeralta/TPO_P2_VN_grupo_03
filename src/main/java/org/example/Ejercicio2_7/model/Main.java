package org.example.Ejercicio2_7.model;

import org.example.model.definition.PriorityQueue;
import org.example.model.dynamic.DynamicPriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue cola = new DynamicPriorityQueue();
        cola.add(1,1);
        cola.add(2,1);
        cola.add(3,1);
        cola.add(4,2);
        cola.add(5,2);
        cola.add(6,2);
        cola.add(7,3);
        cola.add(8,3);
        cola.add(9,3);

        System.out.println(PriorityQueueUtil.print(cola));
        PriorityQueue colaEditada = PriorityQueueUtil.edit(cola,6,2,2);
        System.out.println(PriorityQueueUtil.print(colaEditada));

    }

}
