package org.example.Ejercicio2_6.model;

import org.example.model.definition.Set;

import java.util.List;

public interface IRandomMultipleDictionary {

    /**
     * Agrega un valor a una key, y de existir no hace nada.
     *
     * @param key   -
     * @param value -
     */
    void add(int key, int value);

    /**
     * Si una key que no existe, o un value que no existe esta asociado
     * a una key que si existe, entonces no se hace nada.
     * En el caso de que la key conserve valores asociados, seguira presente.
     * Si la key se queda sin valores asociados, entonces se elimina.
     *
     * @param key   -
     * @param value -
     */
    void remove(int key, int value);

    /**
     * @return conjunto con todas las claves del diccionario
     */
    Set getKeys();

    /**
     * Devuelve los valores asociados a una key.
     * Precondición: No se puede obtener un valor de una key que no existe.
     *
     * @param key -
     * @return values asociados al key
     */
    Integer get(int key);

}
