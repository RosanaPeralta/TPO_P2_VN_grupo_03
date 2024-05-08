package org.example.Ejercicio2_2.model.stack;

import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericStack;

public class GenericStack<E> implements IGenericStack<E> {

    private E[] array;
    private int count;
    private static final int MAX = 10;


    public GenericStack() {
        this.array = (E[]) new Object[MAX];
        this.count = 0;
    }


    public void add(E item) {
        if (count == MAX){
            throw new RuntimeException("No se pueden agregar elementos a una pila llena.");
        }
        array[count] = item;
        count++;
    }

    public void remove() {
        if (count == 0){
            throw new RuntimeException("No se pueden eliminar elementos de una pila vacía.");
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public E getTop() {
        if (count == 0){
            throw new RuntimeException("No se puede traer el primer elemento de una pila vacía");
        }
        return array[count-1];
    }

    public int size() {
        return count;
    }
}
