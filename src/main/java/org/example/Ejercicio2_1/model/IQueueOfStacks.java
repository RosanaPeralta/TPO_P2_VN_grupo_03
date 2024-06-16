package org.example.Ejercicio2_1.model;


import org.example.model.definition.Stack;

public interface IQueueOfStacks {
    /**
     *
     * @param queueOfStacks la cola de pilas que quiero calcular la traza
     */
    void addStack(Stack stack);
    /**
     *
     * Calcula la longitud de la cola
     */
    void removeStack();

    /**
     *
     * @param queueOfStacks la cola de pilas que quiero invertir
     */
    boolean isEmpty();
    /**
     *
     * a cola de pilas que quiero sumar matricialmente
     */
    Stack getFirst();

}
