package org.example.model;

import java.util.Random;

public class DynamicSet implements Set {

    private Node first;
    private int count;

    @Override
    public int choose() {
        if(this.isEmpty()) { // C
            throw new RuntimeException("No se puede obtener el elemento de un conjunto vacio"); // C
        }
        Random random = new Random();
        int index = random.nextInt(count);

        int i = 0;
        Node current = this.first;
        while(current.getNext() != null) {
            if(i == index) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }

        return 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) { // C
            this.first = new Node(a, null);
            return;
        }
        Node current = this.first;
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }
        current.setNext(new Node(a, null));
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == a) {
                this.first = null;
            }
            return;
        }

        Node backup = this.first;
        Node current = this.first.getNext();
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                backup.setNext(current.getNext());
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == a) {
            backup.setNext(current.getNext());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
