package org.example.model;

import java.util.Objects;
import java.util.Random;

public class DynamicSet implements Set {

    private Node first;
    private int count;

    // O(N + C)
    @Override
    public int choose() {
        // C
        if(this.isEmpty()) { // C
            throw new RuntimeException("No se puede obtener el elemento de un conjunto vacio"); // C
        }
        Random random = new Random();  // C
        int index = random.nextInt(count);  // C

        int i = 0;  // C
        Node current = this.first;  // C

        // O(N + C) ~ N
        while(current != null) {  // N
            if(i == index) {  // C
                return current.getValue();  // C
            }
            i++;  // C
            current = current.getNext();  // C
        }

        return 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) { // C
            this.first = new Node(a, null);
            this.count++;
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
        this.count++;
    }

    @Override
    public void remove(int a) {
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
        Node backup = this.first;
        Node current = this.first.getNext();
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                backup.setNext(current.getNext());
                this.count--;
                return;
            }
            backup = current;
            current = current.getNext();
        }

        if(current.getValue() == a) {
            backup.setNext(current.getNext());
            this.count--;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DynamicSet that)) return false;
        return count == that.count && Objects.equals(first, that.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, count);
    }
}
