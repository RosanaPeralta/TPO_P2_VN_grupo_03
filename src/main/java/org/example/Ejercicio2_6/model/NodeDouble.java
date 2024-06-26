package org.example.Ejercicio2_6.model;

public class NodeDouble {

    private int value;
    private NodeDouble next;
    private NodeDouble before;

    public NodeDouble(int value, NodeDouble before, NodeDouble next){
        this.value = value;
        this.before = before;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeDouble getNext() {
        return next;
    }

    public NodeDouble getBefore() {return before;}

    public void setNext(NodeDouble next) {
        this.next = next;
    }

    public void setBefore(NodeDouble before) {this.before = before;}

}
