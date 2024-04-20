package org.example.stack;


import org.example.model.IStack;
import org.example.model.Stack;

public class StackUtil {

    public static IStack copy(IStack stack) {
        IStack stack1 = new Stack();
        IStack stack2 = new Stack();

        while (!stack.isEmpty()) {
            stack1.add(stack.getTop());
            stack2.add(stack.getTop());
            stack.remove();
        }

        while (!stack1.isEmpty()) {
            stack.add(stack1.getTop());
            stack1.remove();
        }

        while (!stack2.isEmpty()) {
            stack1.add(stack2.getTop());
            stack2.remove();
        }

        return stack1;
    }

    public static void print(IStack stack) {
        IStack copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    public static int filter(IStack stack) {
        IStack copy = copy(stack);
        int count = 0;

        IStack stack1 = new Stack();
        IStack stack2 = new Stack();
        IStack stack3 = new Stack();

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

}
