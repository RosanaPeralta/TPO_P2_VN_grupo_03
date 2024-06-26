package org.example.Ejercicio2_6.model;

import org.example.model.definition.Queue;

public class DynamicCyclicQueue implements Queue {

    private NodeDouble first;

    @Override
    public void add(int a) {
        if (this.isEmpty()) {
            this.first = new NodeDouble(a, null, null);
            this.first.setNext(this.first);
            this.first.setBefore(this.first);
            return;
        }
        NodeDouble nuevo = new NodeDouble(a, this.first.getBefore(), this.first);
        this.first.getBefore().setNext(nuevo);
        this.first.setBefore(nuevo);
        this.first = nuevo;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        NodeDouble nodo = this.first.getBefore();
        nodo.getBefore().setNext(nodo.getNext());
        nodo.getNext().setBefore(nodo.getBefore());
        nodo.setNext(null);
        nodo.setBefore(null);
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        return this.first.getBefore().getValue();
    }
}
