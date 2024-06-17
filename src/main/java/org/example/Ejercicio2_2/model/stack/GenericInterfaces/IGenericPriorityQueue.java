package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericPriorityQueue<E> {
    void add(E item, E priority);
    void remove();
    boolean isEmpty();
    E getFirst();
    E getPriority();
    int size();
}
