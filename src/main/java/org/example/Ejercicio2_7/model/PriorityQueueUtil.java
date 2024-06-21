package org.example.Ejercicio2_7.model;

import org.example.model.definition.PriorityQueue;
import org.example.model.dynamic.DynamicPriorityQueue;

public class PriorityQueueUtil {

    public static PriorityQueue copy(PriorityQueue queue) {
        PriorityQueue aux1 = new DynamicPriorityQueue();
        PriorityQueue aux2 = new DynamicPriorityQueue();

        while (!queue.isEmpty()) {
            int value = queue.getFirst();
            int priority = queue.getPriority();
            aux1.add(value, priority);
            aux2.add(value, priority);
            queue.remove();
        }
        while (!aux1.isEmpty()) {
            queue.add(aux1.getFirst(), aux1.getPriority());
            aux1.remove();
        }
        return aux2;
    }

    public static String print(PriorityQueue queue) {
        PriorityQueue copia = copy(queue);
        String string = "[";
        while (!copia.isEmpty()) {
            if (string == "[") {
                string = string + "(" + copia.getFirst() + ", " + copia.getPriority() + ")";
            } else {
                string = string + ", (" + copia.getFirst() + ", " + copia.getPriority() + ")";
            }
            copia.remove();
        }
        string = string + "]";
        return string;
    }

    public static PriorityQueue edit(PriorityQueue cola, int value, int oldPriority, int newPriority) {
        PriorityQueue copia = copy(cola);
        int diferencia = newPriority - oldPriority;

        if (copia.isEmpty()) {
            throw new RuntimeException("No se puede editar elementos de una cola vacía");
        }

        int index = 0;
        int i = 0;
        boolean flag = false;
        while (!copia.isEmpty()) {
            if (copia.getFirst() == value && copia.getPriority() == oldPriority && !flag) {
                index = i;
                flag = true;
            }
            copia.remove();
            i++;
        }

        if (!flag) {
            throw new RuntimeException("El par (valor, prioridad) no se encuentra en la cola");
        }

        if (diferencia == 0) {
            return PriorityQueueUtil.copy(cola);
        }
        PriorityQueue colaEditada = new DynamicPriorityQueue();
        copia = copy(cola);
        i = 0;
        while (!copia.isEmpty()) {
            int valor = copia.getFirst();
            int prioridad = copia.getPriority();
            if (diferencia > 0 && i >= index) {
                prioridad = prioridad + diferencia;
            }
            if (diferencia < 0 && i <= index) {
                prioridad = prioridad + diferencia;
            }
            colaEditada.add(valor, prioridad);
            copia.remove();
            i++;
        }
        return colaEditada;
    }
}
