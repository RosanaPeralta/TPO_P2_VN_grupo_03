package org.example.Ejercicio2_5.model.montecarlo;

public class CordenadeNode {

    private Cordenade value;
    private CordenadeNode next;

    public CordenadeNode(Cordenade value, CordenadeNode next) {
        this.value = value;
        this.next = next;
    }

    public Cordenade getValue() {
        return value;
    }

    public void setValue(Cordenade value) {
        this.value = value;
    }

    public CordenadeNode getNext() {
        return next;
    }

    public void setNext(CordenadeNode next) {
        this.next = next;
    }
}
