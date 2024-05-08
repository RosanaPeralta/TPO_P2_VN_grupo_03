package org.example.model;

public interface IGenericSet<E> {

    Object choose();
    void add(E item);
    void remove(E item);
    boolean isEmpty();
    int size();
}