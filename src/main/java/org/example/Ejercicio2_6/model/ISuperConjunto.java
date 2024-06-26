package org.example.Ejercicio2_6.model;

import org.example.model.normal.StaticSet;

public interface ISuperConjunto {

    void add(int a);

    void remove(int a);

    boolean isEmpty();

    int choose();

    boolean esSubconjunto(StaticSet set);

    StaticSet complemento(StaticSet set);
}
