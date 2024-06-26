package org.example.model.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface Dictionary {

    /**
     * Agrega un valor a una key, y de existir la reemplaza.
     *
     * @param key   -
     * @param value -
     */
    void add(int key, int value);

    /**
     * Para diccionarios simples se puede obviar el value.
     * Si una key que no existe, o un value que no existe esta asociado
     * a una key que si existe, entonces no se hace nada.
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
     * Devuelve el valor asociado a una key.
     * Precondición: No se puede obtener un valor de una key que no existe.
     *
     * @param key -
     * @return value asociado al key
     */
    int get(int key);

}
