package org.example.Ejercicio2_3.model.util;

import org.example.model.definition.Queue;

public interface IStackOfQueue {

    void add(Queue queue);

    void remove();

    boolean isEmpty();

    Queue getTop();

}
