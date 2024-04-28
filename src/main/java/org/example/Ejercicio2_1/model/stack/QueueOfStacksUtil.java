package org.example.Ejercicio2_1.model.stack;

import org.example.Ejercicio2_1.model.QueueOfStacks;
import org.example.model.Queue;
import org.example.model.Stack;

import static org.example.stack.StackUtil.invert;

public class QueueOfStacksUtil {

    public void traza(QueueOfStacks queueOfStacks) {
        QueueOfStacks aux1 = new QueueOfStacks();
        QueueOfStacks aux2 = new QueueOfStacks();
        int countColumns = 0;
        int countRows = 0;
        int maxRowElements = 0;
        int traza = 0;

        // Caso Crítico: No hay elementos en la matríz

        if(queueOfStacks.isEmpty()) {
            throw new RuntimeException("No se puede calcular la traza de una cola vacía");
        }

        while(!queueOfStacks.isEmpty()){
            aux1.addStack(copyStack(queueOfStacks.getFirst()));
            aux2.addStack(copyStack(queueOfStacks.getFirst()));
            queueOfStacks.removeStack();
            countColumns++;
        }
        while (!aux1.isEmpty()) {
            queueOfStacks.addStack(aux1.getFirst());
            aux1.removeStack();
        }

        while(!aux2.isEmpty()){
            Stack row = aux2.getFirst();
            aux1.addStack(aux2.getFirst());
            aux2.removeStack();

            while(!row.isEmpty()){
                row.remove();
                countRows++;
            }

            if(countRows > maxRowElements){
                maxRowElements = countRows;
            }

            countRows = 0;
        }

        // Caso Crítico: Matriz no simétrica

        if (maxRowElements != countColumns){
            throw new RuntimeException("No se puede calcular la traza de una matriz no simétrica");
        }

        for(int i = 0; i <= countColumns-1; i++){
            QueueOfStacks aux = copy(queueOfStacks);
            for(int j = 0; j < countColumns-1-i; j++){
                aux.removeStack();
            }
            Stack row = copyStack(aux.getFirst());
            for(int k = 0; k < i; k++){
                row.remove();
            }
            traza += row.getTop();
        }
        System.out.println("La traza de la matriz es: " + traza);

    }

    public void traspuesta(QueueOfStacks queueOfStacks) {
        QueueOfStacks auxQueueOfStacks = new QueueOfStacks();
        QueueOfStacks copyQueueOfStack = copy(queueOfStacks);

        int queueSize = 0;
        if(queueOfStacks.isEmpty()){
            throw new RuntimeException("No se puede calcular la traspuesta de una matriz vacía");
        }
        int stackSize = 0;
        while(!copyQueueOfStack.isEmpty()){
            Stack auxStack = copyQueueOfStack.getFirst();
            stackSize = 0;
            while(!auxStack.isEmpty()){
                stackSize++;
                auxStack.remove();
            }
            queueSize++;
            copyQueueOfStack.removeStack();
        }

        for (int i = 0; i < stackSize; i++) {
            Stack transposeStack = new Stack();
            for (int j = 0; j < queueSize; j++) {
                Stack currentStack = queueOfStacks.getFirst();
                int topCurrentStack = currentStack.getTop();
                transposeStack.add(topCurrentStack);
                currentStack.remove();
                queueOfStacks.addStack(currentStack);
                queueOfStacks.removeStack();
            }
            auxQueueOfStacks.addStack(transposeStack);
        }

        for (int i = 0; i < queueSize; i++) {
            Stack finalStack = new Stack();
            for (int j = 0; j < stackSize; j++) {
                finalStack.add(auxQueueOfStacks.getFirst().getTop());
                auxQueueOfStacks.getFirst().remove();
            }
            auxQueueOfStacks.addStack(finalStack);
            auxQueueOfStacks.removeStack();
        }
        System.out.println(auxQueueOfStacks);
    }

    public static QueueOfStacks sumaMatricial(QueueOfStacks queueOfStacks1, QueueOfStacks queueOfStacks2){
        QueueOfStacks queueOfStacks_aux1= copy(queueOfStacks1);
        QueueOfStacks queueOfStacks_aux2= copy(queueOfStacks2);
        QueueOfStacks queueOfStacks_suma= new QueueOfStacks();

        while(!queueOfStacks_aux1.isEmpty() && !queueOfStacks_aux2.isEmpty()){
            Stack aux_stack1=queueOfStacks_aux1.getFirst();
            Stack aux_stack2=queueOfStacks_aux2.getFirst();
            Stack stack_suma= new Stack();
            while(!aux_stack1.isEmpty() && !aux_stack2.isEmpty()){
                stack_suma.add(aux_stack1.getTop()+aux_stack2.getTop());
                aux_stack1.remove();
                aux_stack2.remove();
            }
            stack_suma=invert(stack_suma);
            queueOfStacks_suma.addStack(stack_suma);
            queueOfStacks_aux1.removeStack();
            queueOfStacks_aux2.removeStack();
        }

        return queueOfStacks_suma;
    }

    public static Stack copyStack(Stack stack){
        Stack stack1= new Stack();
        Stack stack2= new Stack();

        while (!stack.isEmpty()){
            stack1.add(stack.getTop());
            stack2.add(stack.getTop());
            stack.remove();
        }
        while(!stack1.isEmpty()){
            stack.add(stack1.getTop());
            stack1.remove();
        }
        while(!stack2.isEmpty()){
            stack1.add(stack2.getTop());
            stack2.remove();
        }
        return stack1;
    }

    public static Queue copyQueue(Queue queue){
        Queue queue1= new Queue();
        Queue queue2= new Queue();

        while (!queue.isEmpty()){
            queue1.add(queue.getFirst());
            queue2.add(queue.getFirst());
            queue.remove();
        }
        while(!queue1.isEmpty()){
            queue.add(queue1.getFirst());
            queue1.remove();
        }
        return queue2;
    }

    public static QueueOfStacks copy(QueueOfStacks queueOfStacks){
        QueueOfStacks aux= new QueueOfStacks();
        QueueOfStacks aux2= new QueueOfStacks();

        while(!queueOfStacks.isEmpty()){
            aux.addStack(copyStack(queueOfStacks.getFirst()));
            aux2.addStack(copyStack(queueOfStacks.getFirst()));
            queueOfStacks.removeStack();
        }
        while(!aux.isEmpty()){
            queueOfStacks.addStack(aux.getFirst());
            aux.removeStack();
        }
        return aux2;
    }

}
