package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericQueue<E> {

    void add(E item);
    void remove();
    boolean isEmpty();
    E getFirst();
    int size();
}
