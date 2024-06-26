package org.example.model.normal;


import org.example.model.definition.PriorityQueue;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int LENGTH = 10000;

    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        values = new int[LENGTH];
        priorities = new int[LENGTH];
        count = 0;
    }

    @Override
    public void add(int a, int priority) {
        if (this.isEmpty() || priorities[count - 1] <= priority) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        if (priority <= priorities[0]) {
            for (int i = count - 1; i >= 0; i--) {
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }
            values[0] = a;
            priorities[0] = priority;
            count++;
            return;
        }

        int index = -1;
        for (int i = 1; i < count; i++) {
            if (priorities[i] > priority) {
                index = i;
                break;
            }
        }

        for (int i = count - 1; i >= index; i--) {
            values[i + 1] = values[i];
            priorities[i + 1] = priorities[i];
        }
        values[index] = a;
        priorities[index] = priority;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        return values[0];
    }

    @Override
    public int getPriority() {
        return priorities[0];
    }
}
