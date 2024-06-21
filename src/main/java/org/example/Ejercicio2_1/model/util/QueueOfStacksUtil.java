package org.example.Ejercicio2_1.model.util;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.model.definition.Stack;
import org.example.model.normal.StaticStack;
import org.example.util.StackUtil;

import static org.example.util.StackUtil.invert;

public class QueueOfStacksUtil {

    public static int traza(QueueOfStacks queueOfStacks) {
        QueueOfStacks aux1 = new QueueOfStacks();
        QueueOfStacks aux2 = new QueueOfStacks();
        int countColumns = 0;
        int countRows = 0;
        int maxRowElements = 0;
        int traza = 0;

        // Caso Crítico: No hay elementos en la matríz

        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola vacía");
        }

        while (!queueOfStacks.isEmpty()) {
            aux1.add(StackUtil.copy(queueOfStacks.getFirst()));
            aux2.add(StackUtil.copy(queueOfStacks.getFirst()));
            queueOfStacks.remove();
            countColumns++;
        }
        while (!aux1.isEmpty()) {
            queueOfStacks.add(aux1.getFirst());
            aux1.remove();
        }

        while (!aux2.isEmpty()) {
            Stack column = aux2.getFirst();
            aux1.add(aux2.getFirst());
            aux2.remove();

            while (!column.isEmpty()) {
                column.remove();
                countRows++;
            }

            if (countRows > maxRowElements) {
                maxRowElements = countRows;
            }

            countRows = 0;
        }

        // Caso Crítico: Matriz no simétrica

        if (maxRowElements != countColumns) {
            throw new RuntimeException("No se puede calcular la traza de una matriz no simétrica");
        }

        for (int i = 0; i <= countColumns - 1; i++) {
            QueueOfStacks aux = copy(queueOfStacks);
            for (int j = 0; j < countColumns - 1 - i; j++) {
                aux.remove();
            }
            Stack row = StackUtil.copy(aux.getFirst());
            for (int k = 0; k < i; k++) {
                row.remove();
            }
            traza += row.getTop();
        }
        return traza;

    }

    public static QueueOfStacks traspuesta(QueueOfStacks queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traspuesta de una matriz vacía");
        }
        QueueOfStacks traspuestaMatriz = new QueueOfStacks();
        QueueOfStacks copyQueueOfStack = copy(queueOfStacks);
        QueueOfStacks copyQueueOfStack1 = copy(queueOfStacks);
        int queueSize = 0;
        int stackSize = 0;
        int previousStackSize = -1;
        while (!copyQueueOfStack.isEmpty()) {
            Stack auxStack = copyQueueOfStack.getFirst();
            stackSize = 0;
            while (!auxStack.isEmpty()) {
                stackSize++;
                auxStack.remove();
            }
            if (previousStackSize != -1 && previousStackSize != stackSize) {
                throw new RuntimeException("Se encontró una inconsistencia en las alturas de las pilas");
            }
            previousStackSize = stackSize;
            queueSize++;
            copyQueueOfStack.remove();
        }

        for (int i = 0; i < stackSize; i++) {
            Stack transposeStack = new StaticStack();
            for (int j = 0; j < queueSize; j++) {
                Stack currentStack = copyQueueOfStack1.getFirst();
                int topCurrentStack = currentStack.getTop();
                transposeStack.add(topCurrentStack);
                currentStack.remove();
                copyQueueOfStack1.add(currentStack);
                copyQueueOfStack1.remove();
            }
            traspuestaMatriz.add(transposeStack);
        }

        for (int i = 0; i < queueSize; i++) {
            Stack finalStack = new StaticStack();
            for (int j = 0; j < stackSize; j++) {
                finalStack.add(traspuestaMatriz.getFirst().getTop());
                traspuestaMatriz.getFirst().remove();
            }
            traspuestaMatriz.add(finalStack);
            traspuestaMatriz.remove();
        }
        return traspuestaMatriz;
    }

    public static QueueOfStacks sumaMatricial(QueueOfStacks queueOfStacks1, QueueOfStacks queueOfStacks2) {
        QueueOfStacks queueOfStacks_aux1 = copy(queueOfStacks1);
        QueueOfStacks queueOfStacks_aux2 = copy(queueOfStacks2);
        QueueOfStacks queueOfStacks_suma = new QueueOfStacks();

        while (!queueOfStacks_aux1.isEmpty() && !queueOfStacks_aux2.isEmpty()) {
            Stack aux_stack1 = queueOfStacks_aux1.getFirst();
            Stack aux_stack2 = queueOfStacks_aux2.getFirst();
            Stack stack_suma = new StaticStack();
            while (!aux_stack1.isEmpty() && !aux_stack2.isEmpty()) {
                stack_suma.add(aux_stack1.getTop() + aux_stack2.getTop());
                aux_stack1.remove();
                aux_stack2.remove();
            }
            stack_suma = invert(stack_suma);
            queueOfStacks_suma.add(stack_suma);
            queueOfStacks_aux1.remove();
            queueOfStacks_aux2.remove();
        }

        return queueOfStacks_suma;
    }

    public static QueueOfStacks copy(QueueOfStacks queueOfStacks) {
        QueueOfStacks aux = new QueueOfStacks();
        QueueOfStacks aux2 = new QueueOfStacks();

        while (!queueOfStacks.isEmpty()) {
            aux.add(StackUtil.copy(queueOfStacks.getFirst()));
            aux2.add(StackUtil.copy(queueOfStacks.getFirst()));
            queueOfStacks.remove();
        }
        while (!aux.isEmpty()) {
            queueOfStacks.add(aux.getFirst());
            aux.remove();
        }
        return aux2;
    }

    public static void print(QueueOfStacks queueOfStacks) {
        QueueOfStacks aux = copy(queueOfStacks);
        while (!aux.isEmpty()) {
            Stack stack = aux.getFirst();
            while (!stack.isEmpty()) {
                System.out.print(stack.getTop() + " ");
                stack.remove();
            }
            System.out.println();
            aux.remove();
        }
    }

}
