package org.example.Ejercicio2_6.model;

import org.example.model.normal.StaticSet;

public interface SuperSet {

    void add(int a);

    void remove(int a);

    boolean isEmpty();

    int choose();

    boolean isSubSet(StaticSet set);

    StaticSet complement(StaticSet set);
}
