package org.example.model;

public interface IPriorityQueue {

    /**
     *
     * @param a el numero que quiero acolar
     */
    void add(int a, int priority);

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

    int getPriority();


}

