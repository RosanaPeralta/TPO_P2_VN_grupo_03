package org.example.Ejercicio2_2.model.stack;

import org.example.model.IGenericSet;

import java.util.Random;

public class GenericDynamicSet<E> implements IGenericSet<E> {
    private GenericNode<E> first;
    private int count = 0;


    public E choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede obtener elemento de un conjunto vacio");
        }
        Random random = new Random();
        int index = random.nextInt(count);

        int i = 0;
        GenericNode<E> current = this.first;
        while (current.getNext() != null) {
            if (i == index) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public void add(E item) {
        if (this.isEmpty()) {
            this.first = new GenericNode<>(item, null);
            count++;
            return;
        }
        GenericNode<E> current = this.first;
        while (current.getNext() != null) {
            if (current.getValue().equals(item)) {
                return;
            }
            current = current.getNext();
        }
        current.setNext((GenericNode<E>) new GenericNode<>(item, null));
        count++;
    }

    @Override
    public void remove(E item) {
        if (this.isEmpty()) { // Caso Set vacío
            throw new RuntimeException("No se pueden quitar elementos de un conjunto vacío");
        }
        if (this.first.getNext() == null) { // Caso un único elemento
            if (this.first.getValue().equals(item)) {
                this.first = null;
                count--;
            }
            return;
        }

        GenericNode<E> backup = this.first;
        GenericNode<E> current = this.first.getNext();

        if (this.first == item) {
            this.first = this.first.getNext();
            return;
        }

        while (current.getNext() != null) { // Caso es un elemento en el medio
            if (current.getValue().equals(item)) {
                backup.setNext(current.getNext());
                count--;
                return;
            }
            current = current.getNext();
            backup = backup.getNext();
        }

        if (current.getValue() == item) { // Caso es el último elemento
            backup.setNext(null);
            count--;
        }

    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int size() {
        return count;
    }
}
