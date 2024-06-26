package org.example.Ejercicio2_5.model.util;

import org.example.model.definition.Set;
import org.example.model.definition.Stack;
import org.example.model.dynamic.DynamicSet;
import org.example.model.normal.StaticStack;

import static org.example.util.StackUtil.copy;
import static org.example.util.StackUtil.size;

public class StackUtil {

    // O(N + C) ~ O(N)
    public static int getMin(Stack stackA, Stack stackB) {
        int min = 0;  // C
        boolean flag = true;  // C
        // O(N + C) ~ O(N)
        while (!stackA.isEmpty()) {  // N
            if (flag || stackA.getTop() < min) {  // C
                if (!flag) {  // C
                    stackB.add(min);  // C
                }
                min = stackA.getTop();  // C
                flag = false;  // C
            } else {
                stackB.add(stackA.getTop());  // C
            }
            stackA.remove();  // C
        }
        return min;
    }

    // O(N + C + N + N^2 + C + N^2 + C) ~ O(N^2)
    public static Stack organiseStack(Stack originalStack) {
        Stack stackA = copy(originalStack); // N
        Stack stackB = new StaticStack();  // C
        Stack stackC = new StaticStack();  // C
        Set auxSet = new DynamicSet();  // C

        // O(N + C) ~ O(N)
        while (!stackA.isEmpty()) {  // N
            auxSet.add(stackA.getTop());  // C
            stackA.remove();  // C
        }

        // O(N * (N + C)) ~ O(N^2)
        while (!auxSet.isEmpty()) {  // N
            int element = auxSet.choose();  // N + C
            stackA.add(element);  // C
            auxSet.remove(element);  // C
        }

        int stackSize = size(stackA);  // C

        // O(N * (N + C + N + C)) ~ O(N^2)
        while (stackSize > 0) {  // N
            int min = getMin(stackA, stackB);  // N
            stackC.add(min);  // C
            stackSize--;  // C
            if (stackSize == 0) {  // C
                break;  // C
            }
            min = getMin(stackB, stackA);  // N
            stackC.add(min);  // C
            stackSize--;  // C
        }
        return stackC;  // C
    }
}
