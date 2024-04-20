package org.example.model;

// Sonarlint
public interface IStack {

    /**
     *
     * @param a el numero que quiero apilar
     */
    void add(int a);

    /**
     * Precondicion: La pila no esta vacia
     */
    void remove();

    boolean isEmpty();

    /**
     *
     * @return
     */
    int getTop();

}
