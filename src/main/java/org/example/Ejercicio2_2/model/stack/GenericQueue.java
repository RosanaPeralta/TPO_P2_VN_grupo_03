package org.example.Ejercicio2_2.model.stack;
import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericQueue;

public class GenericQueue <E> implements IGenericQueue<E> {

    private static final int MAX = 10;
    private E[] array;
    private int count;

    public GenericQueue(){
        this.array = (E[]) new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(E item) {
        if (count == MAX){
            throw new RuntimeException("No se pueden agregar elementos a una cola llena");
        }
        array[count] = item;
        count++;
    }

    @Override
    public void remove() {
        if (count == 0){
            throw new RuntimeException("No se pueden quitar elementos de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E getFirst() {
        if (count == 0){
            throw new RuntimeException("No se puede traer el primer elemento de una cola vacía");
        }
        return this.array[0];
    }

    @Override
    public int size() {
        return count;
    }
}
