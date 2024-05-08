package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericPriorityQueue<E> {
    void add(E item, int priority);
    void remove();
    boolean isEmpty();
    E getFirst();
    int getPriority();
    int size();
}
