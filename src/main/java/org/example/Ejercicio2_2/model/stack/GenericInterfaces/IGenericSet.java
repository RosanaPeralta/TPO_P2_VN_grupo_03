package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericSet<E> {

    E choose();

    void add(E item);

    void remove(E item);

    boolean isEmpty();

    int size();
}