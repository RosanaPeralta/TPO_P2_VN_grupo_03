package org.example.Ejercicio2_1.model.util;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.model.definition.Stack;
import org.example.model.normal.StaticStack;
import org.example.util.StackUtil;

import static org.example.util.StackUtil.invert;
import static org.example.util.StackUtil.size;

public class QueueOfStacksUtil {

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

    public static int columnsCount(QueueOfStacks matriz){
        QueueOfStacks copy = copy(matriz);
        int colums = 0;
        while (!copy.isEmpty()){
            copy.remove();
            colums++;
        }
        return colums;
    }


    public static int traza(QueueOfStacks queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola vacía");
        }

        QueueOfStacks aux1 = new QueueOfStacks();
        QueueOfStacks aux2 = QueueOfStacksUtil.copy(queueOfStacks);
        int countColumns = QueueOfStacksUtil.columnsCount(queueOfStacks);
        int maxRowElements = 0;
        int traza = 0;
        boolean isSymmetric = true;

        // Verificamos que todas las columnas tienen la misma longitud
        while (!aux2.isEmpty()) {
            Stack column = aux2.getFirst();
            aux1.add(StackUtil.copy(aux2.getFirst()));
            aux2.remove();
            int countRows = 0;

            while (!column.isEmpty()) {
                column.remove();
                countRows++;
            }

            if (maxRowElements != 0 && countRows != maxRowElements) {
                isSymmetric = false;
            }

            maxRowElements = countRows;
        }

        // Caso Crítico: Matriz no simétrica
        if (!isSymmetric || maxRowElements != countColumns) {
            throw new RuntimeException("No se puede calcular la traza de una matriz no simétrica");
        }

        // Calculamos la traza
        for (int i = 0; i < countColumns; i++) {
            QueueOfStacks aux = QueueOfStacksUtil.copy(queueOfStacks);
            for (int j = 0; j < i; j++) { // Eliminamos exactamente i elementos
                aux.remove();
            }
            Stack row = aux.getFirst();
            for (int k = 0; k < i; k++) {
                row.remove();
            }
            traza += (int) row.getTop(); // Asegúrate que getTop devuelve un entero
        }
        return traza;
    }


    public static QueueOfStacks traspuesta(QueueOfStacks queueOfStacks) {

        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traspuesta de una matriz vacía");
        }

        QueueOfStacks traspuestaMatriz = new QueueOfStacks();
        QueueOfStacks copyQueueOfStacks;
        QueueOfStacks copyQueueOfStacksForMaxStack = copy(queueOfStacks);

        int queueSize = 0;
        int maxStackSize = 0;

        while (!copyQueueOfStacksForMaxStack.isEmpty()) {
            Stack auxStack = copyQueueOfStacksForMaxStack.getFirst();
            int stackSize = 0;
            Stack tempStack = new StaticStack();

            while (!auxStack.isEmpty()) {
                stackSize++;
                tempStack.add(auxStack.getTop());
                auxStack.remove();
            }

            while (!tempStack.isEmpty()) {
                auxStack.add(tempStack.getTop());
                tempStack.remove();
            }

            if (stackSize > maxStackSize) {
                maxStackSize = stackSize;
            }
            queueSize++;
            copyQueueOfStacksForMaxStack.remove();
        }

        for (int i = 0; i < maxStackSize; i++) {
            Stack transposeStack = new StaticStack();
            copyQueueOfStacks = copy(queueOfStacks);

            for (int j = 0; j < queueSize; j++) {
                Stack currentStack = copyQueueOfStacks.getFirst();
                Stack tempStack = new StaticStack();
                Integer element = null;

                while (!currentStack.isEmpty()) {
                    int value = currentStack.getTop();
                    currentStack.remove();
                    tempStack.add(value);
                    if (size(tempStack) == i + 1) {
                        element = value;
                    }
                }

                while (!tempStack.isEmpty()) {
                    currentStack.add(tempStack.getTop());
                    tempStack.remove();
                }

                if (element == null) {
                    transposeStack.add(0);
                } else {
                    transposeStack.add(element);
                }

                copyQueueOfStacks.remove();
                copyQueueOfStacks.add(currentStack);
            }

            traspuestaMatriz.add(transposeStack);
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
