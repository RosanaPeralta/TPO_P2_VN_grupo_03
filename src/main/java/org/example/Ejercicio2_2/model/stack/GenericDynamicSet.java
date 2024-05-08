package org.example.Ejercicio2_2.model.stack;

import org.example.model.IGenericSet;

import java.util.Random;

public class GenericDynamicSet<E> implements IGenericSet<E> {
    private GenericNode<E> first;
    private int count;

    @Override
    public Object choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede obtener elemento de un conjunto vacio");
        }
        Random random = new Random();
        int index = random.nextInt(count);

        int i = 0;
        GenericNode<E> current = this.first;
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
    public void add(Object item) {
        if(this.isEmpty()) {
            this.first = (GenericNode<E>) new GenericNode<>(item, null);
            return;
        }
        GenericNode<E> current = this.first;
        while(current.getNext() != null) {
            if(current.getValue() == item) {
                return;
            }
            current = current.getNext();
        }
        current.setNext((GenericNode<E>) new GenericNode<>(item, null));
    }

    @Override
    public void remove(Object item) {
        if(this.isEmpty()) {
            throw new RuntimeException("No se pueden quitar elementos de un conjunto vacío");
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == item) {
                this.first = null;
            }
            return;
        }

        GenericNode<E> backup = this.first;
        GenericNode<E> current = this.first.getNext();
        while(current.getNext() != null) {
            if(current.getValue() == item) {
                backup.setNext(current.getNext());
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == item) {
            backup.setNext(current.getNext());
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
