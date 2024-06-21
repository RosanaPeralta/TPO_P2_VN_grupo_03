package org.example.util;


import org.example.model.definition.Stack;
import org.example.model.normal.StaticStack;

public class StackUtil {

    // O(N + N + N) = O(N)
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

    public static void printStack(Stack stack) {
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

        while (!stack2.isEmpty() && !stack3.isEmpty()) {
            stack2.remove();
            stack3.remove();
        }

        return stack3.getTop();
    }

    public static Stack invert(Stack stack) {
        Stack aux = copy(stack);
        Stack inverted = new StaticStack();
        while (!aux.isEmpty()) {
            inverted.add(aux.getTop());
            aux.remove();
        }
        return inverted;
    }

    public static int size(Stack stack) {
        int count = 0;
        Stack auxStack = copy(stack);

        while (!auxStack.isEmpty()) {
            count++;
            auxStack.remove();
        }
        return count;
    }

}