package org.example.Ejercicio2_6.model;

public interface MultiSet {

    /**
     * Postcondicion: Agrega un valor al conjunto, incrementando su cantidad.
     *
     * @param a valor a agregar.
     */
    void add(int a);

    /**
     * Postcondicion: Quita una ocurrencia del elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(int a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return elemento arbitrario del conjunto.
     */
    int choose();

    /**
     * @param a valor cuyo conteo se desea saber.
     * @return cantidad de ocurrencias del valor indicado
     */
    int count(int a);

}
