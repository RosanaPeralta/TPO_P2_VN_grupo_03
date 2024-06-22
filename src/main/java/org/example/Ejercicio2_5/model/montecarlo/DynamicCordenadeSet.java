package org.example.Ejercicio2_5.model.montecarlo;

import org.example.model.dynamic.nodes.Node;

import java.util.Random;

public class DynamicCordenadeSet implements CordenadeSet{
    private CordenadeNode first;
    private int count;

    @Override
    public void add(Cordenade a) {
        CordenadeNode current = this.first;
        while(current != null && current.getValue() != a) {
            current = current.getNext();
        }
        if(current == null) {
            this.first = new CordenadeNode(a, this.first);
            this.count++;
        }
    }

    @Override
    public void remove(Cordenade a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if(this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        CordenadeNode backup = this.first;
        CordenadeNode current = this.first.getNext();
        while(current != null && current.getValue() != a) {
            backup = current;
            current = current.getNext();
        }

        if(current != null) {
            backup.setNext(current.getNext());
            this.count--;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Cordenade choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        int index = new Random().nextInt(count);
        CordenadeNode current = this.first;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
}
