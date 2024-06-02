package org.example.stack;


import org.example.model.DynamicSet;
import org.example.model.IStack;
import org.example.model.Set;
import org.example.model.Stack;

public class StackUtil {

    // O(N * N * N) = O(N^3)
    public static IStack copy(IStack stack) {
        IStack stack1 = new Stack(); // C
        IStack stack2 = new Stack(); // C

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

    public static Stack invert(Stack stack){
        IStack aux= copy(stack);
        Stack inverted= new Stack();
        while(!aux.isEmpty()){
            inverted.add(aux.getTop());
            aux.remove();
        }
        return inverted;
    }

    public static int size(IStack stack){
        int count = 0;
        IStack auxStack = copy(stack);

        while(!auxStack.isEmpty()){
            count++;
            auxStack.remove();
        }
        return count;
    }

    // O(N + C) ~ O(N)
    public static int moveStackWithMinExtraction(IStack stackA, IStack stackB){
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
    public static IStack organiseStack(IStack originalStack){
        IStack stackA = copy(originalStack); // N^3
        IStack stackB = new Stack();  // C
        IStack stackC = new Stack();  // C
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