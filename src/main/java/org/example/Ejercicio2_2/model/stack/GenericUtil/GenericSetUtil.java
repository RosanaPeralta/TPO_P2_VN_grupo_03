package org.example.Ejercicio2_2.model.stack.GenericUtil;

import org.example.Ejercicio2_2.model.stack.GenericDynamicSet;
import org.example.model.IGenericSet;

public class GenericSetUtil<E> {

    public GenericDynamicSet<E> copy(IGenericSet<E> original) {
        GenericDynamicSet<E> aux1 = new GenericDynamicSet<>();
        GenericDynamicSet<E> aux2 = new GenericDynamicSet<>();

        while (!original.isEmpty()) {
            E obj = (E) original.choose(); // Obtiene un Object
            aux1.add(obj);
            aux2.add(obj);
            original.remove(obj);
        }
        while (!aux2.isEmpty()) {
            E obj = aux2.choose(); // Obtiene un Object
            original.add(obj);
            aux2.remove(obj);
        }
        return aux1;
    }
}
