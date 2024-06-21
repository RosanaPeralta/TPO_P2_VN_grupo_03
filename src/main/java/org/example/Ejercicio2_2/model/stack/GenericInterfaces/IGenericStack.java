package org.example.Ejercicio2_2.model.stack.GenericInterfaces;

public interface IGenericStack<E> {

    void add(E item);

    void remove();

    boolean isEmpty();

    E getTop();

    int size();
}
