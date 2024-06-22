package org.example.Ejercicio2_5.model.montecarlo;

public interface CordenadeSet {
    void add(Cordenade a);

    void remove(Cordenade a);

    boolean isEmpty();

    Cordenade choose();
}
