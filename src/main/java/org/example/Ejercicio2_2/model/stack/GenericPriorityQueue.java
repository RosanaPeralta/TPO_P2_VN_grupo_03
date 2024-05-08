package org.example.Ejercicio2_2.model.stack;

import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericPriorityQueue;

public class GenericPriorityQueue<E> implements IGenericPriorityQueue<E> {

    private static final int MAX = 10;
    private E[] values;
    private int[] priorities;
    private int count;

    public GenericPriorityQueue(){
        this.values = (E[]) new Object[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(E item, int priority) {
        if (this.count == MAX){
            throw new RuntimeException("No se pueden agregar elementos a una cola llena");
        }

        // Caso en que se agrega el primer elemento, o un elemento al final de la cola
        if(this.count == 0 || this.priorities[count - 1] <= priority) {
            this.values[count] = item;
            this.priorities[count] = priority;
            count++;
            return;
        }

        // Caso en que se agrega un elemento con prioridad mayor a toda la cola
        if(this.priorities[0] > priority) {
            for(int i = count - 1; i >= 0; i--) {
                this.values[i + 1] = this.values[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.values[0] = item;
            this.priorities[0] = priority;
            count++;
            return;
        }

        // Caso General, se agrega un elemento en el medio de la cola
        int index = 0;
        for(int i = 0; i < count; i++) {
            if(this.priorities[i] > priority) {
                index = i;
                break;
            }
        }

        for(int i = count - 1; i >= index; i--) {
            this.values[i + 1] = this.values[i];
            this.priorities[i + 1] = this.priorities[i];
        }

        this.values[index] = item;
        this.priorities[index] = priority;
        count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede remover el primer elemento de una cola vacía");
        }
        for(int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public E getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.values[0];
    }

    @Override
    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.priorities[0];
    }

    @Override
    public int size() {
        return count;
    }
}
