package org.example.model;

public class Stack implements IStack {

    private int[] array;
    private int count;

    public Stack() {
        this.array = new int[10];
    }

    // C
    public void add(int a) {
        if(count == 10) {  // C
            throw new RuntimeException("Muchos elementos");  // C
        }
        array[count] = a;  // C
        count++;  // C
    }

    public void remove() {
        if(count == 0) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getTop() {
        if(count == 0) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return array[count - 1];
    }
}
