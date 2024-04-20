package org.example.Ejercicio2_1.model;

import org.example.model.Queue;
import org.example.model.Stack;


public interface IQueueOfStacks {
    /**
     *
     * @param queueOfStacks la cola de pilas que quiero calcular la traza
     */
    void add(Stack stack);
    /**
     *
     * Calcula la longitud de la cola
     */
    void traza();

    /**
     *
     * @param queueOfStacks la cola de pilas que quiero invertir
     */
    void traspuesta(Queue queueOfStacks);
    /**
     *
     * @param queueOfStacks la cola de pilas que quiero sumar matricialmente
     */
    void sumaMatricial(Queue queueOfStacks);

}
