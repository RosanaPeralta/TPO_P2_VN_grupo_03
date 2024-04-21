package org.example.model;

public interface IQueue {
    /**
     *
     * @param a el numero que quiero acolar
     */
    void add(int a);

    /**
     * Precondicion: La cola no esta vacia
     */
    void remove();

    boolean isEmpty();

    /**
     *
     * @return
     */
    int getFirst();

}