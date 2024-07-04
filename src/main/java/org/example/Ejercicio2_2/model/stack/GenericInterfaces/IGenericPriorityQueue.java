package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericPriorityQueue<V, P> {
    void add(V item, P priority);

    void remove();

    boolean isEmpty();

    V getFirst();

    P getPriority();

    int size();
}
