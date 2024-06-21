package org.example.model.dynamic;


import org.example.model.definition.PriorityQueue;
import org.example.model.dynamic.nodes.PriorityNode;

import java.util.Objects;

public class DynamicPriorityQueue implements PriorityQueue {

    private PriorityNode first;


    @Override
    public void add(int a, int priority) {
        if (this.isEmpty() || this.first.getPriority() > priority) {
            this.first = new PriorityNode(a, priority, this.first);
            return;
        }

        PriorityNode last = this.getLast();
        if (last.getPriority() <= priority) {
            last.setNext(new PriorityNode(a, priority, null));
            return;
        }

        PriorityNode candidate = this.first;
        PriorityNode current = this.first.getNext();
        while (current != null) {
            if (current.getPriority() > priority) {
                candidate.setNext(new PriorityNode(a, priority, current));
                break;
            }
            candidate = current;
            current = current.getNext();
        }
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }

        this.first = this.first.getNext();
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public int getPriority() {
        return this.first.getPriority();
    }


    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    private PriorityNode getLast() {
        PriorityNode current = this.first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }
}
