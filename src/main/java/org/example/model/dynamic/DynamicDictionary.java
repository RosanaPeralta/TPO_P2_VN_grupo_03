package org.example.model.dynamic;

import org.example.model.definition.Dictionary;
import org.example.model.definition.Set;
import org.example.model.dynamic.nodes.DictionaryNode;

public class DynamicDictionary implements Dictionary {

    private DictionaryNode first;
    private int count;

    @Override
    public void add(int k, int v) {
        DictionaryNode current = this.first;
        while (current != null && current.getKey() != k) {
            current = current.getNext();
        }
        if (current == null) {
            this.first = new DictionaryNode(k, v, this.first);
            this.count++;
        }
    }

    @Override
    public void remove(int k, int v) {
        if (this.first == null) {
            throw new RuntimeException("No existe el par clave-valor");
        }
        if (this.first.getNext() == null) {
            if (this.first.getKey() == k && this.first.getValue() == v) {
                this.first = null;
                this.count--;
                return;
            }
            throw new RuntimeException("Existe la clave pero el valor no coincide");
        }

        DictionaryNode backup = this.first;
        DictionaryNode current = this.first.getNext();
        while (current != null && current.getKey() != k) {
            backup = current;
            current = current.getNext();
        }

        if (current == null) {
            throw new RuntimeException("No existe el par clave-valor");
        }

        if (current.getValue() != v) {
            throw new RuntimeException("No existe el valor para la clave");
        }

        backup.setNext(current.getNext());
        this.count--;
    }

    @Override
    public Set getKeys() {
        if (this.first == null) {
            return new DynamicSet();
        }
        Set keys = new DynamicSet();
        DictionaryNode current = this.first;
        while (current != null) {
            keys.add(current.getKey());
            current = current.getNext();
        }

        return keys;
    }

    @Override
    public int get(int k) {
        if (this.first == null) {
            throw new RuntimeException("No existe un valor asociado a la clave");
        }
        DictionaryNode current = this.first;
        while (current != null) {
            if (current.getKey() == k) {
                return current.getValue();
            }
            current = current.getNext();
        }

        throw new RuntimeException("No existe un valor asociado a la clave");
    }
}
