package org.example.model.dynamic.nodes;

public class KeyNode {

    private int key;
    private KeyNode next;
    private Node values;

    public KeyNode() {

    }

    public KeyNode(int key, KeyNode next, Node values) {
        this.key = key;
        this.next = next;
        this.values = values;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }

    public Node getValues() {
        return values;
    }

    public void setValues(Node values) {
        this.values = values;
    }
}
