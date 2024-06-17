package org.example.model.normal;

import org.example.model.definition.Set;

import java.util.Arrays;
import java.util.Random;

public class StaticSet implements Set {
    
    private static final int MAX = 10000;
    
    private int[] array;
    private int count;
    
    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {
                return;
            }
        }
        this.array[count] = a;
        this.count++;
    }

    public void remove(int a) {
        for(int i = 0; i < count; i++) {
            if(this.array[i] == a) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticSet set = (StaticSet) o;
        if (count != set.count) return false;

        int[] array1Copy = Arrays.copyOf(array, count);
        int[] array2Copy = Arrays.copyOf(set.array, count);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (array1Copy[i] != array2Copy[i]) {
                return false;
            }
        }
        return true;
    }

}
