package org.example.util;


import org.example.model.definition.Set;
import org.example.model.definition.Stack;
import org.example.model.dynamic.DynamicSet;
import org.example.model.normal.StaticStack;

public class StackUtil {

    // O(N * N * N) = O(N^3)
    public static Stack copy(Stack stack) {
        Stack stack1 = new StaticStack(); // C
        Stack stack2 = new StaticStack(); // C

        // O(N + C) ~ O(N)
        while (!stack.isEmpty()) { // N
            stack1.add(stack.getTop());  // C
            stack2.add(stack.getTop());  // C
            stack.remove();  // C
        }

        // O(N + C) ~ O(N)
        while (!stack1.isEmpty()) {  // N
            stack.add(stack1.getTop());  // C
            stack1.remove();  // C
        }

        // O(N + C) ~ O(N)
        while (!stack2.isEmpty()) {  // N
            stack1.add(stack2.getTop());  // C
            stack2.remove();  // C
        }

        return stack1;
    }

    public static void print(Stack stack) {
        Stack copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    public static int filter(Stack stack) {
        Stack copy = copy(stack);
        int count = 0;

        Stack stack1 = new StaticStack();
        Stack stack2 = new StaticStack();
        Stack stack3 = new StaticStack();

        while (!copy.isEmpty()) {
            stack3.add(copy.getTop());
            if (count % 2 == 0) {
                stack1.add(copy.getTop());
            } else {
                stack2.add(copy.getTop());
            }
            count++;
            copy.remove();
        }

        while(!stack2.isEmpty() && !stack3.isEmpty()) {
            stack2.remove();
            stack3.remove();
        }

        return stack3.getTop();
    }

    public static Stack invert(Stack stack){
        Stack aux= copy(stack);
        Stack inverted= new StaticStack();
        while(!aux.isEmpty()){
            inverted.add(aux.getTop());
            aux.remove();
        }
        return inverted;
    }

    public static int size(Stack stack){
        int count = 0;
        Stack auxStack = copy(stack);

        while(!auxStack.isEmpty()){
            count++;
            auxStack.remove();
        }
        return count;
    }

    // O(N + C) ~ O(N)
    public static int moveStackWithMinExtraction(Stack stackA, Stack stackB){
        int min = 0;  // C
        boolean flag = true;  // C
        // O(N + C) ~ O(N)
        while(!stackA.isEmpty()){  // N
            if (flag || stackA.getTop() < min){  // C
                if(!flag){  // C
                    stackB.add(min);  // C
                }
                min = stackA.getTop();  // C
                flag = false;  // C
            }
            else {
                stackB.add(stackA.getTop());  // C
            }
            stackA.remove();  // C
        }
        return min;
    }

    // O(N^3 + C + N + N^2 + C + N^2 + C) ~ O(N^3)
    public static Stack organiseStack(Stack originalStack){
        Stack stackA = copy(originalStack); // N^3
        Stack stackB = new StaticStack();  // C
        Stack stackC = new StaticStack();  // C
        Set auxSet = new DynamicSet();  // C

        // O(N + C) ~ O(N)
        while(!stackA.isEmpty()) {  // N
            auxSet.add(stackA.getTop());  // C
            stackA.remove();  // C
        }

        // O(N * (N + C)) ~ O(N^2)
        while(!auxSet.isEmpty()){  // N
            int element = auxSet.choose();  // N + C
            stackA.add(element);  // C
            auxSet.remove(element);  // C
        }

        int stackSize = size(stackA);  // C

        // O(N * (N + C + N + C)) ~ O(N^2)
        while(stackSize > 0){  // N
            int min = moveStackWithMinExtraction(stackA,stackB);  // N
            stackC.add(min);  // C
            stackSize--;  // C
            if(stackSize == 0){  // C
                break;  // C
            }
            min = moveStackWithMinExtraction(stackB, stackA);  // N
            stackC.add(min);  // C
            stackSize--;  // C
        }
        return stackC;  // C
    }
}