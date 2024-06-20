package org.example;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.Ejercicio2_1.model.util.QueueOfStacksUtil;
import org.example.Ejercicio2_3.model.QueueOfQueue;
import org.example.Ejercicio2_4.model.StaticSet;
import org.example.Ejercicio2_4.model.StaticStack;
import org.example.Ejercicio2_4.model.StaticQueue;
import org.example.Ejercicio2_6.model.DynamicStackWithLimit;
import org.example.Ejercicio2_6.model.RandomMultipleDictionary;
import org.example.Ejercicio2_6.model.StaticMultiSet;
import org.example.model.definition.Queue;
import org.example.model.definition.Stack;

import java.util.List;

import static org.example.Ejercicio2_1.model.util.QueueOfStacksUtil.print;
import static org.example.Ejercicio2_3.model.util.QueueOfQueueUtil.printQueueOfQueue;
import static org.example.util.QueueUtil.printQueue;
import static org.example.util.SetUtil.printSet;
import static org.example.util.StackUtil.printStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 2.1");
        ejercicio2_1();
        System.out.println("Ejercicio 2.3");
        ejercicio2_3();
        System.out.println("Ejercicio 2.4");
        ejerecicio2_4();
        System.out.println("Ejercicio 2.6");
        ejercicio2_6();
    }

    public static void ejercicio2_1 () {
        Stack stack1 = new StaticStack();
        Stack stack2 = new StaticStack();
        stack1.add(8);
        stack1.add(4);
        stack2.add(2);
        stack2.add(3);

        QueueOfStacks queueOfStacks = new QueueOfStacks();
        queueOfStacks.addStack(stack1);
        queueOfStacks.addStack(stack2);
        int traza = QueueOfStacksUtil.traza(queueOfStacks);
        System.out.println("Traza:");
        System.out.println(traza);
        QueueOfStacks traspuesta = QueueOfStacksUtil.traspuesta(queueOfStacks);
        System.out.println("Traspuesta:");
        print(traspuesta);
        QueueOfStacks sumaMatricialResult = QueueOfStacksUtil.sumaMatricial(queueOfStacks, queueOfStacks);
        System.out.println("Suma Matricial:");
        print(sumaMatricialResult);
    }

    public static void ejercicio2_3 () {
        QueueOfQueue queueOfQueue = new QueueOfQueue();
        Queue queue1 = new StaticQueue();
        Queue queue2 = new StaticQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue2.add(5);
        queue2.add(6);
        queue2.add(7);
        queueOfQueue.addQueue(queue1);
        queueOfQueue.addQueue(queue2);
        QueueOfQueue queueOfQueue2 = new QueueOfQueue();
        QueueOfQueue queueOfQueueConcat = new QueueOfQueue();
        Queue queue3 = new StaticQueue();
        Queue queue4 = new StaticQueue();
        queue3.add(10);
        queue3.add(12);
        queue3.add(13);
        queue4.add(15);
        queue4.add(16);
        queue4.add(17);
        queueOfQueue2.addQueue(queue3);
        queueOfQueue2.addQueue(queue4);
        QueueOfQueue concat = queueOfQueueConcat.concatenate(queueOfQueue, queueOfQueue2);
        System.out.println("Concat");
        printQueueOfQueue(concat);
        System.out.println();

        System.out.println("Flat");
        QueueOfQueue queueOfQueue3 = new QueueOfQueue();
        queueOfQueue3.addQueue(queue1);
        queueOfQueue3.addQueue(queue2);
        queueOfQueue3.addQueue(queue3);
        queueOfQueue3.addQueue(queue4);
        Queue flatConcatenada = queueOfQueue3.flat();
        printQueue(flatConcatenada);
        System.out.println();
        System.out.println();
    }


    public static void ejerecicio2_4(){
        StaticStack stack = new StaticStack.Builder().add(4).add(5).build();
        System.out.println("Pila creada con Builder:");
        printStack(stack);
        StaticSet set = new StaticSet.Builder().add(1).add(2).build();
        System.out.println("Conjunto creado con Builder:");
        printSet(set);
        StaticQueue queue1 = new StaticQueue(1, 2, 3);
        System.out.println("Cola creada con varios elementos pasados por parámetro:");
        printQueue(queue1);
    }

    public static void ejercicio2_6(){
        System.out.println("Pila creada con un límite:");
        Stack stack = new DynamicStackWithLimit(4);
        stack.add(1);
        stack.add(1);
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