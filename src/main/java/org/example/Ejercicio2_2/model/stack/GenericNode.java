package org.example.Ejercicio2_2.model.stack;

public class GenericNode<E> {
    private E value;
    private GenericNode<E> next;

    public GenericNode() {
    }

    public GenericNode(E value, GenericNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public GenericNode<E> getNext() {
        return next;
    }

    public void setNext(GenericNode<E> next) {
        this.next = next;
    }
}
