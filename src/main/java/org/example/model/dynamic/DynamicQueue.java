package org.example.model.dynamic;

import org.example.model.definition.Queue;
import org.example.model.dynamic.nodes.Node;

import java.util.Objects;

public class DynamicQueue implements Queue {

    private Node first;


    @Override
    public void add(int a) {
        this.first = new Node(a, this.first);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }

        if(this.first.getNext() == null) {
            this.first = null;
            return;
        }

        Node candidate = this.first;
        Node current = this.first.getNext();
        while(current.getNext() != null) {
            candidate = current;
            current = current.getNext();
        }
        candidate.setNext(null);
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.getLast().getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    private Node getLast() {
        Node current = this.first;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }
}
