package org.example.Ejercicio2_6.model;

import org.example.model.definition.Stack;

import java.util.List;

import static org.example.util.StackUtil.printStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Punto 2.6.1");
        Stack stack = new DynamicStackWithLimit(4);
        stack.add(7);
        stack.add(5);
        stack.add(4);
        stack.add(1);
        printStack(stack);

        System.out.println("Punto 2.6.4");

        StaticMultiSet multiSet = new StaticMultiSet();

        // añado elementos
        multiSet.add(8);
        multiSet.add(8);
        multiSet.add(16);
        multiSet.add(20);
        multiSet.add(20);
        multiSet.add(20);

        System.out.println("Cantidad de veces del elemento 8: " + multiSet.count(8));   // Debería mostrar 2
        System.out.println("Cantidad de veces del elemento 16: " + multiSet.count(16)); // Debería mostrar 1
        System.out.println("Cantidad de veces del elemento 20: " + multiSet.count(20)); // Debería mostrar 3

        // elimino un elemento

        multiSet.remove(8);

        // muestro los conteos despues de eliminar
        System.out.println("Cantidad del elemento 8 después de eliminar: " + multiSet.count(8));

        // Elijo un elemento aleatorio
        int chosenElement = multiSet.choose();
        System.out.println("Elemento elegido al azar: " + chosenElement);

        // Eliminando todas las ocurrencias de 20
        multiSet.remove(20);
        multiSet.remove(20);
        multiSet.remove(20);

        // Verifico las veces después de múltiples eliminaciones
        System.out.println("Cantidad del elemento 20 después de eliminar tres veces: " + multiSet.count(20)); // Debería mostrar 0

        System.out.println("------------------------------------");

        System.out.println("Punto 2.6.5");

        RandomMultipleDictionary randomDictionary = new RandomMultipleDictionary();

        // añado elementos
        randomDictionary.add(1, 10);
        randomDictionary.add(1, 20);
        randomDictionary.add(1, 30);
        randomDictionary.add(8, 40);
        randomDictionary.add(8, 50);

        // Obtengo elementos aleatorios
        List<Integer> values1 = randomDictionary.get(1);
        System.out.println("Valor aleatorio para la clave 1: " + values1.get(0));

        values1 = randomDictionary.get(1);
        System.out.println("Valor aleatorio para la clave 1: " + values1.get(0));

        List<Integer> values2 = randomDictionary.get(8);
        System.out.println("Valor aleatorio para la clave 8: " + values2.get(0));

        values2 = randomDictionary.get(8);
        System.out.println("Valor aleatorio para la clave 8: " + values2.get(0));

        // Elimino elementos
        randomDictionary.remove(1, 10);
        randomDictionary.remove(8, 40);

        // Obteniendo elementos aleatorios después de eliminación
        values1 = randomDictionary.get(1);
        System.out.println("Valor aleatorio para la clave 1 después de eliminar 10: " + values1.get(0));

        values2 = randomDictionary.get(8);
        System.out.println("Valor aleatorio para la clave 8 después de eliminar 40: " + values2.get(0));
    }

}
