package org.example.Ejercicio2_6.model;

import org.example.model.definition.Stack;
import org.example.model.dynamic.nodes.Node;

import java.util.Objects;

public class DynamicStackWithLimit implements Stack {
    private Node first;
    private int capacity;
    private int currentSize;

    public DynamicStackWithLimit(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0");
        }
        this.capacity = capacity;
        this.currentSize = 0;
    }

    @Override
    public void add(int a) {
        if (this.currentSize >= this.capacity) {
            throw new RuntimeException("La pila ha alcanzado su capacidad máxima");
        }
        this.first = new Node(a, this.first);
        this.currentSize++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
        this.currentSize--;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

}
