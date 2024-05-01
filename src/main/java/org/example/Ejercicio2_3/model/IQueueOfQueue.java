package org.example.Ejercicio2_3.model;

import org.example.model.Queue;

public interface IQueueOfQueue {
    /**
     *
     * @param queueOfQueue la cola de colas.
     */
    void addQueue(Queue queueOfQueue);
    /**
     *
     * Calcula la longitud de la cola
     */
    void removeQueue();

    /**
     *
     * La cola de colas que chequear si está vacia.
     */
    boolean isEmpty();
    /**
     *
     * La cola de pilas que quiero sumar matricialmente
     */
    Queue getFirst();
}
